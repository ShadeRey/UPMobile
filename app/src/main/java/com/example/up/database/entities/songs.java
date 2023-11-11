package com.example.up.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "songs")
public class songs {
    @PrimaryKey
    public long song_id;
    @ColumnInfo(name = "song_name")
    public String song_name;
    @ColumnInfo(name = "song_publishing_year")
    public int song_publishing_year;
    public songs(){}

    public String getName() {
        return this.song_name;
    }
}
