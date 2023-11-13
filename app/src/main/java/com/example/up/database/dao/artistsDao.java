package com.example.up.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.up.database.entities.artists;
import com.example.up.database.entities.songs;

import java.util.List;

@Dao
public interface artistsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(artists artist);
    @Update
    void update(artists artist);
    @Delete
    void delete(artists artist);

    @Query("SELECT * FROM artists")
    List<artists> getAllArtists();
}
