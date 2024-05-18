package innosage.crm.domain.attribute.useroption.service;

import innosage.crm.domain.attribute.useroption.UserOption;
import innosage.crm.domain.attribute.useroption.repository.UserOptionRepository;
import innosage.crm.global.exception.common.GeneralException;
import innosage.crm.global.exception.common.code.GlobalErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserOptionQueryAdapter {

    private final UserOptionRepository userOptionRepository;

    public UserOption findById(Long userOptionId) {
        return userOptionRepository.findById(userOptionId)
                .orElseThrow(() -> new GeneralException(GlobalErrorCode.OPTION_NOT_FOUND));
    }
}
