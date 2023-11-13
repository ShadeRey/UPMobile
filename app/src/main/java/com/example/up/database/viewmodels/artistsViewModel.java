package com.example.up.database.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.up.database.Database;
import com.example.up.database.entities.artists;

import java.util.List;

public class artistsViewModel extends AndroidViewModel {
    private Database database;
    public List<artists> artists;
    public artistsViewModel(@NonNull Application application){
        super(application);
        database = Database.getDatabase(getApplication());
    }

    public void addArtist(artists item){
        Runnable addArtistsRnb = ()->{
            database.artistDao().insert(item);
        };
        Thread thread = new Thread(addArtistsRnb);
        thread.start();
    }

    public void deleteArtist(artists item){
        Runnable deleteArtistRnb = ()->{
            database.artistDao().delete(item);
        };
        Thread thread = new Thread(deleteArtistRnb);
        thread.start();
    }

    public void updateArtist(artists item){
        Runnable updateArtistRnb = ()->{
            database.artistDao().update(item);
        };
        Thread thread = new Thread(updateArtistRnb);
        thread.start();
    }
}
