package innosage.crm.domain.attribute.useroption.service;

import innosage.crm.domain.attribute.Attribute;
import innosage.crm.domain.attribute.service.AttributeQueryAdapter;
import innosage.crm.domain.attribute.useroption.UserOption;
import innosage.crm.domain.attribute.useroption.dto.UserOptionRequestDto;
import innosage.crm.domain.attribute.useroption.dto.UserOptionResponseDto;
import innosage.crm.domain.attribute.useroption.mapper.UserOptionMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Slf4j
public class UserOptionService {

    private final UserOptionCommandAdapter userOptionCommandAdapter;
    private final UserOptionQueryAdapter userOptionQueryAdapter;
    private final AttributeQueryAdapter attributeQueryAdapter;

    @Transactional
    public UserOptionResponseDto.addUserOption addUserOption(Long attributeId, UserOptionRequestDto.addUserOption request) {
        Attribute attribute = attributeQueryAdapter.findById(attributeId);
        UserOption userOption = UserOptionMapper.toUserOption(request.getName(), request.getEmail(), attribute);
        UserOption savedUserOption = userOptionCommandAdapter.addUserOption(userOption);

        return UserOptionMapper.toAddUserOption(savedUserOption);
    }

    @Transactional
    public UserOptionResponseDto.updateUserOption updateUserOption(Long userOptionId, UserOptionRequestDto.updateUserOption request) {
        UserOption userOption = userOptionQueryAdapter.findById(userOptionId);
        userOption.update(request.getName(), request.getEmail());

        return UserOptionMapper.toUpdateUserOption(userOption);
    }

    @Transactional
    public void deleteUserOption(Long userOptionId) {
        UserOption userOption = userOptionQueryAdapter.findById(userOptionId);
        userOptionCommandAdapter.deleteUserOption(userOption);
    }
}
