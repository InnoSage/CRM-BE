package innosage.crm.domain.deal.service;

import innosage.crm.domain.deal.Deal;
import innosage.crm.domain.deal.repository.DealRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class DealCommandAdapter {

    private final DealRepository dealRepository;

    public Deal addDeal(Deal deal) {
        return dealRepository.save(deal);
    }

    public void deleteDeal(Deal deal) {
        dealRepository.delete(deal);
    }
}
