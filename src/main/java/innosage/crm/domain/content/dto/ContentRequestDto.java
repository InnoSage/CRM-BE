package innosage.crm.domain.content.dto;

import lombok.Getter;

public class ContentRequestDto {

    @Getter
    public static class addContent {

        private Long attributeId;
        private String value;
    }
}