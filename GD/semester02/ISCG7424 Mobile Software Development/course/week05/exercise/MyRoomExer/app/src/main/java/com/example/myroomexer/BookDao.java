package com.example.myroomexer;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

////创建数据库操作接口

@Dao
public interface BookDao {
    @Insert
    void insertBook(Book book);

    @Query("SELECT * FROM Book")
    List<Book> getAllBooks();

    @Delete
    void deleteBook(Book book);

    @Query("DELETE FROM Book")
    void deleteAll();

}