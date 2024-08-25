package com.example.studentroomdatabase;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewStudent extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Student> students;
    private StudentAdapter adapter;
    private StudentDatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_student);


        recyclerView = findViewById(R.id.viewAllStudent);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        students = new ArrayList<>();

        databaseHelper = StudentDatabaseHelper.getDB(this);
        students = (ArrayList<Student>) databaseHelper.studentDao().getAllStudent();
        adapter = new StudentAdapter(this, students);
        recyclerView.setAdapter(adapter);
    }
}
