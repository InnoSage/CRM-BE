package innosage.crm.sheet.dto;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SheetResponseDto {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class getSheets {
        private Long sheetId;
        private String sheetName;
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
