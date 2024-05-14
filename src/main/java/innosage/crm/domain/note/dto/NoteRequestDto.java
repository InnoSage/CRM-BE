package innosage.crm.domain.note.dto;

import lombok.Getter;

public class NoteRequestDto {

    @Getter
    public static class addNote {

        private String title;
        private String body;
    }

    @Getter
    public static class updateNote {

        private String title;
        private String body;
    }
}
