package ru.gb.hiandroid.mynotes.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import ru.gb.hiandroid.mynotes.R;
import ru.gb.hiandroid.mynotes.domain.NoteEntity;

public class NoteEditActivity extends AppCompatActivity {
    public static final String NOTE_EXTRA_KEY = "NOTE_EXTRA_KEY";
    private final String CUR_ACTIVITY_TAG = "@@@@ EditActivity";
    private final String log_modifyer = " ";
    private EditText titleEditText;
    private EditText descrEditText;
    private Button saveButton;
    private NoteEntity note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_edit);

        Bundle data = checkIntent();
        note = getNoteFromIntent(data);

        initAllViews();
        fillAllViews(note);
        saveButton.setOnClickListener(v -> {
            NoteEntity noteEntity = new NoteEntity(

                    titleEditText.getText().toString(),
                    descrEditText.getText().toString()
            );
            if (noteEntity.getTitle().equals("") && noteEntity.getDescription().equals("")) {
                setResult(Activity.RESULT_CANCELED);
            } else {
                noteEntity.setNoteId(note.getNoteId());
                Intent outData = new Intent(this, NoteEditActivity.class);
                outData.putExtra(NOTE_EXTRA_KEY, noteEntity);
                setResult(Activity.RESULT_OK, outData);
            }
            finish();
        });
    }

    private void fillAllViews(NoteEntity note) {
        titleEditText.setText(note.getTitle());
        descrEditText.setText(note.getDescription());
        saveButton = findViewById(R.id.save_button);
    }

    private NoteEntity getNoteFromIntent(Bundle data) {
        return data.getParcelable(NOTE_EXTRA_KEY);
    }

    private Bundle checkIntent() {
//        Intent tmpdata = getIntent();
        return getIntent().getExtras();
    }

    private void initAllViews() {
        titleEditText = findViewById(R.id.text_title_edit);
        descrEditText = findViewById(R.id.text_descript_edit);
        saveButton = findViewById(R.id.save_button);
    }

    public void logCycle(NoteEntity note, String point) {
        logCycle(point
                + "\nID = " + note.getNoteId()
                + "\nTitle = " + note.getTitle()
                + ", \nDescription = " + note.getDescription()
        );
    }

    protected void logCycle(String message, boolean noToast) {
        Log.d(CUR_ACTIVITY_TAG + log_modifyer, message);
        if (noToast) {
            return;
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    protected void logCycle(String message) {
        logCycle(message, false);
    }
}