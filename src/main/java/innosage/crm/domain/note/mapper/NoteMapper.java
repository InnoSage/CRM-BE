package innosage.crm.domain.note.mapper;

import innosage.crm.auth.member.entity.Member;
import innosage.crm.domain.deal.Deal;
import innosage.crm.domain.note.Note;
import innosage.crm.domain.note.dto.NoteResponseDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class NoteMapper {

    public static Note toNote(Member member, Deal deal, String title, String body) {
        return Note.builder()
                .author(member)
                .deal(deal)
                .title(title)
                .body(body)
                .build();
    }

    public static NoteResponseDto.addNote toAddNote(Note note) {
        return NoteResponseDto.addNote.builder()
                .noteId(note.getId())
                .build();
    }

    public static NoteResponseDto.getNote toGetNote(Note note) {
        return NoteResponseDto.getNote.builder()
                .noteTitle(note.getTitle())
                .noteBody(note.getBody())
                .build();
    }

    public static NoteResponseDto.getNotes toGetNotes(Note note) {
        return NoteResponseDto.getNotes.builder()
                .noteId(note.getId())
                .title(note.getTitle())
                .build();
    }

    public static List<NoteResponseDto.getNotes> toGetNoteList(List<Note> notes) {
        return notes.stream()
                            .map(NoteMapper::toGetNotes)
                            .collect(Collectors.toList());
    }

    public static NoteResponseDto.updateNote toUpdateNote(Note note) {
        return NoteResponseDto.updateNote.builder()
                .noteId(note.getId())
                .build();
    }
}
