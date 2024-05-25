package innosage.crm.domain.content.service;

import innosage.crm.domain.attribute.Attribute;
import innosage.crm.domain.attribute.service.AttributeQueryAdapter;
import innosage.crm.domain.content.Content;
import innosage.crm.domain.content.dto.ContentRequestDto;
import innosage.crm.domain.content.dto.ContentResponseDto;
import innosage.crm.domain.content.mapper.ContentMapper;
import innosage.crm.domain.deal.Deal;
import innosage.crm.domain.deal.service.DealQueryAdapter;
import innosage.crm.domain.sheet.Sheet;
import innosage.crm.global.ApiClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Slf4j
public class ContentService {

    private final ContentCommandAdapter contentCommandAdapter;
    private final ContentQueryAdapter contentQueryAdapter;
    private final DealQueryAdapter dealQueryAdapter;
    private final AttributeQueryAdapter attributeQueryAdapter;
    private final ApiClient apiClient;

    @Transactional
    public ContentResponseDto.addContent addContent(Long dealId, ContentRequestDto.addContent request) {
        Deal deal = dealQueryAdapter.findById(dealId);
        Attribute attribute = attributeQueryAdapter.findById(request.getAttributeId());
        Content content = ContentMapper.toContent(request.getValue(), attribute, deal);
        Content savedContent = contentCommandAdapter.addContent(content);

        Sheet sheet = attribute.getSheet();
        apiClient.sendGetRequest(sheet.getOrganization().getId(), sheet.getId());

        return ContentMapper.toAddContent(savedContent);
    }

    @Transactional
    public ContentResponseDto.updateContent updateContent(Long dealId, ContentRequestDto.updateContent request) {

        Attribute attribute = attributeQueryAdapter.findById(request.getAttributeId());
        Deal deal = dealQueryAdapter.findById(dealId);
        Content content = contentQueryAdapter.findByAttributeAndDeal(attribute, deal);

        Sheet sheet = attribute.getSheet();

        content.updateValue(request.getValue());
        apiClient.sendGetRequest(sheet.getOrganization().getId(), sheet.getId());

        return ContentMapper.toUpdateContent(content);
    }

    @Transactional
    public void deleteContent(Long dealId, ContentRequestDto.deleteContent request) {

        Attribute attribute = attributeQueryAdapter.findById(request.getAttributeId());
        Deal deal = dealQueryAdapter.findById(dealId);
        Content content = contentQueryAdapter.findByAttributeAndDeal(attribute, deal);

        Sheet sheet = attribute.getSheet();

        contentCommandAdapter.deleteContent(content);
        apiClient.sendGetRequest(sheet.getOrganization().getId(), sheet.getId());
    }
}
