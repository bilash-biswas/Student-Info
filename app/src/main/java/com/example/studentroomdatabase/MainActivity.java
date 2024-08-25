package com.example.studentroomdatabase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.studentroomdatabase.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        StudentDatabaseHelper databaseHelper = StudentDatabaseHelper.getDB(getApplicationContext());

        binding.addStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.studentName.getText().toString().isEmpty()){
                    binding.studentName.setError("enter student name");
                }
                databaseHelper.studentDao().insert(
                        new Student(
                        binding.studentName.getText().toString(),
                        binding.subjectName.getText().toString(),
                        binding.studyTime.getText().toString(),
                        binding.salary.getText().toString(),
                        binding.activeDays.getText().toString(),
                        binding.mobileNumber.getText().toString()
                        )
                );
                finish();
            }
        });
    }
}