package kg.geektech.taskapprestored;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import kg.geektech.taskapprestored.R;
import kg.geektech.taskapprestored.models.Task;


public class FormActivity extends AppCompatActivity {
    private EditText editTitle, editDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Новая задача");
        }
        editTitle = findViewById(R.id.edit_title);
        editDescription = findViewById(R.id.edit_description);
    }
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    public void save(View view) {
        String title = editTitle.getText().toString().trim();
        String description = editDescription.getText().toString().trim();
        Task task = new Task(title, description);
        Intent intent = new Intent();
        intent.putExtra("task", task);
        setResult(RESULT_OK, intent);
        finish();
        Log.e("ololo", "Save button should send task");
    }
}


