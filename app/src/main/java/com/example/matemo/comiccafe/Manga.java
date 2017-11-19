package com.example.matemo.comiccafe;

import java.util.ArrayList;

/**
 * Created by Matemo on 11/19/2017.
 */

public class Manga {
    private String title, author, description, status;
    ArrayList<String> tag;
    boolean favorite;
    int img_cover;

    public Manga(String title, String author, String status, boolean favorite, int img_cover) {
        this.title = title;
        this.author = author;
        this.description = "No Description Yet";
        this.status = status;
        this.tag = new ArrayList<String>();
        this.favorite = favorite;
        this.img_cover = img_cover;
    }

    public void addTag(String newTag)
    {
        tag.add(newTag);
    }

    public void deleteTag(String deletedTag)
    {
        tag.remove(deletedTag);
    }

    public void clearTag()
    {
        tag.clear();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<String> getTag() {
        return tag;
    }

    public void setTag(ArrayList<String> tag) {
        this.tag = tag;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public int getImg_cover() {
        return img_cover;
    }

    public void setImg_cover(int img_cover) {
        this.img_cover = img_cover;
    }
}
