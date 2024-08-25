package com.example.studentroomdatabase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.studentroomdatabase.databinding.ActivityUpdateBinding;

public class UpdateActivity extends AppCompatActivity {
    private ActivityUpdateBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUpdateBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Intent intent = getIntent();
        int studentId = intent.getIntExtra("studentId",-1);
        binding.studentName.setText(intent.getStringExtra("studentName"));
        binding.subjectName.setText(intent.getStringExtra("subjectName"));
        binding.activeDays.setText(intent.getStringExtra("days"));
        binding.salary.setText(intent.getStringExtra("salary"));
        binding.studyTime.setText(intent.getStringExtra("studyTime"));
        binding.mobileNumber.setText(intent.getStringExtra("mobile"));

        StudentDatabaseHelper databaseHelper = StudentDatabaseHelper.getDB(getApplicationContext());

        binding.updateStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student = new Student(
                        binding.studentName.getText().toString(),
                        binding.subjectName.getText().toString(),
                        binding.studyTime.getText().toString(),
                        binding.salary.getText().toString(),
                        binding.activeDays.getText().toString(),
                        binding.mobileNumber.getText().toString()
                );

                student.setId(studentId);
                databaseHelper.studentDao().update(student);
                finish();
            }
        });

        binding.deleteStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student = new Student(
                        binding.studentName.getText().toString(),
                        binding.subjectName.getText().toString(),
                        binding.studyTime.getText().toString(),
                        binding.salary.getText().toString(),
                        binding.activeDays.getText().toString(),
                        binding.mobileNumber.getText().toString()
                );

                student.setId(studentId);
                databaseHelper.studentDao().delete(student);

                finish();
            }
        });

    }
}