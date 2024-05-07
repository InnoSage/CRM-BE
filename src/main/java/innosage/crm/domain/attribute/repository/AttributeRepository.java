package innosage.crm.domain.attribute.repository;

import innosage.crm.domain.attribute.Attribute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttributeRepository extends JpaRepository<Attribute, Long> {
}
