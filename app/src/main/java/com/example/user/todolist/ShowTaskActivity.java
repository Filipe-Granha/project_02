package com.example.user.todolist;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class ShowTaskActivity extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) { // function common to all Activities
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_task); // the layout .xml file that will be displayed



        // STEP 1 - Creates SharedPreferences database, named sharedPref
        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);



        // STEP 2 - Transforms ArrayList into JSon String (individualTask) and sends it to database (sharedPref)
        String individualTask = sharedPref.getString("Task", new ArrayList<Task>().toString());
        Log.d("Task String", individualTask);



        // STEP 3 - Tells GSon to transform JSon String (individualTask) back into an ArrayList (tasks)
        Gson gson = new Gson();
        TypeToken<ArrayList<Task>> taskArrayList = new TypeToken<ArrayList<Task>>(){};
        ArrayList<Task> tasks = gson.fromJson(individualTask, taskArrayList.getType());
        Log.d("tasks", tasks.toString());



        // STEP 4 - Adds whichever movie (newTask) we click on the list to the ArrayList (tasks)
        Task newTask = (Task) getIntent().getSerializableExtra("task");
        tasks.add(newTask);
        Log.d("tasks", tasks.toString());



        // STEP 5 - Creates Text View box (which is a container,
        // essential for anything to show up on the Activity)
        // and displays a basic String with the task details
        TextView list = (TextView)findViewById(R.id.individual_task);
        String taskString = "";
        for(Task t : tasks){
            taskString += t.getTitle() + " " + t.getDescription() + "\n";
        }
        list.setText(taskString);
    }

}
