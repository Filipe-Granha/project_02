package com.example.user.todolist;


import android.os.Bundle;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by user on 08/07/2017.
 */

public class Task implements Serializable {

    private String title;
    private String description;
    private boolean isDone;

    public  Task(String title, String description, boolean isDone) {
        this.title = title;
        this.description = description;
        this.isDone = isDone;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setCompleted() {
        this.isDone = true;
    }

    public boolean getCompletedStatus() {
        return this.isDone;
    }






}
