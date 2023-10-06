package uk.ac.aston.viewmodelsstarter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import uk.ac.aston.viewmodelsstarter.databinding.FragmentModuledetailsBinding;

public class ModuleDetailsFragment extends Fragment {

	private FragmentModuledetailsBinding binding;

	@Override
	public View onCreateView(
			LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState
	) {

		binding = FragmentModuledetailsBinding.inflate(inflater, container, false);
		return binding.getRoot();

	}

	public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				NavHostFragment.findNavController(ModuleDetailsFragment.this)
						.navigate(R.id.action_SecondFragment_to_FirstFragment);
			}
		});
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		binding = null;
	}

}