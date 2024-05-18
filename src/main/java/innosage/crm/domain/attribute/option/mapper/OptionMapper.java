package innosage.crm.domain.attribute.option.mapper;

import innosage.crm.domain.attribute.Attribute;
import innosage.crm.domain.attribute.option.Option;
import innosage.crm.domain.attribute.option.dto.OptionResponseDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.CodePointLength;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OptionMapper {

    public static Option toOption(String name, Attribute attribute) {
        return Option.builder()
                .name(name)
                .attribute(attribute)
                .build();
    }

    public static OptionResponseDto.addOption toAddOption(Option option) {
        return OptionResponseDto.addOption.builder()
                .optionId(option.getId())
                .build();
    }

    public static OptionResponseDto.updateOption toUpdateOption(Option option) {
        return OptionResponseDto.updateOption.builder()
                .optionId(option.getId())
                .build();
    }
}
