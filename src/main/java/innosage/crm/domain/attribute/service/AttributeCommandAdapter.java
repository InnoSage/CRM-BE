package innosage.crm.domain.attribute.service;

import innosage.crm.domain.attribute.Attribute;
import innosage.crm.domain.attribute.repository.AttributeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class AttributeCommandAdapter {

    private final AttributeRepository attributeRepository;

    public Attribute addAttribute(Attribute attribute) {
        return attributeRepository.save(attribute);
    }

    public void deleteAttribute(Attribute attribute) {
        attributeRepository.delete(attribute);
    }
}
