package ru.gb.hiandroid.mynotes.domain;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.Nullable;

public class NoteEntity implements Parcelable {
    @Nullable
    private int noteId;
    private String title;
    private String description;

    public NoteEntity(String title, String description) {
        this.title = title;
        this.description = description;
    }

    protected NoteEntity(Parcel in) {
        noteId = in.readInt();
        title = in.readString();
        description = in.readString();
    }

    public static final Creator<NoteEntity> CREATOR = new Creator<NoteEntity>() {
        @Override
        public NoteEntity createFromParcel(Parcel in) {
            return new NoteEntity(in);
        }

        @Override
        public NoteEntity[] newArray(int size) {
            return new NoteEntity[size];
        }
    };

    @Nullable
    public int getNoteId() {
        return noteId;
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

    public void setNoteId(@Nullable Integer noteId) {
        this.noteId = noteId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(noteId);
        parcel.writeString(title);
        parcel.writeString(description);
    }

    public int compareTo(NoteEntity u) {
        if (getTitle() == null || u.getTitle() == null) {
            return 0;
        }
        return getTitle().compareTo(u.getTitle());
    }
}
