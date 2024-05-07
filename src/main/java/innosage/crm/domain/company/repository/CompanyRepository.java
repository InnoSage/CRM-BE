package innosage.crm.domain.company.repository;

import innosage.crm.domain.company.Company;
import innosage.crm.domain.sheet.Sheet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    List<Company> findAllBySheet(Sheet sheet);

    Company findByIdAndSheet(Long companyId, Sheet sheet);
}
