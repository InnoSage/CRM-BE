package innosage.crm.domain.content.dto;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ContentResponseDto {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class getContent {

        private Long attributeId;
        private String attributeName;
        private String dataType;
        private String value;
    }
}
