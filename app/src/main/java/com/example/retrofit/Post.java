package com.example.retrofit;

import com.google.gson.annotations.SerializedName;

public class Post {
    private  String title ;

    @SerializedName("bosy")

    private  String text ;

    private int id ;

    private int userId ;

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }
}
