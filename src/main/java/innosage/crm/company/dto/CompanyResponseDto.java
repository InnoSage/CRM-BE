package innosage.crm.company.dto;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CompanyResponseDto {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class addCompany {

        private Long companyId;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class getCompany {

        private Long companyId;
        private String companyName;
    }
}
