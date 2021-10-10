package ru.gb.hiandroid.mynotes.impl;


import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ru.gb.hiandroid.mynotes.domain.NoteEntity;
import ru.gb.hiandroid.mynotes.domain.NotesRepo;

public class NotesRepoImpl implements NotesRepo {
    private final ArrayList <NoteEntity> cache = new ArrayList<>();
    private int counter = 0;

    @Nullable
    @Override
    public Integer createNote(NoteEntity note) {
        note.setNoteId(++counter);
        cache.add(note);
        return counter;
    }

    @Override
    public List<NoteEntity> getNotes() {
        ArrayList<NoteEntity> tmpNotesList = new ArrayList<>(cache);

        if (!tmpNotesList.isEmpty()) {
            Collections.sort(tmpNotesList, (p1, p2) -> p1.getNoteId() - p2.getNoteId());
        }
        return tmpNotesList ;
    }

    @Override
    public boolean updateNote(int id, NoteEntity note) {
        deleteNote(id);
        note.setNoteId(id);
        cache.add(note);
        return false;
    }

    @Override
    public boolean deleteNote(int id) {
        for (int i = 0; i < cache.size(); i++) {
            if (cache.get(i).getNoteId() ==  id){
                cache.remove(i);
                return true;
            }
        }
        return false;
    }
}
