package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.android.musicalstructureapp.Adapters.AlbumAdapter;
import com.example.android.musicalstructureapp.Models.Album;
import com.example.android.musicalstructureapp.Utils.Generator;

import java.util.ArrayList;

public class AlbumsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albums);

        ArrayList<Album> albums = Generator.getAllAlbums();

        GridView albumsGv = findViewById(R.id.albums_gv);
        AlbumAdapter albumAdapter = new AlbumAdapter(this, albums);
        albumsGv.setAdapter(albumAdapter);

        albumsGv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(AlbumsActivity.this, SongsActivity.class);
                Album selectedAlbum = (Album) parent.getItemAtPosition(position);
                intent.putExtra("ALBUM_ID", selectedAlbum.getId());
                startActivity(intent);
            }
        });
    }
}
