package com.example.matemo.comiccafe;

/**
 * Created by Matemo on 11/29/2017.
 */

public class ChapterHasImages {
    int id, id_chapter;
    String url;

    public ChapterHasImages(int id, int id_chapter, String url) {
        this.id = id;
        this.id_chapter = id_chapter;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getid_chapter() {
        return id_chapter;
    }

    public void setid_chapter(int id_chapter) {
        this.id_chapter = id_chapter;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
