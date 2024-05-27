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

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class getFilter {

        private Long filterId;
        private Long targetAttributeId;
        private String keyword;
        private String filterType;
    }
}
