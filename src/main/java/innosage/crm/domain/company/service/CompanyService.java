package innosage.crm.domain.company.service;

import innosage.crm.domain.company.Company;
import innosage.crm.domain.company.dto.CompanyRequestDto;
import innosage.crm.domain.company.dto.CompanyResponseDto;
import innosage.crm.domain.company.mapper.CompanyMapper;
import innosage.crm.domain.sheet.Sheet;
import innosage.crm.domain.sheet.service.SheetQueryAdapter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class CompanyService {

    private final CompanyCommandAdapter companyCommandAdapter;
    private final CompanyQueryAdapter companyQueryAdapter;
    private final SheetQueryAdapter sheetQueryAdapter;

    @Transactional
    public CompanyResponseDto.addCompany addCompany(Long sheetId, CompanyRequestDto.addCompany request) {
        Sheet sheet = sheetQueryAdapter.findById(sheetId);
        Company company = CompanyMapper.toCompany(sheet, request.getCompanyName());
        Company savedCompany = companyCommandAdapter.addCompany(company);

        return CompanyMapper.toAddCompany(savedCompany);
    }

    @Transactional(readOnly = true)
    public CompanyResponseDto.getCompanyList getCompanyList(Long sheetId) {
        Sheet sheet = sheetQueryAdapter.findById(sheetId);
        List<Company> companies = companyQueryAdapter.findBySheet(sheet);

        return CompanyMapper.toGetCompanyList(companies);
    }

    @Transactional
    public void deleteCompany(Long sheetId, Long companyId) {
        Sheet sheet = sheetQueryAdapter.findById(sheetId);
        Company company = companyQueryAdapter.findByIdAndSheet(companyId, sheet);
        companyCommandAdapter.delete(company);
    }
}
