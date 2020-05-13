package kg.geektech.taskapprestored.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import kg.geektech.taskapprestored.R;
import kg.geektech.taskapprestored.models.Task;

import static android.app.Activity.RESULT_OK;


public class HomeFragment extends Fragment {
    public TaskAdapter adapter;
    public ArrayList<Task> list = new ArrayList<>();
    Task task;
    int position;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return  inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new TaskAdapter(list);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onActivityResult(int requestCode,int resultCode,   @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 8 &&resultCode==RESULT_OK &&  data!=null){
            task = (Task) data.getSerializableExtra("task");
            list.add(position,task);
            adapter.update(list);
            adapter.notifyDataSetChanged();
            Log.e("ololo", "incoming data to HomeFragment");
        }
    }
}








