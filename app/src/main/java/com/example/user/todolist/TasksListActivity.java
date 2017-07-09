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




public class TasksListActivity extends AppCompatActivity { // AppCompatActivity is a subclass of android.app


    Button addButton; // instance variable


    @Override
    protected void onCreate(Bundle savedInstanceState) { // function common to all Activities
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks_list); // the layout .xml file that will be displayed
        Log.d(getClass().toString(), "onCreate called");

        addButton = (Button)findViewById(R.id.addButton); // initializes Button

        //here we start to get our ArrayList of tasks and pass it onto our adapter,
        // for the adapter to do its thing and build those list items.
        TasksList tasksList = new TasksList();
        ArrayList<Task> list = tasksList.getList();
        TasksListAdapter taskAdapter = new TasksListAdapter(this, list);

        // this goes here after having created the Adapter Class
        ListView listView = (ListView) findViewById(R.id.list); // 'list' is from the .xml file (android:id="@+id/list")
        listView.setAdapter(taskAdapter);
    }




    public void onAddButtonClicked(View button) { // for the round button
        Log.d(getClass().toString(), "onAddButtonClicked was called");
        Intent intent = new Intent(this, TaskActivity.class);
        intent.putExtra("task", task);
        startActivity(intent);
    }

    // String question = questionEditText.getText().toString();


    public void getTask(View listItem) {
        Task task = (Task) listItem.getTag();
        Log.d("Task Title: ", task.getTitle());
        Intent intent = new Intent(this, ShowTaskActivity.class); // the activity we want to go to when pressing the button
        startActivity(intent); // starts the intent (confirms it's ok to go)
    }


}
