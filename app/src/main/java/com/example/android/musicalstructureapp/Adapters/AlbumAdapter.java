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

import com.example.android.musicalstructureapp.Models.Album;
import com.example.android.musicalstructureapp.R;
import com.example.android.musicalstructureapp.Utils.Generator;

import java.util.ArrayList;

public class AlbumAdapter extends ArrayAdapter<Album> {
    public AlbumAdapter(Context context, ArrayList<Album> albums) {
        super(context, 0, albums);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View currentView = convertView;
        Album currentAlbum = getItem(position);

        if (currentView == null)
            currentView = LayoutInflater.from(getContext()).inflate(R.layout.album_item, parent, false);

        TextView titleTv = currentView.findViewById(R.id.album_title);
        titleTv.setText(currentAlbum.getTitle());

        TextView albumSongsNbTv = currentView.findViewById(R.id.album_songs_nb);
        int songsNbByAlbum = Generator.getNbOfSongsByAlbum(currentAlbum.getId());
        albumSongsNbTv.setText(parent.getResources().getString(R.string.songs_by_album, songsNbByAlbum));

        ImageView thumbnail = currentView.findViewById(R.id.album_poster_thumbnail);
        thumbnail.setImageResource(currentAlbum.getPosterThumbnail());
        // set contentDescription accessibility attribute to the album title too
        thumbnail.setContentDescription(currentAlbum.getTitle());

        return currentView;
    }
}
