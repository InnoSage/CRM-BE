package innosage.crm.domain.deal.dto;

import lombok.Getter;

public class DealRequestDto {

    @Getter
    public static class addDeal {

        private Long companyId;
    }

    @Getter
    public static class changeCompany {

        private Long companyId;
    }
}
