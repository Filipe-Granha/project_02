package com.example.user.todolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;
import static com.example.user.todolist.R.string.task;


// STARTING PAGE OF THE APP


public class TasksListActivity extends AppCompatActivity { // AppCompatActivity is a subclass of android.app


    Button addButton; // instance variable


    @Override
    protected void onCreate(Bundle savedInstanceState) { // function common to all Activities
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks_list); // the layout .xml file that will be displayed
        Log.d(getClass().toString(), "onCreate called");


        // initializes Button
        addButton = (Button)findViewById(R.id.addButton);


        // adapter takes the ArrayList and builds the listView
        TasksList tasksList = new TasksList();
        ArrayList<Task> list = tasksList.getList();
        TasksListAdapter taskAdapter = new TasksListAdapter(this, list);


        // this goes here after having created the Adapter Class
        // 'list' is from the .xml file (android:id="@+id/list")
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(taskAdapter);
    }



    // button takes to TaskActivity
    public void onAddButtonClicked(View button) {
        Log.d(getClass().toString(), "onAddButtonClicked was called");
        Intent intent = new Intent(this, TaskActivity.class);
        intent.putExtra("task", task);
        startActivity(intent);
    }


    // on click in each item of the list, takes us to the ShowTaskActivity
    public void getTask(View listItem) {
        Task task = (Task) listItem.getTag();
        Intent intent = new Intent(this, ShowTaskActivity.class); // the activity we want to go to when pressing the button
        intent.putExtra("task", task);
        startActivity(intent); // starts the intent (confirms it's ok to go)
        Log.d("Task Title: ", task.getTitle()); // for logging purposes only
    }



}
