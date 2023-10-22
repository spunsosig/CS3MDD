package com.example.whereami;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.whereami.databinding.FragmentFirstBinding;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import uk.ac.aston.cs3mdd.whereami.model.LocationViewModel;

public class FirstFragment extends Fragment {

    private LocationViewModel model;

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                NavHostFragment.findNavController(FirstFragment.this)
//                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
//            }
//        });

        model = new ViewModelProvider(requireActivity()).get(LocationViewModel.class);
        binding.latitude.setText("Not Set");
        binding.longitude.setText("Not Set");
        binding.timestamp.setText("No timestamp");
        model.getCurrentLocation().observe(getViewLifecycleOwner(), loc -> {
            if (loc != null) {
                // Update the UI.
                binding.latitude.setText("" + loc.getLatitude());
                binding.longitude.setText("" + loc.getLongitude());
                Date date = Calendar.getInstance().getTime();
                date.setTime(loc.getTime());
                DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
                String strDate = dateFormat.format(date);
                binding.timestamp.setText(strDate);
            }
        });

        binding.updatesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.setLocationUpdates(!model.getLocationUpdates().getValue());
                if (model.getLocationUpdates().getValue()) {
                    binding.updatesButton.setText("Stop Location Updates");
                    Log.i(MainActivity.TAG, "Location Updates Started");
                } else {
                    binding.updatesButton.setText("Start Location Updates");
                    Log.i(MainActivity.TAG, "Location Updates Stopped");
                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}