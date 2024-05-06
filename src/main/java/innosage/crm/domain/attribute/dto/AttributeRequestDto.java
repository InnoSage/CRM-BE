package innosage.crm.domain.attribute.dto;

import lombok.Getter;

public class AttributeRequestDto {

    @Getter
    public static class addAttribute {

        private String dataType;
        private String name;
        private String description;
    }

    @Getter
    public static class updateAttribute {

        private String dataType;
        private String name;
        private String description;
    }
}
