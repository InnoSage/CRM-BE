package innosage.crm.domain.attribute.option.service;

import innosage.crm.domain.attribute.option.Option;
import innosage.crm.domain.attribute.option.repository.OptionRepository;
import innosage.crm.global.exception.common.GeneralException;
import innosage.crm.global.exception.common.code.GlobalErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OptionQueryAdapter {

    private final OptionRepository optionRepository;

    public Option findById(Long optionId) {
        return optionRepository.findById(optionId)
                .orElseThrow(() -> new GeneralException(GlobalErrorCode.OPTION_NOT_FOUND));
    }
}
