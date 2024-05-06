package innosage.crm.content.mapper;

import innosage.crm.attribute.Attribute;
import innosage.crm.content.Content;
import innosage.crm.content.dto.ContentResponseDto;
import innosage.crm.deal.Deal;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ContentMapper {

    public static Content toContent(String value, Attribute attribute, Deal deal) {
        return Content.builder()
                .value(value)
                .attribute(attribute)
                .deal(deal)
                .build();
    }

    public static ContentResponseDto.getContent toGetContent(Content content) {
        return ContentResponseDto.getContent.builder()
                .attributeId(content.getAttribute().getId())
                .value(content.getValue())
                .build();
    }

    public static List<ContentResponseDto.getContent> toGetContentList(List<Content> contents) {
        return contents.stream()
                .map(ContentMapper::toGetContent)
                .collect(Collectors.toList());
    }
}
