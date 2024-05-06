package innosage.crm.domain.company.dto;

import lombok.Getter;

public class CompanyRequestDto {

    @Getter
    public static class addCompany {

        private String companyName;
    }
}
