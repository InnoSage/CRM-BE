package innosage.crm.domain.note.controller;

import innosage.crm.auth.member.entity.UserDetailsImpl;
import innosage.crm.domain.note.dto.NoteRequestDto;
import innosage.crm.domain.note.dto.NoteResponseDto;
import innosage.crm.domain.note.service.NoteService;
import innosage.crm.global.common.CommonResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/deals/{dealId}/notes")
@Tag(name = "notes")
public class NoteController {

    private final NoteService noteService;

    @PostMapping
    public CommonResponse<NoteResponseDto.addNote> addNote(
            @PathVariable Long dealId,
            @RequestBody NoteRequestDto.addNote request) {
        return CommonResponse.onSuccess(noteService.addNote(dealId, request));
    }

    @GetMapping("/{noteId}")
    public CommonResponse<NoteResponseDto.getNote> getNote(
            @PathVariable Long noteId) {
        return CommonResponse.onSuccess(noteService.getNote(noteId));
    }

    @GetMapping
    public CommonResponse<NoteResponseDto.getNotes> getNotes(
            @PathVariable Long dealId) {
        return CommonResponse.onSuccess(noteService.getNotes(dealId));
    }

    @PatchMapping("/{noteId}")
    public CommonResponse<NoteResponseDto.updateNote> updateNote(
            @PathVariable Long noteId,
            @RequestBody NoteRequestDto.updateNote request) {
        return CommonResponse.onSuccess(noteService.updateNote(noteId, request));
    }

    @DeleteMapping("/{noteId}")
    public CommonResponse deleteNote(
            @PathVariable Long noteId
    ) {
        noteService.deleteNote(noteId);
        return CommonResponse.onSuccess(null);
    }

}
