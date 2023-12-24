package com.example.myroomexer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

     BookDao bookDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bookDao=BookDB.getInstance(this).bookDao();
    }

    public void addBook(View view) {
        Book book = new Book("John",85);
        bookDao.insertBook(book);
        Toast.makeText(this, "Book added Successfully",
                Toast.LENGTH_SHORT).show();
    }

    public void displayAllBooks(View view) {
        List<Book> books = bookDao.getAllBooks();
        Toast.makeText(this, ""+books.size()+" " +books.toString(),
                Toast.LENGTH_SHORT).show();
    }

    public void deleteAllBooks(View view) {

        bookDao.deleteAll();
        Toast.makeText(this, "All Books Deleted",
                Toast.LENGTH_SHORT).show();
    }

}