package com.example.studentroomdatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = {Student.class}, exportSchema = false, version = 2)
public abstract class StudentDatabaseHelper extends RoomDatabase {
    private static final String DB_NAME = "studentdb";
    private static StudentDatabaseHelper instance;

    public static synchronized StudentDatabaseHelper getDB(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context, StudentDatabaseHelper.class, DB_NAME)
                    .fallbackToDestructiveMigration()  // Allow destructive migration
                    .allowMainThreadQueries()
                    .build();
        }

        return instance;
    }

    public abstract StudentDao studentDao();
}

