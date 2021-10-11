package ru.gb.hiandroid.mynotes.domain;

import androidx.annotation.Nullable;

import java.util.List;

public interface NotesRepo {
    @Nullable
    Integer createNote(NoteEntity note);

    List<NoteEntity> getNotes();

    boolean updateNote(int id, NoteEntity note);

    boolean deleteNote(int id);
}
