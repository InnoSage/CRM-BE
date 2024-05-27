package innosage.crm.domain.filter.service;

import innosage.crm.domain.filter.Filter;
import innosage.crm.domain.filter.repository.FilterRepository;
import innosage.crm.global.exception.common.GeneralException;
import innosage.crm.global.exception.common.code.GlobalErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FilterQueryAdapter {

    private final FilterRepository filterRepository;

    public Filter findById(Long filterId) {
        return filterRepository.findById(filterId)
                .orElseThrow(() -> new GeneralException(GlobalErrorCode.FILTER_NOT_FOUND));
    }
}
