package com.example.up.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "albums")
public class albums {
    @PrimaryKey
    private long album_id;
    @ColumnInfo
    private String album_name;
    @ColumnInfo
    private int album_publishing_year;
    public albums(){}
}
