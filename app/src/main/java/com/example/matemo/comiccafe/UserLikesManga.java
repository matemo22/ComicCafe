package com.example.matemo.comiccafe;

/**
 * Created by Matemo on 12/3/2017.
 */

public class UserLikesManga {
    int id, id_user, id_manga;

    public UserLikesManga(int id, int id_user, int id_manga) {
        this.id = id;
        this.id_user = id_user;
        this.id_manga = id_manga;
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

    public int getId_manga() {
        return id_manga;
    }

    public void setId_manga(int id_manga) {
        this.id_manga = id_manga;
    }
}
