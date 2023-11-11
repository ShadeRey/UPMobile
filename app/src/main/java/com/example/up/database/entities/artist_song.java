package com.example.up.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "artist_song",
foreignKeys = {@ForeignKey(entity =
artists.class,
parentColumns = "artist_id",
childColumns = "artist_id"),
        @ForeignKey(entity = songs.class,
                parentColumns = "song_id",
                childColumns = "song_id"),
},
indices = {@Index(value = {"artist_id"}), @Index(value = {"song_id"})})
public class artist_song {
    @PrimaryKey
    public long artist_song_id;
    @ColumnInfo(name = "artist_id")
    public long artist_id;
    @ColumnInfo(name="song_id")
    public long song_id;
    public artist_song(){}
}
