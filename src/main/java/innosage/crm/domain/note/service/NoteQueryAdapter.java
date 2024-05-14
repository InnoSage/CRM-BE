package innosage.crm.domain.note.service;

import innosage.crm.domain.note.Note;
import innosage.crm.domain.note.repository.NoteRepository;
import innosage.crm.global.exception.common.GeneralException;
import innosage.crm.global.exception.common.code.GlobalErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class NoteQueryAdapter {

    private final NoteRepository noteRepository;

    public Note findById(Long noteId) {
        return noteRepository.findById(noteId)
                .orElseThrow(() -> new GeneralException(GlobalErrorCode.NOTE_NOT_FOUND));
    }
}
