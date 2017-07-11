package com.example.user.todolist;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

import static android.R.attr.data;
import static com.example.user.todolist.R.id.tasksCounter;
import static com.example.user.todolist.R.string.task;


// STARTING PAGE OF THE APP


public class TasksListActivity extends AppCompatActivity { // AppCompatActivity is a subclass of android.app


    Button addButton;
    TextView tasksCounter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks_list);
        Log.d(getClass().toString(), "onCreate called");

        addButton = (Button)findViewById(R.id.addButton);







        // STEP 1 - Creates SharedPreferences database, named sharedPref
        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);



        // STEP 2 - Transforms ArrayList into JSon String (individualTask) and sends it to database (sharedPref)
        String individualTask = sharedPref.getString("Task", new ArrayList<Task>().toString());
        Log.d("Task String", individualTask);


        // STEP 3 - Tells GSon to transform JSon String (individualTask) back into an ArrayList (tasks)
        Gson gson = new Gson();
        TypeToken<ArrayList<Task>> taskArrayList = new TypeToken<ArrayList<Task>>(){};
        ArrayList<Task> tasks = gson.fromJson(individualTask, taskArrayList.getType());
//        TasksListAdapter taskAdapter = new TasksListAdapter(this, tasks);
        Log.d("tasks", tasks.toString());



        // STEP 6
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("Task", gson.toJson(tasks));
        editor.apply();



        TasksListAdapter taskAdapter = new TasksListAdapter(this, tasks);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(taskAdapter);


    }


    public void onAddButtonClicked(View button) {
        Log.d(getClass().toString(), "onAddButtonClicked was called");
        Intent intent = new Intent(this, TaskActivity.class);
        intent.putExtra("task", task);
        startActivity(intent);
    }

    // Counter for total number of tasks
    public void countAllTasks(View TextView) {
//        TextView textView = (TextView) findViewById(tasksCounter);
        ArrayList<Task> tasks = new ArrayList<Task>();
        int counter = 0;
        String counterString = "Your list is empty!";
        String counterStringTwo = "";
        if (tasks == null) {
            counterString += " Add a task now?";
            for (Task t : tasks) {
                counter += 1;
            }
        }
    }

//    tasks.size(); ??







    // on click in each item of the list, takes us to  ShowTaskActivity
    public void getTask(View listItem) {
        Task task = (Task) listItem.getTag();
        Intent intent = new Intent(this, ShowTaskActivity.class); // the activity we want to go to when pressing the button
        intent.putExtra("task", task);
        startActivity(intent); // starts the intent (confirms it's ok to go)
        Log.d("Task Title: ", task.getTitle()); // for logging purposes only
    }







}
