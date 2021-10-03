package ru.gb.hiandroid.mynotes.domain;

import java.util.List;

public interface NotesRepo {
    boolean createNote(NoteEntity note);

    List<NoteEntity> getNotes();

    boolean updateNote(int id, NoteEntity note);

    boolean deleteNote(int id);
}
