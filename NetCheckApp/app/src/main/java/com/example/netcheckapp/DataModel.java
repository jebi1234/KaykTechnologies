package com.example.netcheckapp;

import com.google.gson.annotations.SerializedName;

public class DataModel {

    @SerializedName("name")
    private String name;
    @SerializedName("imageurl")
    private String imageurl;

    public DataModel(String name, String imageurl) {
        this.name = name;
        this.imageurl = imageurl;
    }

    public String getName() {
        return name;
    }

    public String getImageurl() {
        return imageurl;
    }
}
