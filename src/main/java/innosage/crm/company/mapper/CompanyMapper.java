package innosage.crm.company.mapper;

import innosage.crm.company.Company;
import innosage.crm.company.dto.CompanyResponseDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CompanyMapper {

    public static Company toCompany(String name, String description) {
        return Company.builder()
                .name(name)
                .build();
    }

    public static CompanyResponseDto.addCompany toAddCompany(Company company) {
        return CompanyResponseDto.addCompany.builder()
                .companyId(company.getId())
                .build();
    }

    public static CompanyResponseDto.getCompany toGetCompany(Company company) {
        return CompanyResponseDto.getCompany.builder()
                .companyId(company.getId())
                .companyName(company.getName())
                .build();
    }
}
