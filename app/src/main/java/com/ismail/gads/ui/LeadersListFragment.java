package com.ismail.gads.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ismail.gads.GADsProject;
import com.ismail.gads.RecordListAdapter;
import com.ismail.gads.databinding.FragmentLeadersListBinding;

import org.jetbrains.annotations.NotNull;


public class LeadersListFragment extends Fragment {

    private GADsProject gaDsProject;
    private Activity mActivity;
    private FragmentLeadersListBinding fragmentLeadersListBinding;

    protected LeadersListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param topic hours or skill iq.
     * @return A new instance of fragment LeadersListFragment.
     */
    //
    public static LeadersListFragment newInstance(String topic) {
        LeadersListFragment fragment = new LeadersListFragment();
        Bundle args = new Bundle();
        args.putString("topic",topic);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentLeadersListBinding = FragmentLeadersListBinding.inflate(inflater,container,false);
        fragmentLeadersListBinding.setGadsProject(gaDsProject);

        fragmentLeadersListBinding.swipeToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                gaDsProject.loadLeadersList(getArguments().getString("topic"));
            }
        });

        return fragmentLeadersListBinding.getRoot();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mActivity = (Activity) context;
        gaDsProject = new ViewModelProvider((ViewModelStoreOwner) mActivity).get(GADsProject.class);
    }

    @Override
    public void onResume() {
        super.onResume();
        //set gads project to view
        gaDsProject.loadLeadersList(getArguments().getString("topic"));
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
}