package ru.gb.hiandroid.mynotes.ui;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import ru.gb.hiandroid.mynotes.R;

public class NoteEditActivity extends AppCompatActivity {
    private final String CUR_ACTIVITY_TAG = "@@@@ EditActivity";
    private String log_modifyer = " ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_edit);
        logCycle(" here I am!");
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