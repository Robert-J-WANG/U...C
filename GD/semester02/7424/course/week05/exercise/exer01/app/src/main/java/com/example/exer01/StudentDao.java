package com.example.exer01;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface StudentDao {
    @Insert
    void insertStudent(Student s);

    @Query("SELECT * FROM Student")
    List<Student> getAllStudents();

    @Query("DELETE  FROM Student")
    void deleteAllStudents();

}
