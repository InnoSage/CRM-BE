package innosage.crm.auth.organization.repository;

import innosage.crm.auth.organization.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrganizationRepository extends JpaRepository<Organization, Long>{

    List<Organization> findAll();
}
