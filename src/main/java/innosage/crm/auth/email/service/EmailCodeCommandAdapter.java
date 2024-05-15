package innosage.crm.auth.email.service;

import innosage.crm.auth.email.EmailCode;
import innosage.crm.auth.email.repository.EmailCodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailCodeCommandAdapter {

    private final EmailCodeRepository emailCodeRepository;

    public void saveEmailCode(EmailCode emailCode) {
        emailCodeRepository.save(emailCode);
    }

    public void deleteEmailCode(EmailCode emailCode) {
        emailCodeRepository.delete(emailCode);
    }
}
