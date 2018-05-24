package com.example.android.musicalstructureapp.Utils;

import com.example.android.musicalstructureapp.Models.Album;
import com.example.android.musicalstructureapp.Models.Song;
import com.example.android.musicalstructureapp.R;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A utility class to generate both albums and songs
 * while establishing relationship between both
 * i.e: each album contains many songs
 * Relation ship is controlled only between albums and songs
 * artist names are totally random in case an album contains
 * songs from different artists
 */
public class Generator {
    /**
     * dummy array of albums
     */
    private static final Album[] albums = {
            new Album(1, "Album 1", R.drawable.album_poster1),
            new Album(2, "Album 2", R.drawable.album_poster2),
            new Album(3, "Album 3", R.drawable.album_poster4),
            new Album(4, "Album 4", R.drawable.album_poster3),
            new Album(5, "Album 5", R.drawable.album_poster4),
            new Album(6, "Album 6", R.drawable.album_poster2),
            new Album(7, "Album 7", R.drawable.album_poster1),
            new Album(8, "Album 8", R.drawable.album_poster3),
            new Album(9, "Album 9", R.drawable.album_poster2)
    };

    /**
     * dummy array of songs
     */
    private static final Song[] songs = {
            new Song(1, 2, "Song 1", "Artist 2", R.drawable.song_poster1),
            new Song(2, 7, "Song 2", "Artist 10", R.drawable.song_poster2),
            new Song(3, 4, "Song 3", "Artist 4", R.drawable.song_poster4),
            new Song(4, 4, "Song 4", "Artist 4", R.drawable.song_poster2),
            new Song(5, 1, "Song 5", "Artist 1", R.drawable.song_poster5),
            new Song(6, 2, "Song 6", "Artist 2", R.drawable.song_poster3),
            new Song(7, 4, "Song 7", "Artist 4", R.drawable.song_poster4),
            new Song(8, 3, "Song 8", "Artist 3", R.drawable.song_poster1),
            new Song(9, 9, "Song 9", "Artist 9", R.drawable.song_poster3),
            new Song(10, 5, "Song 10", "Artist 5", R.drawable.song_poster5),
            new Song(11, 4, "Song 10", "Artist 5", R.drawable.song_poster5),
            new Song(12, 4, "Song 12", "Artist 4", R.drawable.song_poster4),
            new Song(13, 5, "Song 13", "Artist 5", R.drawable.song_poster2),
            new Song(14, 2, "Song 14", "Artist 2", R.drawable.song_poster2),
            new Song(15, 8, "Song 15", "Artist 8", R.drawable.song_poster5),
            new Song(16, 9, "Song 16", "Artist 9", R.drawable.song_poster1),
            new Song(17, 7, "Song 17", "Artist 7", R.drawable.song_poster4),
            new Song(18, 7, "Song 18", "Artist 7", R.drawable.song_poster1),
            new Song(19, 7, "Song 19", "Artist 10", R.drawable.song_poster2),
            new Song(20, 6, "Song 20", "Artist 6", R.drawable.song_poster3),
            new Song(21, 8, "Song 21", "Artist 10", R.drawable.song_poster4),
            new Song(22, 3, "Song 22", "Artist 10", R.drawable.song_poster1),
            new Song(23, 6, "Song 23", "Artist 6", R.drawable.song_poster2),
            new Song(24, 6, "Song 24", "Artist 10", R.drawable.song_poster1),
            new Song(25, 8, "Song 25", "Artist 10", R.drawable.song_poster2),
            new Song(26, 1, "Song 26", "Artist 1", R.drawable.song_poster3),
            new Song(27, 9, "Song 27", "Artist 10", R.drawable.song_poster1),
            new Song(28, 1, "Song 28", "Artist 1", R.drawable.song_poster1),
            new Song(29, 1, "Song 29", "Artist 1", R.drawable.song_poster2),
            new Song(30, 3, "Song 30", "Artist 10", R.drawable.song_poster4),
    };

    /**
     * Returns an ArrayList of all albums
     */
    public static ArrayList<Album> getAllAlbums() {
        return new ArrayList<>(Arrays.asList(albums));
    }

    /**
     * Returns an ArrayList of all songs
     */
    private static ArrayList<Song> getAllSongs() {
        return new ArrayList<>(Arrays.asList(songs));
    }

    /**
     * Returns songs belonging to a specific album
     * if albumId == -1 then display all songs
     */
    public static ArrayList<Song> getSongsByAlbum(int albumId) {
        if (albumId == -1)
            return getAllSongs();

        ArrayList<Song> songsByAlbum = new ArrayList<>();
        for (Song song : songs) {
            if (song.getAlbumId() == albumId)
                songsByAlbum.add(song);
        }

        return songsByAlbum;
    }

    /**
     * returns number of songs in an album
     */
    public static int getNbOfSongsByAlbum(int albumId) {
        int total = 0;
        for (Song song : songs)
            if (song.getAlbumId() == albumId)
                total++;

        return total;
    }

    /**
     * Returns song with specific id
     */
    public static Song getSongById(int songId) {
        for (Song song : songs)
            if (song.getId() == songId)
                return song;
        // It will never be null with the dummy data but must be considered
        return null;
    }
}
