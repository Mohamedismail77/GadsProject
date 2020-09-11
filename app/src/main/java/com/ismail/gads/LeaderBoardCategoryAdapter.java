package com.ismail.gads;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.ismail.gads.ui.LeadersListFragment;

public class LeaderBoardCategoryAdapter extends FragmentStateAdapter {


    public LeaderBoardCategoryAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return LeadersListFragment.newInstance("hours");
            case 1:
                return LeadersListFragment.newInstance("skilliq");
            default:
                return LeadersListFragment.newInstance("hours");
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
