package innosage.crm.auth.email.mapper;

import innosage.crm.auth.email.EmailCode;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EmailCodeMapper {

    public static EmailCode toEmailCode(String email, Integer code) {
        return EmailCode.builder()
                .email(email)
                .code(String.valueOf(code))
                .build();
    }
}
