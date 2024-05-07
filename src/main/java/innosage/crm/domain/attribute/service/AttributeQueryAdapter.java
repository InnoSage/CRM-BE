package innosage.crm.domain.attribute.service;

import innosage.crm.domain.attribute.Attribute;
import innosage.crm.domain.attribute.repository.AttributeRepository;
import innosage.crm.global.exception.attribute.AttributeException;
import innosage.crm.global.exception.common.code.GlobalErrorCode;
import innosage.crm.global.exception.deal.DealException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AttributeQueryAdapter {

    private final AttributeRepository attributeRepository;
    public Attribute findById(Long attributeId) {
        return attributeRepository.findById(attributeId).orElseThrow(() -> new AttributeException(GlobalErrorCode.ATTRIBUTE_NOT_FOUND));
    }
}
