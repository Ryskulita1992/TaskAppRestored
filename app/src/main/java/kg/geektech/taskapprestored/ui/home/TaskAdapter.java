package kg.geektech.taskapprestored.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import kg.geektech.taskapprestored.R;
import kg.geektech.taskapprestored.models.Task;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder>{

    public ArrayList<Task> list;
    private AdapterView.OnItemClickListener onItemClickListener;
    public TaskAdapter(ArrayList<Task> list) {

        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_task, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(list.get(position));
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    public  void update(ArrayList<Task> Task) {
        list = Task;
        notifyDataSetChanged();
    }
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textTitle;
        TextView textDesc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textTitle=itemView.findViewById(R.id.text_title);
            textDesc = itemView.findViewById(R.id.text_description);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
        public void bind(Task task) {
            textTitle.setText(task.getTitle());
            textDesc.setText(task.getDescription());
        }
    }
}

