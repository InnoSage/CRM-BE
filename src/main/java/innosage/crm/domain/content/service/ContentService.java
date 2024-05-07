package innosage.crm.domain.content.service;

import innosage.crm.domain.attribute.Attribute;
import innosage.crm.domain.attribute.service.AttributeQueryAdapter;
import innosage.crm.domain.content.Content;
import innosage.crm.domain.content.dto.ContentRequestDto;
import innosage.crm.domain.content.mapper.ContentMapper;
import innosage.crm.domain.deal.Deal;
import innosage.crm.domain.deal.service.DealQueryAdapter;
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

    @Transactional
    public void addContent(Long dealId, ContentRequestDto.addContent request) {
        Deal deal = dealQueryAdapter.findById(dealId);
        Attribute attribute = attributeQueryAdapter.findById(request.getAttributeId());
        Content content = ContentMapper.toContent(request.getValue(), attribute, deal);
        contentCommandAdapter.addContent(content);
    }



}
