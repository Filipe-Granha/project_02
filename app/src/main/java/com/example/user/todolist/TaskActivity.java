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
import android.widget.Toast;

import static com.example.user.todolist.R.string.task;



public class TaskActivity extends AppCompatActivity {



    EditText descriptionInput;
    EditText titleInput;
    Button backButton;
    Button saveButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) { // function common to all Activities
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task); // the layout .xml file that will be displayed

        backButton = (Button)findViewById(R.id.back_to_list_button); // initializes Button
        saveButton = (Button)findViewById(R.id.save_button);
    }


    public void onBackButtonClicked(View button) { // function for the Button
        Log.d(getClass().toString(), "onBackButtonClicked was called");
        Intent intent = new Intent(this, TasksListActivity.class); // the activity we want to go to when pressing the button
        intent.putExtra("task", task);
        startActivity(intent); // starts the intent (confirms it's ok to go)
    }





}
