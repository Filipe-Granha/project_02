package com.example.user.todolist;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;

import static com.example.user.todolist.R.string.task;



public class ShowTaskActivity extends AppCompatActivity {


    Button completedButton;


    // DISPLAYS DETAILS OF EACH INDIVIDUAL TASK


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_task);


        completedButton = (Button) findViewById(R.id.completedButton);


//        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
//
//
//
//        String individualTask = sharedPref.getString("Task", new ArrayList<Task>().toString());
//        Log.d("Task String", individualTask);
//
//
//
//        Gson gson = new Gson();
//        TypeToken<ArrayList<Task>> taskArrayList = new TypeToken<ArrayList<Task>>() {
//        };
//        ArrayList<Task> tasks = gson.fromJson(individualTask, taskArrayList.getType());
//        Log.d("tasks", tasks.toString());
//


        Task newTask = (Task) getIntent().getSerializableExtra("task");



        TextView list = (TextView) findViewById(R.id.individual_task);
        String taskString = "";
        if (newTask != null) {
            taskString += newTask.getTitle() + " banana " + newTask.getDescription();
        }
        list.setText(taskString);
    }



    // NOT WORKING! MAKES THE APP CRASH
    public void onCompletedButton(View button) {
        Log.d(getClass().toString(), "onCompletedButton was called");



        Intent intent = new Intent(this, TasksListActivity.class); // the activity we want to go to when pressing the button
       // intent.putExtra("task", task);
        startActivity(intent); // starts the intent (confirms it's ok to go)
    }


}