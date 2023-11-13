package com.example.up.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.up.R;
import com.example.up.database.Database;
import com.example.up.database.entities.artists;
import com.example.up.database.viewmodels.artistsViewModel;
import com.example.up.databinding.FragmentArtistAddBinding;
import com.example.up.databinding.FragmentArtistBinding;

public class ArtistAddFragment extends Fragment {
    FragmentArtistAddBinding binding;
    artistsViewModel viewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(artistsViewModel.class);
        binding = FragmentArtistAddBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.addArtistSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        artists item = new artists();
                        item.artist_first_name = binding.addArtistFirstName.getText().toString();
                        item.artist_last_name = binding.addArtistLastName.getText().toString();
                        viewModel.addArtist(item);
                    }
                });
                getActivity().getSupportFragmentManager().popBackStack();
                thread.start();
            }
        });
    }
}