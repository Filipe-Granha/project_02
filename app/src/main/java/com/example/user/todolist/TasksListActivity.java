package com.example.user.todolist;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;

import static com.example.user.todolist.R.string.task;


// STARTING PAGE OF THE APP


public class TasksListActivity extends AppCompatActivity {


    Button addButton;
    TextView tasksCounter;
    ArrayList<Task> tasks;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks_list);
        Log.d(getClass().toString(), "onCreate called");

        addButton = (Button)findViewById(R.id.addButton);





        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);

        String tasks = sharedPref.getString(/*if there is something under this->*/"taskList", /*create an empty tasklist, then turn it into a string, if there is nothing*/new TasksList().getList().toString());
        Log.d("Just a literal string of tasks we get back from sharedpref", tasks);




        Gson gson = new Gson();
        TypeToken<ArrayList<Task>> taskArrayList = new TypeToken<ArrayList<Task>>(){};
        ArrayList<Task> taskList = gson.fromJson(/*tasks is the string from step above*/tasks, taskArrayList.getType());
        Log.d("This is an ArrayList of Task objects", taskList.toString());


        TasksListAdapter taskAdapter = new TasksListAdapter(this, taskList);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(taskAdapter);


    }




    public void onAddButtonClicked(View button) {
        Log.d(getClass().toString(), "onAddButtonClicked was called");
        Intent intent = new Intent(this, TaskActivity.class);
        intent.putExtra("task", task);
        startActivity(intent);
    }




    // on click in each item of the list, takes us to  ShowTaskActivity
    public void getTask(View listItem) {
        Task task = (Task) listItem.getTag();
        Intent intent = new Intent(this, ShowTaskActivity.class);
        intent.putExtra("task", task);
        startActivity(intent);
        Log.d("Task Title: ", task.getTitle());
    }




    // NOT WORKING - Counter for total number of tasks
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

//    public int getCount() {
//        return tasks.size();  ??
//    }




}
