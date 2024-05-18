package innosage.crm.domain.attribute.useroption.dto;

import lombok.Getter;

public class UserOptionRequestDto {

    @Getter
    public static class addUserOption {

        private String name;
        private String email;
    }

    @Getter
    public static class updateUserOption {

        private String name;
        private String email;
    }
}
