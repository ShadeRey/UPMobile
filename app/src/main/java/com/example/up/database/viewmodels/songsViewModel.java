package com.example.up.database.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.up.database.Database;
import com.example.up.database.entities.songs;

import java.util.List;

public class songsViewModel extends AndroidViewModel {
    private Database database;
    public List<songs> songs;
    public songsViewModel(@NonNull Application application){
        super(application);
        database = Database.getDatabase(getApplication());
    }

    public void getAllSongs(){
        Runnable allSongsRnb = ()->{
            songs = database.songDao().getAllSongs();
        };

        Thread thread = new Thread(allSongsRnb);
        thread.start();
    }

    public void getSongsByYear(int year){
        Runnable songsByYear = ()->{
            songs = database.songDao().getAllSongsByYear(year);
        };
        Thread thread = new Thread(songsByYear);
        thread.start();
    }

    public void addSongs(songs songs){
        Runnable addSongsRnb = ()->{
            database.songDao().insert(songs);
        };
        Thread thread = new Thread(addSongsRnb);
        thread.start();
    }
}
