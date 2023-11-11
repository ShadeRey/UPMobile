package com.example.up.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.up.R;
import com.example.up.database.entities.songs;
import com.example.up.database.viewmodels.songsViewModel;

import java.util.List;
import java.util.stream.Collectors;

public class SongsFragment extends Fragment {
    songsViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@Nullable LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState){
        viewModel = new ViewModelProvider(this).get(songsViewModel.class);
        return inflater.inflate(R.layout.fragment_songs, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        showSongsCount();
        view.findViewById(R.id.show_btn).setOnClickListener((v)->{
            if(viewModel.songs == null) return;
            List<String> songsNames =
                    viewModel.songs.stream()
                            .map(songs::getName)
                            .collect(Collectors.toList());

            ArrayAdapter<String> adapter = new ArrayAdapter<>(
                    getContext(),
                    android.R.layout.simple_list_item_1,
                    songsNames);

            ListView listView = view.findViewById(R.id.list);
            listView.setAdapter(adapter);
        });
    }

    private void showSongsCount(){
        viewModel.getAllSongs();
    }

    private void addSongsToList(){
        viewModel.addSongs(new songs());
    }
}