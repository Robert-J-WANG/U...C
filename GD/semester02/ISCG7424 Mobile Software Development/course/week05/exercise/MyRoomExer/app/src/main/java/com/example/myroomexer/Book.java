package com.example.myroomexer;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Book {
    @PrimaryKey(autoGenerate = true)
    int bid;
    String name;

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Book(String name, int age) {
        this.name = name;
        this.age = age;
    }

    int age;
}
