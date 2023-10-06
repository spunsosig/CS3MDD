package uk.ac.aston.navigation1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import uk.ac.aston.navigation1.databinding.FragmentAlertBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AlertFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AlertFragment extends Fragment {
    private FragmentAlertBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        Log.i(MainActivity.TAG + this.getClass().getName(),
                "onCreateView");

        binding = FragmentAlertBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}