package innosage.crm.domain.attribute.repository;

import innosage.crm.domain.attribute.Attribute;
import innosage.crm.domain.sheet.Sheet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttributeRepository extends JpaRepository<Attribute, Long> {
    List<Attribute> findAllBySheet(Sheet sheet);
}
