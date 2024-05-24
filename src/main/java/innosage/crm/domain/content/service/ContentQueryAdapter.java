package innosage.crm.domain.content.service;

import innosage.crm.domain.content.Content;
import innosage.crm.domain.content.repository.ContentRepository;
import innosage.crm.global.exception.common.GeneralException;
import innosage.crm.global.exception.common.code.GlobalErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ContentQueryAdapter {

    private final ContentRepository contentRepository;

    public Content findById(Long contentId) {
        return contentRepository.findById(contentId)
            .orElseThrow(() -> new GeneralException(GlobalErrorCode.CONTENT_NOT_FOUND));
    }
}
