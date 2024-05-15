package innosage.crm.auth.email.controller;

import innosage.crm.auth.email.dto.EmailRequestDto;
import innosage.crm.auth.email.service.EmailService;
import innosage.crm.global.common.CommonResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users/email")
public class EmailController {

    private final EmailService emailService;

    @PostMapping("/code")
    @Operation(summary = "이메일 인증 코드 전송 ✔\uFE0F")
    public CommonResponse sendEmail(
            @RequestBody EmailRequestDto.sendEmail request) {
        return CommonResponse.onSuccess(emailService.joinEmail(request));
    }

    @PostMapping("/verify")
    @Operation(summary = "이메일 인증 코드 확인 ✔\uFE0F")
    public CommonResponse verifyEmail(
            @RequestBody EmailRequestDto.verifyEmail request) {
        emailService.checkCode(request);
        return CommonResponse.onSuccess(null);
    }
}
