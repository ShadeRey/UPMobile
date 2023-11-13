package com.example.up.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.up.R;
import com.example.up.database.entities.artists;
import com.example.up.database.Database;
import com.example.up.database.viewmodels.artistsViewModel;
import com.example.up.databinding.FragmentArtistBinding;

import java.util.ArrayList;
import java.util.List;

public class ArtistFragment extends Fragment {

    FragmentArtistBinding binding;
    artistsViewModel viewModel;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState){
        viewModel = new ViewModelProvider(this).get(artistsViewModel.class);
        binding = FragmentArtistBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        showArtistsList();
        addBtnInit();
        deleteArtist();
    }

    private void showArtistsList(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Database db = Database.getDatabase(getContext());
                List<artists> artistsList = db.artistDao().getAllArtists();
                List<String> artistsListString = new ArrayList<>();
                for (artists item: artistsList
                ) {
                    artistsListString.add(item.artist_first_name+" "+item.artist_last_name);
                }
                ArrayAdapter<String> adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, artistsListString);
                binding.artistsView.setAdapter(adapter);
            }
        });
        thread.start();
    }

    private void addBtnInit(){
        binding.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.main_fragment, new ArtistAddFragment(), "artistAdd")
                        .addToBackStack("artistAdd")
                        .commit();
            }
        });
    }

    private void deleteArtist(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                binding.artistsView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                        viewModel.deleteArtist((artists)adapterView.getSelectedItem());
                        return false;
                    }
                });
                thread.
            }
        })
    }
}
