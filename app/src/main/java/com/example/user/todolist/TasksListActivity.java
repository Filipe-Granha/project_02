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


    //    Button addButton;
    TextView list;
    ArrayList<Task> tasks;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks_list);
        Log.d(getClass().toString(), "onCreate called");

//        addButton = (Button) findViewById(R.id.addButton);


        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);

        String tasks = sharedPref.getString(/*if there is something under this->*/"taskList", /*create an empty tasklist, then turn it into a string, if there is nothing*/new TasksList().getList().toString());
        Log.d("Just a literal string of tasks we get back from sharedpref", tasks);


        Gson gson = new Gson();
        TypeToken<ArrayList<Task>> taskArrayList = new TypeToken<ArrayList<Task>>() {
        };
        ArrayList<Task> taskList = gson.fromJson(/*tasks is the string from step above*/tasks, taskArrayList.getType());
        ArrayList<Task> filteredTaskList = new ArrayList<Task>();
        for (Task task : taskList) {
            if (!task.getDeletedStatus()) {
                filteredTaskList.add(task);
            }
        }
        Log.d("This is an ArrayList of Task objects", taskList.toString());


        TasksListAdapter taskAdapter = new TasksListAdapter(this, filteredTaskList);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(taskAdapter);

        //TEST
        TextView list = (TextView) findViewById(R.id.tasksCounter);

//        int counter = 0;
//        String counterString = "Your list is empty!";
        String counterStringTwo = "" + "";
        if (filteredTaskList != null) {
            counterStringTwo += "Tazkz in your list: " + filteredTaskList.size();
//            for (Task t : allTasks) {
//                counter += 1;
//            }

//        }
//

        }
//        else "Your list is empty!";
        list.setText(counterStringTwo);

        //TEST


    }

    @Override
    protected void onResume() {
        super.onResume();


    }

    public void onAddButtonClicked(View button) {
        Intent intent = new Intent(this, TaskActivity.class);
        intent.putExtra("task", task);
        startActivity(intent);
        Log.d(getClass().toString(), "onAddButtonClicked was called");
    }


    // on click in each item of the list, takes us to  ShowTaskActivity
    public void getTask(View listItem) {

        Task task = (Task) listItem.getTag();
        Intent intent = new Intent(this, ShowTaskActivity.class);
        intent.putExtra("task", task);
        startActivity(intent);
        Log.d("Task Title: ", task.getTitle());

    }


    public void countAllTasks(View TextView) {

        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);

        String arrayListAsString = sharedPref.getString("taskList", new ArrayList<Task>().toString());

        Gson gson = new Gson();

        TypeToken<ArrayList<Task>> typeToken = new TypeToken<ArrayList<Task>>() {
        };
    }
}

        // TEST

//        TextView list = (TextView) findViewById(R.id.tasksCounter);
//
//        String taskString = "" + "" + "" + "";
//
//        if (task != null) {
//            taskString +="TAzK:" + "\n" + task.getTitle() + "\n" + "\n" + "DETAILS:" + "\n" + task.getDescription();
//
//        }
//        list.setText(taskString);
        //TEST

//        ArrayList<Task> allTasks = gson.fromJson(arrayListAsString, typeToken.getType());

//        TextView list = (TextView) findViewById(R.id.tasksCounter);
//
////        int counter = 0;
////        String counterString = "Your list is empty!";
//        String counterStringTwo = "" + "";
//        if (allTasks != null) {
//            counterStringTwo += " There are " + allTasks.size() + "Tazks";
////            for (Task t : allTasks) {
////                counter += 1;
////            }
////        }
////        else ("Your list is empty!");
//
//        }
//        list.setText(counterStringTwo);
//    }


//    tasks.size(); ??

//    public int getCount() {
//        return tasks.size();  ??
//    }





