package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardView allAlbumsCv = findViewById(R.id.all_albums_cv);
        allAlbumsCv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDestination(AlbumsActivity.class);
            }
        });

        CardView allSongsCv = findViewById(R.id.all_songs_cv);
        allSongsCv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDestination(SongsActivity.class);
            }
        });
    }

    private void setDestination(Class destination) {
        Intent destinationIntent = new Intent(this, destination);
        startActivity(destinationIntent);
    }
}
