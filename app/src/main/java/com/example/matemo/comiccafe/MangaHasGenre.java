package com.example.matemo.comiccafe;

/**
 * Created by Matemo on 11/29/2017.
 */

public class MangaHasGenre {
    int id, id_manga, id_genre;

    public MangaHasGenre(int id, int id_manga, int id_genre) {
        this.id = id;
        this.id_manga = id_manga;
        this.id_genre = id_genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_manga() {
        return id_manga;
    }

    public void setId_manga(int id_manga) {
        this.id_manga = id_manga;
    }

    public int getId_genre() {
        return id_genre;
    }

    public void setId_genre(int id_genre) {
        this.id_genre = id_genre;
    }
}
