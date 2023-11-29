package com.example.up.database.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.up.R;
import com.example.up.adapters.artistAdapter;
import com.example.up.database.Database;
import com.example.up.database.entities.artists;

import java.util.ArrayList;
import java.util.List;

public class artistsViewModel extends AndroidViewModel {
    public Database database;
    private List<artists> artistsList = new ArrayList<>();
    public MutableLiveData<List<artists>> artistsLiveData = new MutableLiveData<>(artistsList);

    public artistsViewModel(@NonNull Application application) {
        super(application);
        database = Database.getDatabase(getApplication());
        showArtistsList();
    }

    public MutableLiveData<List<artists>> getArtistsLiveData() {
        return artistsLiveData;
    }

    private void showArtistsList() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Database db = Database.getDatabase(getApplication().getApplicationContext());
                List<artists> artistsList = db.artistDao().getAllArtists();
                artistsLiveData.postValue(artistsList);
            }
        });
        thread.start();
    }

    public void addArtist(artists artist) {
        artistsList.add(artist);
        artistsLiveData.postValue(artistsList);

        Runnable updateArtistRnb = () -> {
            database.artistDao().insert(artist);
        };
        Thread thread = new Thread(updateArtistRnb);
        thread.start();
    }

    public void deleteArtist(artists artist) {
        artistsList.remove(artist);
        artistsLiveData.postValue(artistsList);
        Runnable updateArtistRnb = () -> {
            database.artistDao().delete(artist);
        };
        Thread thread = new Thread(updateArtistRnb);
        thread.start();
    }

   /* public void addArtist(artists item){
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
    */

    public void updateArtist(artists prev, artists newItem) {

        List<artists> livedata = artistsLiveData.getValue();
        livedata.remove(prev);
        livedata.add(newItem);
        artistsLiveData.postValue(livedata);
        Runnable updateArtistRnb = () -> {
            database.artistDao().update(newItem);
        };
        Thread thread = new Thread(updateArtistRnb);
        thread.start();
    }

}
