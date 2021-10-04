package ru.gb.hiandroid.mynotes.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.Toast;

import ru.gb.hiandroid.mynotes.R;
import ru.gb.hiandroid.mynotes.domain.NoteEntity;
import ru.gb.hiandroid.mynotes.domain.NotesRepo;
import ru.gb.hiandroid.mynotes.impl.NotesRepoImpl;

public class NotesListActivity extends AppCompatActivity {
    private static final boolean DEBUG_FLAG = true;
    private Toolbar toolbar;
    private final String CUR_ACTIVITY_TAG = "@@@ ListActivity";
    private String log_modifyer = " ";

    private NotesRepo notesRepo = new NotesRepoImpl();

    private RecyclerView recyclerView;

    private NotesAdapter adapter = new NotesAdapter();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_list);

        fillRepoWithTestValues();

        initToolbar();
        initRecyclerView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.notes_list_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.new_note_menu: {
                logCycle("--< Menu! >--", true);
                openNoteScreen();
                return true;
            }
        }

        return super.onOptionsItemSelected(item);
    }

    private void openNoteScreen() {
        Intent intent = new Intent(this, NoteEditActivity.class);
        startActivity(intent);
    }


    protected void logCycle(String message, boolean noToast) {
        if (!DEBUG_FLAG) {
            return;
        }
        Log.d(CUR_ACTIVITY_TAG + log_modifyer, message);
        if (noToast) {
            return;
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    protected void logCycle(String message) {
        logCycle(message, false);
    }

    protected void fillRepoWithTestValues() {
        notesRepo.createNote(new NoteEntity("Заметка 1", "asdasd asd fas df asdf 1"));
        notesRepo.createNote(new NoteEntity("Заметка 2", "asdasd asd fas df asdf 2"));
        notesRepo.createNote(new NoteEntity("Заметка 3", "asdasd asd fas df asdf 3"));
        notesRepo.createNote(new NoteEntity("Заметка 4", "asdasd asd fas df asdf 4"));
        notesRepo.createNote(new NoteEntity("Заметка 5", "asdasd asd fas df asdf 5"));
    }

    private void initToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.setData(notesRepo.getNotes());
    }
}