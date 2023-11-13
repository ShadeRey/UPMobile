package com.example.up.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.up.database.entities.songs;

import java.util.List;

@Dao
public interface songsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(songs song);
    @Update
    void update(songs song);
    @Delete
    void delete(songs song);

    @Query("SELECT * FROM songs")
    List<songs> getAllSongs();

    @Query("SELECT * FROM songs WHERE song_publishing_year = :year")
    List<songs> getAllSongsByYear(int year);
}
