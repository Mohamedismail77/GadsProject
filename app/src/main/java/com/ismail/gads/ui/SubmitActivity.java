package com.ismail.gads.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.Menu;

import com.ismail.gads.GADsProject;
import com.ismail.gads.R;
import com.ismail.gads.custom.SplashBackgroundDrawable;
import com.ismail.gads.databinding.ActivitySubmitBinding;

public class SubmitActivity extends AppCompatActivity {
    private static final String TAG = "SubmitActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySubmitBinding activitySubmitBinding = DataBindingUtil.setContentView(this,R.layout.activity_submit);//ActivitySubmitBinding.inflate(getLayoutInflater());

        setSupportActionBar(activitySubmitBinding.toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        activitySubmitBinding.getRoot().setBackground(new SplashBackgroundDrawable());

        GADsProject GADsProject = new ViewModelProvider(this).get(GADsProject.class);
        getLifecycle().addObserver(GADsProject);

    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

}