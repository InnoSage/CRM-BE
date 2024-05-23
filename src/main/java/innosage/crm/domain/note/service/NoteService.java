package innosage.crm.domain.note.service;

import innosage.crm.auth.member.entity.Member;
import innosage.crm.auth.member.service.MemberQueryAdapter;
import innosage.crm.domain.deal.Deal;
import innosage.crm.domain.deal.service.DealQueryAdapter;
import innosage.crm.domain.note.Note;
import innosage.crm.domain.note.dto.NoteRequestDto;
import innosage.crm.domain.note.dto.NoteResponseDto;
import innosage.crm.domain.note.mapper.NoteMapper;
import innosage.crm.global.security.SecurityUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class NoteService {

    private final NoteCommandAdapter noteCommandAdapter;
    private final NoteQueryAdapter noteQueryAdapter;
    private final DealQueryAdapter dealQueryAdapter;
    private final MemberQueryAdapter memberQueryAdapter;

    @Transactional
    public NoteResponseDto.addNote addNote(Long dealId, NoteRequestDto.addNote request) {
        Member member = memberQueryAdapter.findById(SecurityUtil.getCurrentMemberId());
        Deal deal = dealQueryAdapter.findById(dealId);
        Note note = NoteMapper.toNote(member, deal, request.getTitle(), request.getBody());
        Note savedNote = noteCommandAdapter.addNote (note);

        return NoteMapper.toAddNote (savedNote);
    }

    @Transactional(readOnly = true)
    public NoteResponseDto.getNote getNote(Long noteId) {
        Note note = noteQueryAdapter.findById(noteId);

        return NoteMapper.toGetNote(note);
    }

    @Transactional(readOnly = true)
    public List<NoteResponseDto.getNotes> getNotes(Long dealId) {
        Deal deal = dealQueryAdapter.findById(dealId);
        List<Note> notes = deal.getNotes();

        return NoteMapper.toGetNoteList(notes);
    }

    @Transactional
    public NoteResponseDto.updateNote updateNote(Long noteId, NoteRequestDto.updateNote request) {
        Note note = noteQueryAdapter.findById(noteId);
        note.update(request.getTitle(), request.getBody());

        return NoteMapper.toUpdateNote(note);
    }

    @Transactional
    public void deleteNote(Long noteId) {
        Note note = noteQueryAdapter.findById(noteId);
        noteCommandAdapter.deleteNote(note);
    }
}
