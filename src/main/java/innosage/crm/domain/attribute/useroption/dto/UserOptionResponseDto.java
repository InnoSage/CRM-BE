package innosage.crm.domain.attribute.useroption.dto;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserOptionResponseDto {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class addUserOption {

        private Long userId;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class updateUserOption {

        private Long userId;
    }
}
