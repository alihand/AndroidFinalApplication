package com.example.alihandemir.androidmidterm;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "items")
public class ItemDetail {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "id")
    private int Id;
    @ColumnInfo(name = "imageUrl")
    private String ImageUrl;
    @ColumnInfo(name = "creator")
    private String Creator;
    @ColumnInfo(name = "likes")
    private int Likes;

    public ItemDetail(String ImageUrl,String Creator,int Likes){
        this.ImageUrl = ImageUrl;
        this.Creator = Creator;
        this.Likes = Likes;
    }

    @NonNull
    public int getId() {
        return Id;
    }

    public void setId(@NonNull int id) {
        Id = id;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getCreator() {
        return Creator;
    }

    public void setCreator(String creator) {
        Creator = creator;
    }

    public int getLikes() {
        return Likes;
    }

    public void setLikes(int likes) {
        Likes = likes;
    }
}