package com.example.matemo.comiccafe;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Matemo on 11/19/2017.
 */

public class Manga implements Parcelable {
    private String title, author, description, status;
    ArrayList<String> tag;
    int favorite, img_cover, chapters;

    public Manga(String title, String author, String status, int favorite, int img_cover) {
        this.title = title;
        this.author = author;
        this.description = "No Description Yet";
        this.status = status;
        this.tag = new ArrayList<String>();
        this.favorite = favorite;
        this.img_cover = img_cover;
        this.chapters = 0;
    }

    public Manga(String title, String author, String status, String description, int chapters, int favorite, int img_cover) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.status = status;
        this.tag = new ArrayList<String>();
        this.favorite = favorite;
        this.img_cover = img_cover;
        this.chapters = chapters;
    }

    protected Manga(Parcel in) {
        title = in.readString();
        author = in.readString();
        description = in.readString();
        status = in.readString();
        tag = in.createStringArrayList();
        chapters = in.readInt();
        favorite = in.readInt();
        img_cover = in.readInt();
    }

    public static final Creator<Manga> CREATOR = new Creator<Manga>() {
        @Override
        public Manga createFromParcel(Parcel in) {
            return new Manga(in);
        }

        @Override
        public Manga[] newArray(int size) {
            return new Manga[size];
        }
    };

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

    public int getImg_cover() {
        return img_cover;
    }

    public void setImg_cover(int img_cover) {
        this.img_cover = img_cover;
    }

    public int getFavorite() {
        return favorite;
    }

    public int getChapters() {
        return chapters;
    }

    public void setChapters(int chapters) {
        this.chapters = chapters;
    }

    public static Creator<Manga> getCREATOR() {
        return CREATOR;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(author);
        parcel.writeString(description);
        parcel.writeString(status);
        parcel.writeStringArray(tag.toArray(new String[tag.size()]));
        parcel.writeInt(chapters);
        parcel.writeInt(favorite);
        parcel.writeInt(img_cover);
    }
}
