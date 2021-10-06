package ru.gb.hiandroid.mynotes.ui;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ru.gb.hiandroid.mynotes.domain.NoteEntity;

public class NotesAdapter extends RecyclerView.Adapter<NoteVH> {
    private List<NoteEntity> data = new ArrayList<>();
    private onItemClickListener clickListener = null;

    public void setData(List<NoteEntity> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NoteVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NoteVH(parent, clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteVH holder, int position) {
        NoteEntity note = getItem(position);
        holder.bind(note);

    }

    private NoteEntity getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setOnItemClickListener(onItemClickListener listener) {
        clickListener = listener;
    }

    interface onItemClickListener {
        void onItemClick(NoteEntity item);
    }
}
