package com.example.studentroomdatabase;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<Student> students;

    public StudentAdapter(Context context, ArrayList<Student> students) {
        this.context = context;
        this.students = students;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.student, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.time.setText("Time : " + students.get(position).getStudyTime());
        holder.name.setText("Name : " + students.get(position).getStudentName());
        holder.salary.setText("Salary : " + students.get(position).getSalary());
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView name, time, salary;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            time = itemView.findViewById(R.id.time);
            name = itemView.findViewById(R.id.name);
            salary = itemView.findViewById(R.id.salary);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, UpdateActivity.class);
                    intent.putExtra("studentId", students.get(getAdapterPosition()).getId());
                    intent.putExtra("studentName", students.get(getAdapterPosition()).getStudentName());
                    intent.putExtra("subjectName", students.get(getAdapterPosition()).getSubjectName());
                    intent.putExtra("studyTime", students.get(getAdapterPosition()).getStudyTime());
                    intent.putExtra("salary", students.get(getAdapterPosition()).getSalary());
                    intent.putExtra("days", students.get(getAdapterPosition()).getDays());
                    intent.putExtra("mobile", students.get(getAdapterPosition()).getMobile());
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            });
        }
    }
}
