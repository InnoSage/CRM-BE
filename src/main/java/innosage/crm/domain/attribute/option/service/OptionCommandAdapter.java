package innosage.crm.domain.attribute.option.service;

import innosage.crm.domain.attribute.option.Option;
import innosage.crm.domain.attribute.option.repository.OptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OptionCommandAdapter {

    private final OptionRepository optionRepository;

    public Option addOption(Option option) {
        return optionRepository.save(option);
    }

    public void deleteOption(Option option) {
        optionRepository.delete(option);
    }
}
