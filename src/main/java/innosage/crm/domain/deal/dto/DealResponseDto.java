package innosage.crm.domain.deal.dto;

import innosage.crm.domain.attribute.dto.AttributeResponseDto;
import innosage.crm.domain.content.Content;
import innosage.crm.domain.content.dto.ContentResponseDto;
import innosage.crm.domain.note.dto.NoteResponseDto;
import lombok.*;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DealResponseDto {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class addDeal {

        private Long dealId;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class getDeal {

        private Long companyId;
        private String companyName;
        private List<ContentResponseDto.getContent> attributes;
        private List<NoteResponseDto.getNote> notes;
    }
}
