package innosage.crm.domain.content.repository;

import innosage.crm.domain.attribute.Attribute;
import innosage.crm.domain.content.Content;
import innosage.crm.domain.deal.Deal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContentRepository extends JpaRepository<Content, Long> {
    Optional<Content> findByAttributeAndDeal(Attribute attribute, Deal deal);
}
