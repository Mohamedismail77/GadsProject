package com.ismail.gads.ui;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.ismail.gads.LeaderBoardCategoryAdapter;
import com.ismail.gads.R;
import com.ismail.gads.databinding.FragmentLeaderBoardBinding;

import org.jetbrains.annotations.NotNull;


public class LeaderBoardFragment extends Fragment {

    private AppCompatActivity mActivity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        com.ismail.gads.databinding.FragmentLeaderBoardBinding fragmentLeaderBoardBinding = FragmentLeaderBoardBinding.inflate(inflater, container, false);
        TabLayout tabLayout  = fragmentLeaderBoardBinding.tabLayout;
        ViewPager2 pager = fragmentLeaderBoardBinding.pager;

        LeaderBoardCategoryAdapter leaderBoardCategoryAdapter = new LeaderBoardCategoryAdapter(this);
        pager.setAdapter(leaderBoardCategoryAdapter);

        new TabLayoutMediator(tabLayout, pager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0:
                        tab.setText(getResources().getText(R.string.learning_leaders));
                        break;
                    case 1:
                        tab.setText(getResources().getText(R.string.skill_iq_leaders));
                        break;
                }
            }
        }).attach();

        fragmentLeaderBoardBinding.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment navHostFragment = (NavHostFragment) mActivity.getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
                if (navHostFragment != null){
                    NavController navController = navHostFragment.getNavController();
                    navController.navigate(R.id.action_leaderBoardFragment_to_submitActivity);
                }
            }
        });

        return fragmentLeaderBoardBinding.getRoot();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mActivity = (AppCompatActivity) context;
    }
}