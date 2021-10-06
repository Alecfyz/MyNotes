package ru.gb.hiandroid.mynotes.ui;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import ru.gb.hiandroid.mynotes.R;
import ru.gb.hiandroid.mynotes.domain.NoteEntity;

public class NoteEditActivity extends AppCompatActivity {
    private final String CUR_ACTIVITY_TAG = "@@@@ EditActivity";
    private String log_modifyer = " ";
    private EditText titleEditText;
    private EditText descrEditText;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_edit);

        initAllViews();
        saveButton.setOnClickListener(v -> {
            NoteEntity noteEntity = new NoteEntity(
                    titleEditText.getText().toString(),
                    descrEditText.getText().toString()
            );
            // todo
            // setResult...
        });
        checkIntent();
//        logCycle(" here I am!");
    }

    private void checkIntent() {
        // todo
        //getIntent
    }

    private void initAllViews() {
        titleEditText = findViewById(R.id.text_title_edit);
        descrEditText = findViewById(R.id.text_descript_edit);
        saveButton = findViewById(R.id.save_button);
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