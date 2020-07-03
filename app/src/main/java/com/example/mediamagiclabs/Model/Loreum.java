package com.example.mediamagiclabs.Model;

public class Loreum {


    private int id;
    private  String author;
    String thumbnail;

    public Loreum(int id, String author,String thumbnail) {
        this.id = id;
        this.author = author;
        this.thumbnail = thumbnail;
    }

    public Loreum() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
