package com.example.matemo.comiccafe;

/**
 * Created by Matemo on 11/29/2017.
 */

public class Genre {
    int id;
    String name;

    public Genre(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
