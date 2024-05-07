package innosage.crm.domain.sheet.repository;

import innosage.crm.auth.organization.Organization;
import innosage.crm.domain.sheet.Sheet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SheetRepository extends JpaRepository<Sheet, Long> {

    List<Sheet> findAllByOrganization(Organization organization);
}
