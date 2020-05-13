package kg.geektech.taskapprestored.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;

import java.io.Serializable;
@Entity

public class Task implements Serializable{
    private String title, description;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
