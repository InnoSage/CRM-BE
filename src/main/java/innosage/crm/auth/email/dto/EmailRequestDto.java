package innosage.crm.auth.email.dto;

import lombok.Getter;

public class EmailRequestDto {

    @Getter
    public static class sendEmail {

        private String email;
    }

    @Getter
    public static class verifyEmail {

        private String email;
        private String code;
    }
}
