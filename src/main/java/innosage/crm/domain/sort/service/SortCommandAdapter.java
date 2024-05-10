package innosage.crm.domain.sort.service;

import innosage.crm.domain.sort.Sort;
import innosage.crm.domain.sort.repository.SortRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class SortCommandAdapter {

    private final SortRepository sortRepository;

    public Sort addSort(Sort sort) {
        return sortRepository.save(sort);
    }
}
