package innosage.crm.domain.deal.service;

import innosage.crm.domain.deal.Deal;
import innosage.crm.domain.deal.repository.DealRepository;
import innosage.crm.global.exception.common.code.GlobalErrorCode;
import innosage.crm.global.exception.deal.DealException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DealQueryAdapter {

    private final DealRepository dealRepository;

    public Deal findById(Long dealId) {
        return dealRepository.findById(dealId).orElseThrow(() -> new DealException(GlobalErrorCode.DEAL_NOT_FOUND));
    }
}
