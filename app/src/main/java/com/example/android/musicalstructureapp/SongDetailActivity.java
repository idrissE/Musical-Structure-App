package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.musicalstructureapp.Models.Song;
import com.example.android.musicalstructureapp.Utils.Generator;

public class SongDetailActivity extends AppCompatActivity {
    private boolean isPlaying;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_detail);
        Intent intent = getIntent();
        int selectedSongId = intent.getIntExtra("SONG_ID", -1);
        Song selectedSong = Generator.getSongById(selectedSongId);
        setSongDetails(selectedSong);
        isPlaying = true;
        setPlayerButtons();
    }

    /**
     * setup the fields for the song player screen
     * if song is null ( which is impossible in the case of this app ),
     * display an error message
     */
    private void setSongDetails(Song song) {
        if (song == null) {
            TextView errorTv = findViewById(R.id.error_message);
            errorTv.setVisibility(View.VISIBLE);
            return;
        }
        TextView songTitleTv = findViewById(R.id.song_title);
        songTitleTv.setText(song.getTitle());
        TextView songArtistTv = findViewById(R.id.song_artist);
        songArtistTv.setText(song.getArtist());
        ImageView songThumbnail = findViewById(R.id.song_thumbnail);
        songThumbnail.setImageResource(song.getThumbnail());
    }

    /**
     * configure clicks on the music player buttons
     */
    private void setPlayerButtons() {
        ImageButton rewindBtn = findViewById(R.id.rewind_btn);
        rewindBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SongDetailActivity.this, getString(R.string.backwarding), Toast.LENGTH_SHORT).show();
            }
        });

        ImageButton forwardBtn = findViewById(R.id.forward_btn);
        forwardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SongDetailActivity.this, getString(R.string.forwarding), Toast.LENGTH_SHORT).show();
            }
        });

        ImageButton playPauseBtn = findViewById(R.id.play_pause_btn);
        playPauseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageButton playPauseBtn = findViewById(R.id.play_pause_btn);
                if (isPlaying) {
                    Toast.makeText(SongDetailActivity.this, getString(R.string.pausing), Toast.LENGTH_SHORT).show();
                    playPauseBtn.setImageResource(R.drawable.round_play_circle_filled_white_white_36);
                    isPlaying = false;
                } else {
                    Toast.makeText(SongDetailActivity.this, getString(R.string.playing), Toast.LENGTH_SHORT).show();
                    playPauseBtn.setImageResource(R.drawable.round_pause_circle_filled_white_36);
                    isPlaying = true;
                }
            }
        });
    }
}
