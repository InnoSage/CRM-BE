package innosage.crm.domain.content.repository;

import innosage.crm.domain.content.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<Content, Long> {
}
