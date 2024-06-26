package innosage.crm.domain.company.mapper;

import innosage.crm.domain.company.Company;
import innosage.crm.domain.company.dto.CompanyResponseDto;
import innosage.crm.domain.sheet.Sheet;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CompanyMapper {

    public static Company toCompany(Sheet sheet, String name) {
        return Company.builder()
                .name(name)
                .sheet(sheet)
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

    public static CompanyResponseDto.getCompanyList toGetCompanyList(List<Company> companies) {
        List<CompanyResponseDto.getCompany> companyDtos = companies.stream()
                .map(CompanyMapper::toGetCompany)
                .collect(Collectors.toList());

        return CompanyResponseDto.getCompanyList.builder()
                .companies(companyDtos)
                .build();
    }
}
