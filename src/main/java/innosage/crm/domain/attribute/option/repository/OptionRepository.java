package innosage.crm.domain.attribute.option.repository;

import innosage.crm.domain.attribute.option.Option;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionRepository extends JpaRepository<Option, Long> {
}
