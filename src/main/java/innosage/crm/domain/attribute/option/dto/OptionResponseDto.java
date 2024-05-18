package innosage.crm.domain.attribute.option.dto;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OptionResponseDto {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class addOption {

        private Long optionId;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class updateOption {

        private Long optionId;
    }
}
