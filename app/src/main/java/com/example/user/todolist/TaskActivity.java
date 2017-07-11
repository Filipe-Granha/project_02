package com.example.user.todolist;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.user.todolist.R.string.task;


// PAGE WITH FORM TO ADD NEW TASK


public class TaskActivity extends AppCompatActivity {


    EditText descriptionInput;
    EditText titleInput;
    Button backButton;
    Button saveButton;

    private String title;
    private String description;
    public ArrayList<Task> list = new ArrayList<Task>();




    @Override
    protected void onCreate(Bundle savedInstanceState) { // function common to all Activities
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task); // the layout .xml file that will be displayed

        titleInput = (EditText) findViewById(R.id.titleInput);
        descriptionInput = (EditText) findViewById(R.id.descriptionInput);
        backButton = (Button) findViewById(R.id.back_to_list_button);
        saveButton = (Button) findViewById(R.id.save_button);


    }


    // save the users' titleInput and descriptionInput
    public void onSaveButtonClicked(View button) { // function for the Button "Save"



        String getTitle = titleInput.getText().toString();
        String getDescription = descriptionInput.getText().toString();

        if(titleInput.getText().toString().length() == 0 ) {
            titleInput.setError( "Input Field Is Empty");
        }
            else {
            Toast.makeText(this, "Saved!", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, TasksListActivity.class); // the activity we want to go to when pressing the button
            intent.putExtra("task", task);
            startActivity(intent); // starts the intent (confirms it's ok to go)
        }
    }





    public void onBackButtonClicked(View button) { // function for the Button
        Log.d(getClass().toString(), "onBackButtonClicked was called");
        Intent intent = new Intent(this, TasksListActivity.class); // the activity we want to go to when pressing the button
        intent.putExtra("task", task);
        startActivity(intent); // starts the intent (confirms it's ok to go)
    }





}
