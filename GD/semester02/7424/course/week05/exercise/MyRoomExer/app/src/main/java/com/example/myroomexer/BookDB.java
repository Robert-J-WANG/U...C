package com.example.myroomexer;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Book.class}, version = 1, exportSchema = false)
public abstract class BookDB extends RoomDatabase{
    private static BookDB bookDB =null;
    public abstract BookDao bookDao();

    // 获取用户数据库实例的方法
    public static BookDB getInstance(Context context){ if(bookDB==null){
        bookDB = Room.databaseBuilder(context.getApplicationContext(), BookDB.class, "BookDB").allowMainThreadQueries().build();
    }
        return bookDB; }
}
