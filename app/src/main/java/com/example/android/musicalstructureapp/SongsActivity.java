package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.android.musicalstructureapp.Adapters.SongAdapter;
import com.example.android.musicalstructureapp.Models.Song;
import com.example.android.musicalstructureapp.Utils.Generator;

import java.util.ArrayList;

public class SongsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs);

        Intent intent = getIntent();
        /*
         * if this activity wasn't opened by selecting an album, there will be no ALBUM_ID extra
         * and for that pass -1 as default value for getSongsByAlbum to return all songs
         */
        ArrayList<Song> songs = Generator.getSongsByAlbum(intent.getIntExtra("ALBUM_ID", -1));

        SongAdapter songAdapter = new SongAdapter(this, songs);
        ListView songsLV = findViewById(R.id.songs_list);
        songsLV.setAdapter(songAdapter);

        songsLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Song selectedSong = (Song) parent.getItemAtPosition(position);
                Intent intent = new Intent(SongsActivity.this, SongDetailActivity.class);
                intent.putExtra("SONG_ID", selectedSong.getId());
                startActivity(intent);
            }
        });
    }

    /**
     * SongsActivity can be accessed in 2 ways:
     * 1- from home screen to display all songs
     * 2- from albums screen to display songs belonging to a specific album
     * that's why a the value of the default parentActivity is set to MainActivity
     * in the manifest file because setting parentActivity programmatically needs
     * a default parentActivity in the manifest file
     * workaround learnt from here: https://stackoverflow.com/a/28334824
     */
    private Intent getParentActivityIntentDynamically() {
        Intent parentIntent = null;
        // the activity that started SongsActivity
        Intent firingIntent = getIntent();
        // ALBUM_ID will be -1 if MainActivity started SongsActivity
        if (firingIntent.getIntExtra("ALBUM_ID", -1) == -1)
            parentIntent = new Intent(this, MainActivity.class);
        else
            // ALBUM_ID will be different of -1 if AlbumsActivity started SongsActivity
            parentIntent = new Intent(this, AlbumsActivity.class);

        return parentIntent;
    }

    /**
     * Must be overriden to setup parentActivity dynamically
     */
    @Override
    public Intent getSupportParentActivityIntent() {
        return getParentActivityIntentDynamically();
    }

    /**
     * Must be overriden to setup parentActivity dynamically
     */
    @Override
    public Intent getParentActivityIntent() {
        return getParentActivityIntentDynamically();
    }
}
