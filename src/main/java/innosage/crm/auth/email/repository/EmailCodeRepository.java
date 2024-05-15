package innosage.crm.auth.email.repository;

import innosage.crm.auth.email.EmailCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailCodeRepository extends JpaRepository<EmailCode, Long> {
    EmailCode findByCode(String code);
}
