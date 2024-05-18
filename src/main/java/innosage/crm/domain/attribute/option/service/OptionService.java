package innosage.crm.domain.attribute.option.service;

import innosage.crm.domain.attribute.Attribute;
import innosage.crm.domain.attribute.option.Option;
import innosage.crm.domain.attribute.option.dto.OptionRequestDto;
import innosage.crm.domain.attribute.option.dto.OptionResponseDto;
import innosage.crm.domain.attribute.option.mapper.OptionMapper;
import innosage.crm.domain.attribute.service.AttributeQueryAdapter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Slf4j
public class OptionService {

    private final OptionCommandAdapter optionCommandAdapter;
    private final OptionQueryAdapter optionQueryAdapter;
    private final AttributeQueryAdapter attributeQueryAdapter;

    @Transactional
    public OptionResponseDto.addOption addOption(Long attributeId, OptionRequestDto.addOption request) {
        Attribute attribute = attributeQueryAdapter.findById(attributeId);
        Option option = OptionMapper.toOption(request.getName(), attribute);
        Option savedOption = optionCommandAdapter.addOption(option);

        return OptionMapper.toAddOption(savedOption);
    }

    @Transactional
    public OptionResponseDto.updateOption updateOption(Long optionId, OptionRequestDto.updateOption request) {
        Option option = optionQueryAdapter.findById(optionId);
        option.update(request.getName());

        return OptionMapper.toUpdateOption(option);
    }

    @Transactional
    public void deleteOption(Long optionId) {
        Option option = optionQueryAdapter.findById(optionId);
        optionCommandAdapter.deleteOption(option);
    }
}
