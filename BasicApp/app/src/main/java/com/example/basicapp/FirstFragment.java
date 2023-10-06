package com.example.basicapp;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.basicapp.databinding.FragmentAlertBinding;
import com.example.basicapp.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(MainActivity.TAG + this.getClass().getName(),
                "onCreate");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(MainActivity.TAG + this.getClass().getName(),
                "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(MainActivity.TAG + this.getClass().getName(),
                "onResume");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(MainActivity.TAG + this.getClass().getName(),
                "onStop");
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.i(MainActivity.TAG + this.getClass().getName(),
                "onAttach");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(MainActivity.TAG + this.getClass().getName(),
                "onDetach");
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
    Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        Log.i(MainActivity.TAG + this.getClass().getName(), "onCreateView");
        return binding.getRoot();



    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i(MainActivity.TAG + this.getClass().getName(), "onViewCreated");
        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);

            }
        });
        binding.alertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(MainActivity.TAG, "Alert Button Clicked");
                // displayToast("Alert Warning!");
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_alertFragment);
            }
        });
    }

    public void displayToast(String message) {
        Toast.makeText(getContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(MainActivity.TAG + this.getClass().getName(),
                "onDestroy");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}