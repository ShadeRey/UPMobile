package com.example.up.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.up.database.entities.albums;

import java.util.List;

@Dao
public interface albumsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(albums album);
    @Update
    void update(albums album);
    @Delete
    void delete(albums album);

    @Query("SELECT * FROM albums")
    List<albums> getAllAlbums();
}
