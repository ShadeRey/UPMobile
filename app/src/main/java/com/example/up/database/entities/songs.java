package com.example.up.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "songs")
public class songs {
    @PrimaryKey
    private long song_id;
    @ColumnInfo(name = "song_name")
    private String song_name;
    @ColumnInfo(name = "song_publishing_year")
    private int song_publishing_year;
    public songs(){}
}
