package innosage.crm.domain.deal.mapper;

import innosage.crm.domain.attribute.content.mapper.ContentMapper;
import innosage.crm.domain.company.Company;
import innosage.crm.domain.deal.Deal;
import innosage.crm.domain.deal.dto.DealResponseDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DealMapper {

    public static Deal toDeal(Company company) {
        return Deal.builder()
                .company(company)
                .build();
    }

    public static DealResponseDto.addDeal toAddDeal(Deal deal) {
        return DealResponseDto.addDeal.builder()
                .dealId(deal.getId())
                .build();
    }

    public static DealResponseDto.getDeal toGetDeal(Deal deal) {
        return DealResponseDto.getDeal.builder()
                .dealId(deal.getId())
                .companyId(deal.getCompany().getId())
                .companyName(deal.getCompany().getName())
                .contents(deal.getContents().stream().map(ContentMapper::toGetContent).collect(Collectors.toList()))
                .build();
    }

    public static List<DealResponseDto.getDeal> toGetDealList(List<Deal> deals) {
        return deals.stream()
                .map(DealMapper::toGetDeal)
                .collect(Collectors.toList());
    }
}
