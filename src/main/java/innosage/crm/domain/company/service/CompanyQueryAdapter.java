package innosage.crm.domain.company.service;

import innosage.crm.domain.company.Company;
import innosage.crm.domain.company.repository.CompanyRepository;
import innosage.crm.domain.sheet.Sheet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CompanyQueryAdapter {

    private final CompanyRepository companyRepository;

    public List<Company> findBySheet(Sheet sheet) {
        return companyRepository.findAllBySheet(sheet);
    }

    public Company findByIdAndSheet(Long companyId, Sheet sheet) {
        return companyRepository.findByIdAndSheet(companyId, sheet);
    }
}
