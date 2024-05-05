package innosage.crm.deal.dto;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DealResponseDto {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class addDeal {

            private Long dealId;
    }
}
