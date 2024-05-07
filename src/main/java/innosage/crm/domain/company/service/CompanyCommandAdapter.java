package innosage.crm.domain.company.service;

import innosage.crm.domain.company.Company;
import innosage.crm.domain.company.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class CompanyCommandAdapter {

    private final CompanyRepository companyRepository;

    public Company addCompany(Company company) {
        return companyRepository.save(company);
    }

    public void delete(Company company) {
        companyRepository.delete(company);
    }

}
