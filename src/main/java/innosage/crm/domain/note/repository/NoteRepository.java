package innosage.crm.domain.note.repository;

import innosage.crm.domain.note.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long>{
}
