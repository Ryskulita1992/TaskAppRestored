package kg.geektech.taskapprestored;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import kg.geektech.taskapprestored.App;
import kg.geektech.taskapprestored.R;
import kg.geektech.taskapprestored.models.Task;

public class FormActivity extends AppCompatActivity {

    private EditText editTitle;
    private EditText editDesc;
    private Task task;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Новая Задача");
        }
        editTitle = findViewById(R.id.edit_title);
        editDesc = findViewById(R.id.edit_description);
        task = new Task();
        if (getIntent() != null) {
            task = (Task) getIntent().getSerializableExtra("ss");
            editTitle.setText(task.getTitle());
            editDesc.setText(task.getDescription());
//            App.getInstance().getDatabase().taskDao().updateSalaryByIdList();
        }

    }


    public void onClick(View view) {
        String title = editTitle.getText().toString().trim();
        String desc = editDesc.getText().toString().trim();
        Task task = new Task(title, desc);
        App.getInstance().getDatabase().taskDao().insert(task);
//        Intent intent = new Intent();
//        intent.putExtra("task", task);
//        setResult(RESULT_OK, intent);
        finish();
    }
}
