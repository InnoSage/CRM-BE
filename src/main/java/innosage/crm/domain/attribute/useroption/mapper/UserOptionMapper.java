package innosage.crm.domain.attribute.useroption.mapper;

import innosage.crm.domain.attribute.Attribute;
import innosage.crm.domain.attribute.useroption.UserOption;
import innosage.crm.domain.attribute.useroption.dto.UserOptionResponseDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserOptionMapper {

    public static UserOption toUserOption(String name, String email, Attribute attribute) {
        return UserOption.builder()
                .name(name)
                .email(email)
                .attribute(attribute)
                .build();
    }

    public static UserOptionResponseDto.addUserOption toAddUserOption(UserOption userOption) {
        return UserOptionResponseDto.addUserOption.builder()
                .userId(userOption.getId())
                .build();
    }

    public static UserOptionResponseDto.updateUserOption toUpdateUserOption(UserOption userOption) {
        return UserOptionResponseDto.updateUserOption.builder()
                .userId(userOption.getId())
                .build();
    }
}
