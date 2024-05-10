package innosage.crm.domain.sort.dto;

import lombok.Getter;

public class SortRequestDto {

    @Getter
    public static class addSort {

        private Long targetAttributeId;
        private String sortType;
    }
}
