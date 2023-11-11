package com.example.up.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity (tableName = "song_genre",
foreignKeys = {@ForeignKey(entity =
songs.class,
parentColumns = "song_id",
childColumns = "song_id"),
@ForeignKey(entity = genres.class,
parentColumns = "genre_id",
childColumns = "genre_id")},
indices = {@Index(value = {"song_id"}), @Index(value = "genre_id")})
public class song_genre {
    @PrimaryKey
    public long song_genre_id;
    @ColumnInfo(name = "song_id")
    public long song_id;
    @ColumnInfo(name = "genre_id")
    public long genre_id;
    public song_genre(){}
}
