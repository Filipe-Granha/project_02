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


    Button onCompletedButton;
    Button onDeletedButton;
    Task task;

    // DISPLAYS DETAILS OF EACH INDIVIDUAL TASK


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_task);


        onCompletedButton = (Button) findViewById(R.id.completedButton);

        task = (Task) getIntent().getSerializableExtra("task");

        TextView list = (TextView) findViewById(R.id.individual_task);

        String taskString = "" + "" + "" + "";

        if (task != null) {
            taskString += "TAzK:" + "\n" + task.getTitle() + "\n" + "\n" + "DETAILS:" + "\n" + task.getDescription();

        }
        list.setText(taskString);
   }

    @Override
    protected void onResume() {
        super.onResume();


    }


    public void onCompletedButton(View button) {

        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);

        String arrayListAsString =  sharedPref.getString("taskList", new ArrayList<Task>().toString());

        Gson gson = new Gson();

        TypeToken<ArrayList<Task>> typeToken = new TypeToken<ArrayList<Task>>(){};

        ArrayList<Task> allTasks =  gson.fromJson(arrayListAsString, typeToken.getType());

        for(Task tmpTask: allTasks) {
            if(tmpTask.getTitle().equals(task.getTitle())) {
                tmpTask.setCompleted();
            }
        }

        String backToJson = gson.toJson(allTasks);

        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putString("taskList", backToJson);
        editor.apply();
//        finish();

        Intent intent = new Intent(this, TasksListActivity.class);
      intent.putExtra("taskCompleted", task);
        startActivity(intent);
      Log.d(getClass().toString(), "onCompletedButton was called");
    }


    public void onDeletedButton(View button) {

        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);

        String arrayListAsString =  sharedPref.getString("taskList", new ArrayList<Task>().toString());

        Gson gson = new Gson();

        TypeToken<ArrayList<Task>> typeToken = new TypeToken<ArrayList<Task>>(){};

        ArrayList<Task> allTasks =  gson.fromJson(arrayListAsString, typeToken.getType());

        for(Task tmpTask: allTasks) {
            if(tmpTask.getTitle().equals(task.getTitle())) {
                tmpTask.setDeleted();
            }
        }

        String backToJson = gson.toJson(allTasks);

        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putString("taskList", backToJson);
        editor.apply();
//        finish();

        Intent intent = new Intent(this, TasksListActivity.class);
        intent.putExtra("taskDeleted", task);
        startActivity(intent);
        Log.d(getClass().toString(), "onDeletedButton was called");


    }





}