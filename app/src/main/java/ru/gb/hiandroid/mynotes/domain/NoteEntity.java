package ru.gb.hiandroid.mynotes.domain;

import androidx.annotation.Nullable;

public class NoteEntity {
    @Nullable
    private final int id;
    private String title;
    private String description;

    public NoteEntity(@Nullable int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    @Nullable
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
