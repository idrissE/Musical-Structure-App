package com.example.android.musicalstructureapp.Models;

public class Album {
    private int mId;
    private String mTitle;
    private int mPosterThumbnail;

    public Album(int id, String title, int posterThumbnail) {
        mId = id;
        mTitle = title;
        mPosterThumbnail = posterThumbnail;
    }

    public int getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public int getPosterThumbnail() {
        return mPosterThumbnail;
    }
}
