package innosage.crm.domain.content.service;

import innosage.crm.domain.content.Content;
import innosage.crm.domain.content.repository.ContentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class ContentCommandAdapter {

    private final ContentRepository contentRepository;

    public Content addContent(Content content) {
        return contentRepository.save(content);
    }

    public void deleteContent(Content content) {
        contentRepository.delete(content);
    }
}
