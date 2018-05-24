package com.example.android.musicalstructureapp.Models;

public class Song {
    // song id
    private int mId;
    // album to which the song belongs
    private int mAlbumId;
    private String mTitle;
    private String mArtist;
    private int mThumbnail;

    public Song(int id, int albumId, String title, String artist, int thumbnail) {
        mId = id;
        mAlbumId = albumId;
        mTitle = title;
        mArtist = artist;
        mThumbnail = thumbnail;
    }

    public int getId() {
        return mId;
    }

    public int getAlbumId() {
        return mAlbumId;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getArtist() {
        return mArtist;
    }

    public int getThumbnail() {
        return mThumbnail;
    }
}
