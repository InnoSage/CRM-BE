package innosage.crm.domain.filter.dto;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FilterResponseDto {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class addFilter {

        private Long filterId;
    }
}
