package innosage.crm.domain.deal.repository;

import innosage.crm.domain.deal.Deal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DealRepository extends JpaRepository<Deal, Long>{
}
