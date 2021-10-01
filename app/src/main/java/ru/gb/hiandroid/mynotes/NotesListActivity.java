package ru.gb.hiandroid.mynotes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;


public class NotesListActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private final String CUR_ACTIVITY_TAG = "@@@ ListActivity";
    private String log_modifyer = " ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_list);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.notes_list_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.new_note_menu) {
            logCycle("--< Menu! >--");
            return true;
        }
        return super.onOptionsItemSelected(item);
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