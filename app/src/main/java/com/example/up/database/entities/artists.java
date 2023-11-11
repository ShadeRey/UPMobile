package com.example.up.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "artists")
public class artists {
    @PrimaryKey
    public long artist_id;
    @ColumnInfo
    public String artist_first_name;
    @ColumnInfo
    public String artist_last_name;
    public artists(){}
}
