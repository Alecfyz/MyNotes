package ru.gb.hiandroid.mynotes.ui;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ru.gb.hiandroid.mynotes.R;

public class NoteVH extends RecyclerView.ViewHolder {

    public NoteVH(@NonNull View itemView) {
        super(itemView);
    }

    public TextView titleTextView = itemView.findViewById(R.id.title_text_view);
    public TextView descriptionTextView = itemView.findViewById(R.id.description_text_view);
}
