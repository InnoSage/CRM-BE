package innosage.crm.domain.attribute.mapper;

import innosage.crm.domain.attribute.Attribute;
import innosage.crm.domain.attribute.AttributeType;
import innosage.crm.domain.attribute.dto.AttributeResponseDto;
import innosage.crm.domain.attribute.strategy.AttributeStrategyFactory;
import innosage.crm.domain.sheet.Sheet;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AttributeMapper {

    public static Attribute toAttribute(String name, String type, String description, Sheet sheet) {
        return Attribute.builder()
                .name(name)
                .type(AttributeType.valueOf(type))
                .description(description)
                .sheet(sheet)
                .build();
    }

    public static AttributeResponseDto.addAttribute toAddAttribute(Attribute attribute) {
        return AttributeResponseDto.addAttribute.builder()
                .attributeId(attribute.getId())
                .name(attribute.getName())
                .dataType(attribute.getType().name())
                .description(attribute.getDescription())
                .data(AttributeStrategyFactory.getStrategy(attribute.getType()).getData(attribute))
                .build();
    }

    public static AttributeResponseDto.updateAttribute toUpdateAttribute(Attribute attribute) {
        return AttributeResponseDto.updateAttribute.builder()
                .attributeId(attribute.getId())
                .build();
    }

    public static AttributeResponseDto.getAttribute toGetAttribute(Attribute attribute) {
        return AttributeResponseDto.getAttribute.builder()
                .attributeId(attribute.getId())
                .attributeName(attribute.getName())
                .dataType(attribute.getType().name())
                .data(AttributeStrategyFactory.getStrategy(attribute.getType()).getData(attribute))
                .build();
    }

    public static List<AttributeResponseDto.getAttribute> toGetAttributeList(List<Attribute> attributes) {
        return attributes.stream()
                .map(AttributeMapper::toGetAttribute)
                .collect(Collectors.toList());
    }
}
