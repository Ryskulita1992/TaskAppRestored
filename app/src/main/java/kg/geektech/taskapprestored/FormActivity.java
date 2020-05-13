package kg.geektech.taskapprestored;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import kg.geektech.taskapprestored.App;
import kg.geektech.taskapprestored.R;
import kg.geektech.taskapprestored.models.Task;

public class FormActivity extends AppCompatActivity {


    private EditText editTitle;
    private EditText editDesc;
    private Task editTask;
    private int position;


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

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 8 && resultCode == RESULT_OK   && data != null) {
            Task task= (Task) data.getSerializableExtra("task1");
            editTitle.setText(task.getTitle());
            editDesc.setText(task.getDesc());



            Log.e("ololo", "get info from VH   and dhould be editable in the FormActivity");
            }
        }



    public void save(View view) {
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
