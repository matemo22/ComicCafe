package com.example.matemo.comiccafe;

/**
 * Created by Matemo on 12/3/2017.
 */

public class UserBackupManga {
    int id, id_backup, id_manga;

    public UserBackupManga(int id, int id_backup, int id_manga) {
        this.id = id;
        this.id_backup = id_backup;
        this.id_manga = id_manga;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_backup() {
        return id_backup;
    }

    public void setId_backup(int id_backup) {
        this.id_backup = id_backup;
    }

    public int getId_manga() {
        return id_manga;
    }

    public void setId_manga(int id_manga) {
        this.id_manga = id_manga;
    }
}
