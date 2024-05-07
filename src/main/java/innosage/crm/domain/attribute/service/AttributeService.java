package innosage.crm.domain.attribute.service;

import innosage.crm.domain.attribute.Attribute;
import innosage.crm.domain.attribute.dto.AttributeRequestDto;
import innosage.crm.domain.attribute.dto.AttributeResponseDto;
import innosage.crm.domain.attribute.mapper.AttributeMapper;
import innosage.crm.domain.sheet.Sheet;
import innosage.crm.domain.sheet.service.SheetQueryAdapter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class AttributeService {

    private final AttributeCommandAdapter attributeCommandAdapter;
    private final AttributeQueryAdapter attributeQueryAdapter;
    private final SheetQueryAdapter sheetQueryAdapter;

    @Transactional
    public AttributeResponseDto.addAttribute addAttribute(Long sheetId, AttributeRequestDto.addAttribute request) {
        Sheet sheet = sheetQueryAdapter.findById(sheetId);
        Attribute attribute = AttributeMapper.toAttribute(request.getName(), request.getDataType(), request.getDescription(), sheet);
        Attribute savedAttribute = attributeCommandAdapter.addAttribute(attribute);

        return AttributeMapper.toAddAttribute(savedAttribute);
    }

    @Transactional
    public AttributeResponseDto.updateAttribute updateAttribute(Long attributeId, AttributeRequestDto.updateAttribute request) {
        Attribute attribute = attributeQueryAdapter.findById(attributeId);
        attribute.update(request.getName(), request.getDataType(), request.getDescription());

        return AttributeMapper.toUpdateAttribute(attribute);
    }

    @Transactional(readOnly = true)
    public List<AttributeResponseDto.getAttribute> getAttribute(Long sheetId) {
        Sheet sheet = sheetQueryAdapter.findById(sheetId);
        List<Attribute> attributes = attributeQueryAdapter.findBySheet(sheet);
        return AttributeMapper.toGetAttributeList(attributes);
    }

    @Transactional
    public void deleteAttribute(Long attributeId) {
        Attribute attribute = attributeQueryAdapter.findById(attributeId);
        attributeCommandAdapter.deleteAttribute(attribute);
    }
}
