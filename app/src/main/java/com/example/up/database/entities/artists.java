package com.example.up.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "artists")
public class artists {
    @PrimaryKey
    private long artist_id;
    @ColumnInfo
    private String artist_first_name;
    @ColumnInfo
    private String artist_last_name;
    public artists(){}
}
