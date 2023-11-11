package com.example.up.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.up.database.entities.song_genre;

import java.util.List;

@Dao
public interface song_genreDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(song_genre songGenre);
    @Update
    void update(song_genre songGenre);
    @Delete
    void delete(song_genre songGenre);

    @Query("SELECT * FROM song_genre")
    List<song_genre> getAllSongGenre();
}
