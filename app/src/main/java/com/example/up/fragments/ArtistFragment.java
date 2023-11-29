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
import android.widget.EditText;
import android.widget.Toast;

import com.example.up.R;
import com.example.up.adapters.artistAdapter;
import com.example.up.database.entities.artists;
import com.example.up.database.Database;
import com.example.up.database.viewmodels.artistsViewModel;
import com.example.up.databinding.FragmentArtistBinding;

import java.util.ArrayList;
import java.util.List;

public class ArtistFragment extends Fragment {

    FragmentArtistBinding binding;
    artistsViewModel viewModel;
    artistAdapter artistAdapt;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(requireActivity()).get(artistsViewModel.class);
        binding = FragmentArtistBinding.inflate(inflater, container, false);

        viewModel.artistsLiveData.observe(getViewLifecycleOwner(), artists -> {
            artistAdapt = new artistAdapter(getContext(), R.layout.artist_item, artists);
            binding.artistsView.setAdapter(artistAdapt);
            //artistAdapt.notifyDataSetChanged();
            if (artists.size() != 0) {
                binding.prgsBar.setVisibility(View.GONE);
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        addBtnInit();
        deleteArtist();
        updateArtist();
    }


    private void addBtnInit() {
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

    private void deleteArtist() {

        binding.artistsView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        artists artists = artistAdapt.getItem(i);
                        viewModel.deleteArtist(artists);
                        removeArtistOnMainThread(artists);
                    }
                });
                thread.start();
                return false;
            }
        });
    }

    private void removeArtistOnMainThread(artists artist) {
        requireActivity().runOnUiThread(() -> {
            artistAdapt.remove(artist);
        });
    }

    private void updateArtist() {
        binding.artistsView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.main_fragment, new ArtistAddFragment(true, artistAdapt.getItem(i)), "artistAdd")
                        .addToBackStack("artistAdd")
                        .commit();
            }
        });
    }
}
