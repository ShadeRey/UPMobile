package com.example.up.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "genres")
public class genres {
    @PrimaryKey
    private long genres_id;
    @ColumnInfo
    private String genre_name;
    public genres(){}
}

