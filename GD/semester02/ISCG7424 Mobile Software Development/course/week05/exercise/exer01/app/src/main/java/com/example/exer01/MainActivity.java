package com.example.exer01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    StudentDao studentDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        studentDao = StudentDB.getInstance(this).studentDao();
    }
    public void addStudent(View view) {
        Student student = new Student("John",85);
        studentDao.insertStudent(student);
        Toast.makeText(this, "Student added Successfully",
                Toast.LENGTH_SHORT).show();
    }

    public void displayAllStudents(View view) {
        List<Student> students = studentDao.getAllStudents();
        Toast.makeText(this, ""+students.size()+" " +students.toString(),
                Toast.LENGTH_SHORT).show();
    }

    public void deleteAllStudents(View view) {

        studentDao.deleteAllStudents();
        Toast.makeText(this, "All Students Deleted",
                Toast.LENGTH_SHORT).show();
    }
}
