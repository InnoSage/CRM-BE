package innosage.crm.domain.sheet.dto;

import lombok.Getter;

public class SheetRequestDto {

    @Getter
    public static class addSheet {

        private String name;
    }

    @Getter
    public static class updateSheet {

        private String name;
    }
}
