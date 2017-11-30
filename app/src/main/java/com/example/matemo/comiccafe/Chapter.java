package com.example.matemo.comiccafe;

        import java.io.Serializable;
        import java.util.ArrayList;

/**
 * Created by Matemo on 11/20/2017.
 */

public class Chapter implements Serializable{
    String title;
    ArrayList<String> urlImg;
    int num, status;

    public Chapter(String title, int num)
    {
        this.title=title;
        this.urlImg=new ArrayList<String>();
        this.num = num;
        status = 0;
    }

    public void addUrl(String url)
    {
        urlImg.add(url);
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<String> getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(ArrayList<String> urlImg) {
        this.urlImg = urlImg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
