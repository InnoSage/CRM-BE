package innosage.crm.domain.attribute.dto;

import lombok.Getter;

import java.util.Map;

public class AttributeRequestDto {

    @Getter
    public static class addAttribute {

        private String dataType;
        private String name;
        private String description;
        private Map<String, Object> data;
    }

    @Getter
    public static class updateAttribute {

        private String dataType;
        private String name;
        private String description;
        private Map<String, Object> data;
    }
}
