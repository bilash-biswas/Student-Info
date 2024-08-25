package com.example.studentroomdatabase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "student")
public class Student {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "studentName")
    private String studentName;

    @ColumnInfo(name = "subjectName")
    private String subjectName;

    @ColumnInfo(name = "studyTime")
    private String studyTime;

    @ColumnInfo(name = "salary")
    private String salary;

    @ColumnInfo(name = "days")
    private String days;

    @ColumnInfo(name = "mobile")
    private String mobile;

    public Student(int id, String studentName, String subjectName, String salary, String studyTime, String days, String mobile) {
        this.id = id;
        this.studentName = studentName;
        this.subjectName = subjectName;
        this.salary = salary;
        this.studyTime = studyTime;
        this.days = days;
        this.mobile = mobile;
    }
    @Ignore
    public Student(String studentName, String subjectName, String studyTime, String salary, String days, String mobile) {
        this.studentName = studentName;
        this.subjectName = subjectName;
        this.studyTime = studyTime;
        this.salary = salary;
        this.days = days;
        this.mobile = mobile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getStudyTime() {
        return studyTime;
    }

    public void setStudyTime(String studyTime) {
        this.studyTime = studyTime;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
