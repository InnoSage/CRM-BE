package innosage.crm.domain.filter.dto;

import lombok.Getter;

public class FilterRequestDto {

    @Getter
    public static class addFilter {

        private Long targetAttributeId;
        private String keyword;
        private String filterType;
    }
}
