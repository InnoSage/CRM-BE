package innosage.crm.domain.content.mapper;

import innosage.crm.domain.attribute.Attribute;
import innosage.crm.domain.attribute.AttributeType;
import innosage.crm.domain.content.Content;
import innosage.crm.domain.content.dto.ContentResponseDto;
import innosage.crm.domain.deal.Deal;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ContentMapper {

    public static Content toContent(Object value, Attribute attribute, Deal deal) {
        Object convertedValue = convertValueByType(value, attribute.getType());
        return Content.builder()
                .value(convertedValue)
                .attribute(attribute)
                .deal(deal)
                .build();
    }

    public static ContentResponseDto.addContent toAddContent(Content content) {
        return ContentResponseDto.addContent.builder()
                .contentId(content.getId())
                .build();
    }

    private static Object convertValueByType(Object value, AttributeType type) {
        switch (type) {
            case NUMBER:
            case CURRENCY:
                if (value instanceof Integer) {
                    return value;
                } else if (value instanceof String) {
                    try {
                        return Integer.parseInt((String) value);
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("Invalid number format: " + value);
                    }
                } else {
                    throw new IllegalArgumentException("Unsupported value type for number/currency: " + value.getClass().getName());
                }
            case TEXT:
            case USER:
                return value.toString();
            case DATE:
                if (value instanceof LocalDate) {
                    return value;
                } else if (value instanceof String) {
                    try {
                        return LocalDate.parse((String) value);
                    } catch (Exception e) {
                        throw new IllegalArgumentException("Invalid date format: " + value);
                    }
                } else {
                    throw new IllegalArgumentException("Unsupported value type for date: " + value.getClass().getName());
                }
            case SELECT:
            case MULTISELECT:
                if (value instanceof List) {
                    List<?> list = (List<?>) value;
                    return list.stream()
                            .map(v -> {
                                if (v instanceof Integer) {
                                    return (Integer) v;
                                } else if (v instanceof String) {
                                    return Integer.parseInt((String) v);
                                } else {
                                    throw new IllegalArgumentException("Unsupported value type in list for select/multiselect: " + v.getClass().getName());
                                }
                            })
                            .collect(Collectors.toList());
                } else {
                    throw new IllegalArgumentException("Unsupported value type for select/multiselect: " + value.getClass().getName());
                }
            case CHECKBOX:
                if (value instanceof Boolean) {
                    return value;
                } else if (value instanceof String) {
                    return Boolean.parseBoolean((String) value);
                } else {
                    throw new IllegalArgumentException("Unsupported value type for checkbox: " + value.getClass().getName());
                }
            default:
                throw new IllegalArgumentException("Unsupported attribute type: " + type);
        }
    }

    public static ContentResponseDto.getContent toGetContent(Content content) {
        return ContentResponseDto.getContent.builder()
                .attributeId(content.getAttribute().getId())
                .attributeName(content.getAttribute().getName())
                .dataType(content.getAttribute().getType().name())
                .value(content.getValue())
                .build();
    }

    public static List<ContentResponseDto.getContent> toGetContentList(List<Content> contents) {
        return contents.stream()
                .map(ContentMapper::toGetContent)
                .collect(Collectors.toList());
    }

    public static ContentResponseDto.updateContent toUpdateContent(Content content) {
        return ContentResponseDto.updateContent.builder()
                .updatedContentId(content.getId())
                .build();
    }
}
