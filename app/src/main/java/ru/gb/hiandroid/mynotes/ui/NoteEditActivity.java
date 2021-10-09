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
    public static final String TITLE_EXTRA_KEY = "TITLE_EXTRA_KEY";
    public static final String DESCR_EXTRA_KEY = "DESCR_EXTRA_KEY";
    public static final String EVAL_TITLE_EXTRA_KEY = "EVAL_TITLE_EXTRA_KEY";
    private final String CUR_ACTIVITY_TAG = "@@@@ EditActivity";
    private final String log_modifyer = " ";
    private EditText titleEditText;
    private EditText descrEditText;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_edit);

        Intent data = checkIntent();
        logCycle("data IN = " + data.getStringExtra(TITLE_EXTRA_KEY));

        initAllViews();
        saveButton.setOnClickListener(v -> {
            NoteEntity noteEntity = new NoteEntity(
                    titleEditText.getText().toString(),
                    descrEditText.getText().toString()
            );
            Intent outData = new Intent();
            outData.putExtra(EVAL_TITLE_EXTRA_KEY, titleEditText.getText().toString());
            setResult(Activity.RESULT_OK, outData);
            finish();
            // setResult...
        });
//        checkIntent();
//        logCycle(" here I am!");
    }

    private Intent checkIntent() {
        // todo
        Intent tmpdata = getIntent();
        return tmpdata;
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