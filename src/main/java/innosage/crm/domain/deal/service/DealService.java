package innosage.crm.domain.deal.service;

import innosage.crm.domain.company.Company;
import innosage.crm.domain.company.service.CompanyQueryAdapter;
import innosage.crm.domain.deal.Deal;
import innosage.crm.domain.deal.dto.DealRequestDto;
import innosage.crm.domain.deal.dto.DealResponseDto;
import innosage.crm.domain.deal.mapper.DealMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@AllArgsConstructor
@Slf4j
public class DealService {

    private final DealCommandAdapter dealCommandAdapter;
    private final DealQueryAdapter dealQueryAdapter;
    private final CompanyQueryAdapter companyQueryAdapter;

    @Transactional
    public DealResponseDto.addDeal addDeal(DealRequestDto.addDeal request) {
        Company company = companyQueryAdapter.findById(request.getCompanyId());
        Deal deal = DealMapper.toDeal(company);
        Deal savedDeal = dealCommandAdapter.addDeal(deal);

        return DealMapper.toAddDeal(savedDeal);
    }

    @Transactional
    public void changeCompany(Long dealId, DealRequestDto.changeCompany request) {
        Company newCompany = companyQueryAdapter.findById(request.getCompanyId());
        Deal deal = dealQueryAdapter.findById(dealId);
        deal.changeCompany(newCompany);
    }

    @Transactional(readOnly = true)
    public DealResponseDto.getDeal getDeal(Long dealId) {
        Deal deal = dealQueryAdapter.findById(dealId);
        return DealMapper.toGetDeal(deal);
    }

    @Transactional
    public void deleteDeal(Long dealId) {
        Deal deal = dealQueryAdapter.findById(dealId);
        dealCommandAdapter.deleteDeal(deal);
    }
}
