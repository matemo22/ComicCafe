package com.example.matemo.comiccafe;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Matemo on 11/19/2017.
 */

public class Manga implements Serializable{
    private String title, author, description, status, img_cover;
    ArrayList<String> tag;
    ArrayList<Chapter>chapters;
    int id, favorite;

    public Manga(int id, String title, String author, String status, String description, int favorite, String img_cover) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.description = description;
        this.status = status;
        this.tag = new ArrayList<String>();
        this.favorite = favorite;
        this.img_cover = img_cover;
        this.chapters = new ArrayList<Chapter>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int isFavorite() {
        return favorite;
    }

    public void setFavorite(int favorite) {
        this.favorite = favorite;
    }

    public String getImg_cover() {
        return img_cover;
    }

    public void setImg_cover(String img_cover) {
        this.img_cover = img_cover;
    }

    public int getFavorite() {
        return favorite;
    }

    public ArrayList<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(ArrayList<Chapter> chapters) {
        this.chapters = chapters;
    }
}
