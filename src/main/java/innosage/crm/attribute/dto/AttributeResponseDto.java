package innosage.crm.attribute.dto;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AttributeResponseDto {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class addAttribute {

        private String dataType;
        private String name;
        private String description;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class updateAttribute {

        private Long attributeId;
    }
}
