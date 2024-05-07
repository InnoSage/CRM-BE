package innosage.crm.domain.sheet.dto;

import innosage.crm.domain.attribute.dto.AttributeResponseDto;
import innosage.crm.domain.deal.dto.DealResponseDto;
import innosage.crm.domain.sheet.mapper.SheetMapper;
import lombok.*;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SheetResponseDto {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class getSheet {
        private Long sheetId;
        private String sheetName;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class getSheets {
        private List<SheetResponseDto.getSheet> sheets;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class getSheetDetails {
        private Long sheetId;
        private String sheetName;
        private List<AttributeResponseDto.getAttribute> attributes;
        private List<DealResponseDto.getDeal> deals;
    }
}
