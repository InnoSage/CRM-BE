package innosage.crm.auth.email.service;

import innosage.crm.auth.email.EmailCode;
import innosage.crm.auth.email.dto.EmailRequestDto;
import innosage.crm.auth.email.mapper.EmailCodeMapper;
import innosage.crm.global.exception.common.GeneralException;
import innosage.crm.global.exception.common.code.GlobalErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender javaMailSender;
    private final EmailCodeCommandAdapter emailCodeCommandAdapter;
    private final EmailCodeQueryAdapter emailCodeQueryAdapter;
    private Integer code;

    public void makeRandomNumber() {
        Random r = new Random();
        String randomNumber = "";
        for(int i = 0; i < 6; i++) {
            randomNumber += Integer.toString(r.nextInt(10));
        }

        code = Integer.parseInt(randomNumber);
    }

    public String joinEmail(EmailRequestDto.sendEmail request) {
        makeRandomNumber();
        String setFrom = "koojun99@naver.com"; // email-config에 설정한 자신의 이메일 주소를 입력
        String toMail = request.getEmail();
        String title = "회원 가입 인증 이메일 입니다."; // 이메일 제목
        String content =
                "CRM 서비스를 방문해주셔서 감사합니다." + 	//html 형식으로 작성 !
                        "<br><br>" +
                        "인증 번호는 " + code + "입니다." +
                        "<br>" +
                        "인증번호를 제대로 입력해주세요!"; //이메일 내용 삽입
        sendMail(setFrom, toMail, title, content);
        return Integer.toString(code);
    }

    public void sendMail(String setFrom, String toMail, String title, String content) {
        MimeMessage message = javaMailSender.createMimeMessage();//JavaMailSender 객체를 사용하여 MimeMessage 객체를 생성
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message,true,"utf-8");//이메일 메시지와 관련된 설정을 수행합니다.
            // true를 전달하여 multipart 형식의 메시지를 지원하고, "utf-8"을 전달하여 문자 인코딩을 설정
            helper.setFrom(setFrom);//이메일의 발신자 주소 설정
            helper.setTo(toMail);//이메일의 수신자 주소 설정
            helper.setSubject(title);//이메일의 제목을 설정
            helper.setText(content,true);//이메일의 내용 설정 두 번째 매개 변수에 true를 설정하여 html 설정으로한다.
            javaMailSender.send(message);
        } catch (MessagingException e) {//이메일 서버에 연결할 수 없거나, 잘못된 이메일 주소를 사용하거나, 인증 오류가 발생하는 등 오류
            // 이러한 경우 MessagingException이 발생
            e.printStackTrace();//e.printStackTrace()는 예외를 기본 오류 스트림에 출력하는 메서드
        }
        EmailCode emailCode = EmailCodeMapper.toEmailCode(toMail, code);
        emailCodeCommandAdapter.saveEmailCode(emailCode);
    }

    public void checkCode(EmailRequestDto.verifyEmail request) {
        String emailCode = request.getCode();
        EmailCode savedCode = emailCodeQueryAdapter.findByCode(request.getCode());
        if((emailCode== null) || (!emailCode.equals(savedCode.getCode()))) {
            throw new GeneralException(GlobalErrorCode.INVALID_EMAIL_CODE);
        } else {
            System.out.println("인증 성공");
            emailCodeCommandAdapter.deleteEmailCode(savedCode);
        }
    }
}
