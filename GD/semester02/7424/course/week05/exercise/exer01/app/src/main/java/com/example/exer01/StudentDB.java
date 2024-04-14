package com.example.exer01;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Student.class}, version = 1, exportSchema = false)
public abstract class StudentDB extends RoomDatabase {
    private static StudentDB studentDB =null;

    public abstract StudentDao studentDao();

    public static StudentDB getInstance(Context context){
        if(studentDB==null){
            studentDB = Room.databaseBuilder(context.getApplicationContext(),
                    StudentDB.class, "StudentDB").allowMainThreadQueries().build();
        }
        return studentDB;
    }
}
