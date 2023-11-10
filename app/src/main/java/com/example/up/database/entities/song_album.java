package com.example.up.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "song_album",
foreignKeys = {@ForeignKey(entity =
        songs.class,
parentColumns = "song_id",
childColumns = "song_id"),
@ForeignKey(entity = albums.class,
parentColumns = "album_id",
childColumns = "album_id")},
indices = {@Index(value = {"song_id"}), @Index(value = "album_id")})
public class song_album {
    @PrimaryKey
    private long song_album_id;
    @ColumnInfo(name = "song_id")
    private long song_id;
    @ColumnInfo(name = "album_id")
    private long album_id;
    public song_album(){}
}
