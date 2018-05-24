package com.example.android.musicalstructureapp.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.musicalstructureapp.Models.Song;
import com.example.android.musicalstructureapp.R;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> {
    public SongAdapter(Context context, ArrayList<Song> songs) {
        super(context, 0, songs);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View currentView = convertView;
        Song currentSong = getItem(position);

        if (currentView == null)
            currentView = LayoutInflater.from(getContext()).inflate(R.layout.song_item, parent, false);

        TextView titleTv = currentView.findViewById(R.id.title);
        titleTv.setText(currentSong.getTitle());

        TextView artistTv = currentView.findViewById(R.id.artist);
        artistTv.setText(currentSong.getArtist());

        ImageView thumbnail = currentView.findViewById(R.id.thumbnail);
        thumbnail.setImageResource(currentSong.getThumbnail());

        return currentView;
    }
}
