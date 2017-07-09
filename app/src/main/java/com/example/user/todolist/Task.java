package com.example.user.todolist;



/**
 * Created by user on 08/07/2017.
 */

public class Task {

    private String title;
    private String description;




    public  Task(String title, String description) {
        this.title = title;
        this.description = description;
    }



    public String getTitle() {
        return this.title;
    }


    public String getDescription() {
        return this.description;
    }



}
