package com.example.user.todolist;

import java.util.ArrayList;

/**
 * Created by user on 08/07/2017.
 */

public class TasksList { // class




    private ArrayList<Task> list; // instance variable





    public TasksList() { // constructor

        list = new ArrayList<Task>();

        list.add(new Task("Task A", "Description of task A"));
        list.add(new Task("Task B", "Another description, this time for task B"));
        list.add(new Task("Task A", "Description of task A"));
        list.add(new Task("Task A", "Description of task A"));
        list.add(new Task("Task A", "Description of task A"));
        list.add(new Task("Task A", "Description of task A"));
        list.add(new Task("Task A", "Description of task A"));
        list.add(new Task("Task A", "Description of task A"));
        list.add(new Task("Task A", "Description of task A"));
        list.add(new Task("Task A", "Description of task A"));
        list.add(new Task("Task A", "Description of task A"));
        list.add(new Task("Task A", "Description of task A"));
        list.add(new Task("Task A", "Description of task A"));
        list.add(new Task("Task A", "Description of task A"));

    }


    public ArrayList<Task> getList() {

        return new ArrayList<Task>(list);
    }
}
