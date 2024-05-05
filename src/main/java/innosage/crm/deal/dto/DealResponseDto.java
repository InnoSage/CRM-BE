package innosage.crm.deal.dto;

import innosage.crm.content.dto.ContentResponseDto;
import lombok.*;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DealResponseDto {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class addDeal {

            private Long dealId;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class getDeal {

        private Long dealId;
        private Long companyId;
        private String companyName;
        private List<ContentResponseDto.getContent> contents;
    }
}
