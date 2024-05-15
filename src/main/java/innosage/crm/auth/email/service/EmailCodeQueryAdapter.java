package innosage.crm.auth.email.service;

import innosage.crm.auth.email.EmailCode;
import innosage.crm.auth.email.repository.EmailCodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailCodeQueryAdapter {

    private final EmailCodeRepository emailCodeRepository;

    public EmailCode findByCode(String code) {
        return emailCodeRepository.findByCode(code);
    }
}
