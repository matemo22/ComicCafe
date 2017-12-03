package com.example.matemo.comiccafe;

/**
 * Created by Matemo on 11/29/2017.
 */

public class MangaHasChapter {
    int id, id_manga, num_chapter;
    String title;

    public MangaHasChapter(int id, int id_manga, int num_chapter, String title) {
        this.id = id;
        this.id_manga = id_manga;
        this.num_chapter = num_chapter;
        this.title = title;
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

    public int getNum_chapter() {
        return num_chapter;
    }

    public void setNum_chapter(int num_chapter) {
        this.num_chapter = num_chapter;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
