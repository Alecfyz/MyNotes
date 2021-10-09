package ru.gb.hiandroid.mynotes.ui;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import ru.gb.hiandroid.mynotes.R;
import ru.gb.hiandroid.mynotes.domain.NoteEntity;
import ru.gb.hiandroid.mynotes.domain.NotesRepo;
import ru.gb.hiandroid.mynotes.impl.NotesRepoImpl;

public class NotesListActivity extends AppCompatActivity {
    private static final boolean DEBUG_FLAG = true;
    private Toolbar toolbar;
    private final String CUR_ACTIVITY_TAG = "@@@ ListActivity";
    private final String log_modifier = " ";

    private NotesRepo notesRepo = new NotesRepoImpl();

    private RecyclerView recyclerView;

    private NotesAdapter adapter = new NotesAdapter();

    private ActivityResultLauncher<Intent> noteLauncher;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_list);

        fillRepoWithTestValues();

        initToolbar();
        initRecyclerView();

//        setAdditionButtonsListeners();
//        makeCurLauncher();
        prepareLauncher();
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
                openNoteScreen(null);
                return true;
            }
        }

        return super.onOptionsItemSelected(item);
    }

    private void openNoteScreen(@Nullable NoteEntity item) {
//        Intent intent = new Intent(this, NoteEditActivity.class);
        // intent.putExtra("note, item) // нужно сделать parcelable

        Intent intent = new Intent(this, NoteEditActivity.class);
        intent.putExtra(NoteEditActivity.TITLE_EXTRA_KEY, item.getTitle());
        noteLauncher.launch(intent);

//        startActivity(intent);

    }

/*    private void setAdditionButtonsListeners() { /// !!!!!!!!!!!!!!!!!!!1
        findViewById(R.id.switch_to_settings_button).setOnClickListener(v -> {
            Intent intent = new Intent(this, SettingsActivity.class);
            intent.putExtra(SettingsActivity.SETTINGS_ISNIGHT_THEME_EXTRA_KEY, isThemeNight);
            settingsLauncher.launch(intent);
        });
    }*/

/*    private void makeCurLauncher(NoteEntity item){
        Intent intent = new Intent(this, NoteEditActivity.class);
        intent.putExtra(NoteEditActivity.TITLE_EXTRA_KEY, item.);
        settingsLauncher.launch(intent);
    }*/

    private void prepareLauncher() { /// !!!!!!!!!!!!!!!!!!!1
        noteLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if (result.getResultCode() == Activity.RESULT_OK) {
                Intent data = result.getData(); // это точка возврата из вызываемой активити!
                String newTitle = data.getStringExtra(NoteEditActivity.EVAL_TITLE_EXTRA_KEY);
                Toast.makeText(this, "Returned data = " + newTitle, Toast.LENGTH_SHORT).show();
//                setLocalTheme(); /// Здесь делаем что-то в списке заметок. - меняем данные отредактированной заметки.м
            } else {
                logCycle("Return failed");
            }
        });
    }

    protected void logCycle(String message, boolean noToast) {
        if (!DEBUG_FLAG) {
            return;
        }
        Log.d(CUR_ACTIVITY_TAG + log_modifier, message);
        if (noToast) {
            return;
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    protected void logCycle(String message) {
        logCycle(message, false);
    }

    protected void fillRepoWithTestValues() {
        notesRepo.createNote(new NoteEntity("Заметка 1", "Заметка asdasd Заметка asdasd asd fas df asdf 1"));
        notesRepo.createNote(new NoteEntity("Заметка 2", "Заметка asdasd Заметка asdasd asdasd asd fas df asdf 2 длинный-длинный-длинный текст"));
        notesRepo.createNote(new NoteEntity("Заметка 3", "Заметка asdasd Заметка asdasd asdasd asd fas df asdf 3 длинный-длинный-длинный текст"));
        notesRepo.createNote(new NoteEntity("Заметка 4", "Заметка asdasd Заметка asdasd asdasd asd fas df asdf 4 длинный-длинный-длинный текст"));
        notesRepo.createNote(new NoteEntity("Заметка 5", "Заметка asdasd Заметка asdasd asdasd asd fas df asdf 5 длинный-длинный-длинный текст"));
        notesRepo.createNote(new NoteEntity("Заметка 6", "Заметка asdasd Заметка asdasd asdasd asd fas df asdf 5 длинный-длинный-длинный текст"));
        notesRepo.createNote(new NoteEntity("Заметка 6", "Заметка asdasd Заметка asdasd asdasd asd fas df asdf 5 длинный-длинный-длинный текст"));
        notesRepo.createNote(new NoteEntity("Заметка 7", "Заметка asdasd Заметка asdasd asdasd asd fas df asdf 5 длинный-длинный-длинный текст"));
        notesRepo.createNote(new NoteEntity("Заметка 8", "Заметка asdasd Заметка asdasd asdasd asd fas df asdf 5 длинный-длинный-длинный текст"));
        notesRepo.createNote(new NoteEntity("Заметка 10", "Заметка asdasd Заметка asdasd asdasd asd fas df asdf 5 длинный-длинный-длинный текст"));
        notesRepo.createNote(new NoteEntity("Заметка 11", "Заметка asdasd Заметка asdasd asdasd asd fas df asdf 5 длинный-длинный-длинный текст"));
        notesRepo.createNote(new NoteEntity("Заметка 12", "Заметка asdasd Заметка asdasd asdasd asd fas df asdf 5 длинный-длинный-длинный текст"));
        notesRepo.createNote(new NoteEntity("Заметка 13", "Заметка asdasd Заметка asdasd asdasd asd fas df asdf 5 длинный-длинный-длинный текст"));
    }

    private void initToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(this::onItemClick);

        adapter.setData(notesRepo.getNotes());
    }

    private void onItemClick(NoteEntity item) {
        openNoteScreen(item);
    }
}