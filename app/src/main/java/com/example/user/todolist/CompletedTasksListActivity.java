package com.example.user.todolist;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

/**
 * Created by user on 11/07/2017.
 */

public class CompletedTasksListActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) { // function common to all Activities
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_task);




        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);



        String individualTask = sharedPref.getString("Task", new ArrayList<Task>().toString());
        Log.d("Task String",individualTask);



        Gson gson = new Gson();
        TypeToken<ArrayList<Task>> taskArrayList = new TypeToken<ArrayList<Task>>() {};
        ArrayList<Task> tasks = gson.fromJson(individualTask, taskArrayList.getType());
        Log.d("tasks",tasks.toString());



        Task newTask = (Task) getIntent().getSerializableExtra("task");
        tasks.add(newTask);
        Log.d("tasks",tasks.toString());


        
        TextView list = (TextView) findViewById(R.id.completed_tasks);
                String taskString = "";
        for(Task t : tasks){
            taskString += t.getTitle() + " and another test " + t.getDescription() + "\n";
        }
        list.setText(taskString);
//        String taskString = "";
//        if(newTask !=null)
//
//        {
//
//            taskString += newTask.getTitle() + " banana " + newTask.getDescription();
//        }
//        list.setText(taskString);
    }






}