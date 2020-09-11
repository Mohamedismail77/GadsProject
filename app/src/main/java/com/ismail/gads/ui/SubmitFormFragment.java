package com.ismail.gads.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ismail.gads.GADsProject;
import com.ismail.gads.R;
import com.ismail.gads.databinding.FragmentSubmitFormBinding;


public class SubmitFormFragment extends Fragment{

    private FragmentSubmitFormBinding fragmentSubmitFormBinding;
    private com.ismail.gads.GADsProject GADsProject;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentSubmitFormBinding = FragmentSubmitFormBinding.inflate(inflater, container, false);

        fragmentSubmitFormBinding.submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateTo(R.id.action_submitFormFragment_to_submitPopup);
            }
        });

        return fragmentSubmitFormBinding.getRoot();
    }


    @Override
    public void onResume() {
        super.onResume();
        GADsProject.getStates().observe(getViewLifecycleOwner(), new Observer<GADsProject.States>() {
            @Override
            public void onChanged(GADsProject.States states) {
                switch (states) {
                    case CHECK:
                        navigateTo(R.id.action_submitFormFragment_to_submitPopup);
                        break;
                    case ERROR:
                        navigateTo(R.id.action_submitFormFragment_to_errorPopup);
                        break;
                    case SUCCESS:
                        navigateTo(R.id.action_submitFormFragment_to_sucessPopup);
                        break;
                }
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        GADsProject = new ViewModelProvider(getActivity()).get(GADsProject.class);
        getLifecycle().addObserver(GADsProject);
        fragmentSubmitFormBinding.setSubmitController(GADsProject);
    }

    private void navigateTo(int path) {
        NavHostFragment navHostFragment = (NavHostFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        NavController navController = navHostFragment.getNavController();
        navController.navigate(path);
    }

}