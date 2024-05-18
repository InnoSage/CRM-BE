package innosage.crm.domain.attribute.useroption.service;

import innosage.crm.domain.attribute.useroption.UserOption;
import innosage.crm.domain.attribute.useroption.repository.UserOptionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserOptionCommandAdapter {

    private final UserOptionRepository userOptionRepository;

    public UserOption addUserOption(UserOption userOption) {
        return userOptionRepository.save(userOption);
    }

    public void deleteUserOption(UserOption userOption) {
        userOptionRepository.delete(userOption);
    }
}
