package com.example.user.todolist;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import java.util.ArrayList;

/**
 * Created by user on 08/07/2017.
 */

public class TasksList { // class


    public ArrayList<Task> list; // instance variable




    public TasksList(){ // constructor
        list = new ArrayList<Task>();

        list.add(new Task("Task B", "Another description, this time for task B"));

    }


    public ArrayList<Task> getList() {
        return new ArrayList<Task>(list);
    }






}
