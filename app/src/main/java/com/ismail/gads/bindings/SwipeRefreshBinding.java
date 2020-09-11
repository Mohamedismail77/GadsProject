package com.ismail.gads.bindings;

import androidx.databinding.BindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.ismail.gads.GADsProject.States;

public class SwipeRefreshBinding {

    @BindingAdapter("isActive")
    public static void progressVisibility(SwipeRefreshLayout swipeRefreshLayout, LiveData<States> active) {
    active.observeForever(new Observer<States>() {
        @Override
        public void onChanged(States states) {
            swipeRefreshLayout.post(new Runnable() {
                @Override
                public void run() {
                    swipeRefreshLayout.setRefreshing((states == States.PROGRESS));
                }
            });
        }
    });
    }




}
