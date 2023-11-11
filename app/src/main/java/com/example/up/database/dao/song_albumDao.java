package com.example.up.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.up.database.entities.song_album;

import java.util.List;

@Dao
public interface song_albumDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(song_album songAlbum);
    @Update
    void update(song_album songAlbum);
    @Delete
    void delete(song_album songAlbum);

    @Query("SELECT * FROM song_album")
    List<song_album> getAllSongAlbum();
}
