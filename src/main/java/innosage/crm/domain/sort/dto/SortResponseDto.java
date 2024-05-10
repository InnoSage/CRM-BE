package innosage.crm.domain.sort.dto;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SortResponseDto {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class addSort {

        private Long sortId;
    }
}
