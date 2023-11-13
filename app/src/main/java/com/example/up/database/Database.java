package com.example.up.database;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.up.database.dao.albumsDao;
import com.example.up.database.dao.artist_songDao;
import com.example.up.database.dao.artistsDao;
import com.example.up.database.dao.genresDao;
import com.example.up.database.dao.song_albumDao;
import com.example.up.database.dao.song_genreDao;
import com.example.up.database.dao.songsDao;
import com.example.up.database.entities.albums;
import com.example.up.database.entities.artist_song;
import com.example.up.database.entities.artists;
import com.example.up.database.entities.genres;
import com.example.up.database.entities.song_album;
import com.example.up.database.entities.song_genre;
import com.example.up.database.entities.songs;

@androidx.room.Database(entities = {albums.class, artists.class, songs.class, genres.class, artist_song.class, song_album.class, song_genre.class}, version = 2)
public abstract class Database extends RoomDatabase {
    public abstract albumsDao albumDao();
    public abstract artistsDao artistDao();
    public abstract songsDao songDao();
    public abstract genresDao genreDao();
    public abstract artist_songDao artist_songDao();
    public abstract song_albumDao song_albumDao();
    public abstract song_genreDao song_genreDao();

    public static volatile Database INSTANCE;
    public static Database getDatabase(Context context){
        if (INSTANCE == null){
            synchronized (Database.class){
                if (INSTANCE ==null){
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            Database.class,
                            "test_database").build();
                }
            }
        }
        return INSTANCE;
    }
}
