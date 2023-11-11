package com.example.up.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "albums")
public class albums {
    @PrimaryKey
    public long album_id;
    @ColumnInfo
    public String album_name;
    @ColumnInfo
    public int album_publishing_year;
    public albums(){}
}
