package com.example.user.todolist;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

import static com.example.user.todolist.R.string.show;
import static com.example.user.todolist.R.string.task;


// PAGE WITH FORM TO ADD NEW TASK


// READY


public class TaskActivity extends AppCompatActivity {




    EditText descriptionInput;
    EditText titleInput;
    Boolean completedInput;
    Button backButton;
    Button saveButton;


    public ArrayList<Task> tasks = new ArrayList<Task>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);


        titleInput = (EditText) findViewById(R.id.titleInput);
        descriptionInput = (EditText) findViewById(R.id.descriptionInput);

        backButton = (Button) findViewById(R.id.back_to_list_button);
        saveButton = (Button) findViewById(R.id.save_button);
    }



    public void onSaveButtonClicked(View button) {

        String title = titleInput.getText().toString();
        String description = descriptionInput.getText().toString();
        Boolean isDone = false;
        Boolean isDeleted = false;

        if(titleInput.getText().toString().length() == 0 ) {
            titleInput.setError( "Input Field Is Empty");
        }
        else {
            SharedPreferences sharedPref = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
            String tasks = sharedPref.getString(/*if there is something under this->*/"taskList", /*create an empty tasklist, then turn it into a string, if there is nothing*/new TasksList().getList().toString());
            Gson gson = new Gson();
            TypeToken<ArrayList<Task>> taskArrayList = new TypeToken<ArrayList<Task>>(){};
            ArrayList<Task> taskList = gson.fromJson(/*tasks is the string from step above*/tasks, taskArrayList.getType());
            Task newTask = new Task(title, description, isDone, isDeleted);
            taskList.add(newTask);

            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("taskList", gson.toJson(taskList));
            editor.apply();

            Toast.makeText(this, "Saved!", Toast.LENGTH_LONG).show();
//            finish();
//            super.onResume();
            Intent intent = new Intent(this, TasksListActivity.class); // the activity we want to go to when pressing the button
            startActivity(intent); // starts the intent (confirms it's ok to go)
        }
    }

    @Override
    protected void onResume() {
        super.onResume();


    }

    public void onBackButtonClicked(View button) {
//        finish();
        Log.d(getClass().toString(), "onBackButtonClicked was called");
        Intent intent = new Intent(this, TasksListActivity.class); // the activity we want to go to when pressing the button
        intent.putExtra("task", task);
        startActivity(intent); // starts the intent (confirms it's ok to go)
    }



}
