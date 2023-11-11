package com.example.up.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.up.database.entities.artist_song;

import java.util.List;

@Dao
public interface artist_songDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(artist_song artistSong);
    @Update
    void update(artist_song artistSong);
    @Delete
    void delete(artist_song artistSong);

    @Query("SELECT * FROM artist_song")
    List<artist_song> getAllArtistSong();
}
