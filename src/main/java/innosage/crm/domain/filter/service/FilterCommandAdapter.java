package innosage.crm.domain.filter.service;

import innosage.crm.domain.filter.Filter;
import innosage.crm.domain.filter.repository.FilterRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class FilterCommandAdapter {

    private final FilterRepository filterRepository;

    public Filter addFilter(Filter filter) {
        return filterRepository.save(filter);
    }
}
