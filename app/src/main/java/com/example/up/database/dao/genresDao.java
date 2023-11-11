package com.example.up.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.up.database.entities.genres;

import java.util.List;

@Dao
public interface genresDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(genres genre);
    @Update
    void update(genres genre);
    @Delete
    void delete(genres genre);

    @Query("SELECT * FROM genres")
    List<genres> getAllGenres();
}
