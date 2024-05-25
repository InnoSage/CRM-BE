package innosage.crm.domain.attribute.dto;

import lombok.*;

import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AttributeResponseDto {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class addAttribute {

        private Long attributeId;
        private String dataType;
        private String name;
        private String description;
        private Map<String, Object> data;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class getAttribute {

        private Long attributeId;
        private String attributeName;
        private String dataType;
        private Map<String, Object> data;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class updateAttribute {

        private Long attributeId;
    }
}
