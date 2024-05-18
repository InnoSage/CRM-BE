package innosage.crm.domain.attribute.option.dto;

import lombok.Getter;

public class OptionRequestDto {

    @Getter
    public static class addOption {

        private String name;
    }

    @Getter
    public static class updateOption {

        private String name;
    }
}
