package com.example.matemo.comiccafe;

/**
 * Created by Matemo on 12/3/2017.
 */

public class Backup {
    int id, id_user;
    String date;

    public Backup(int id, int id_user, String date) {
        this.id = id;
        this.id_user = id_user;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
