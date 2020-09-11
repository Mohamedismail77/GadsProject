package com.ismail.gads.ui;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import com.ismail.gads.GADsProject;
import com.ismail.gads.R;
import com.ismail.gads.databinding.SurePopUpBinding;

public class SubmitPopup extends DialogFragment implements View.OnClickListener {

    private Activity mActivity;
    private Window mWindow;
    private com.ismail.gads.GADsProject GADsProject;
    private SurePopUpBinding surePopUpBinding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_FRAME, R.style.FullScreenDialogStyle);
        mActivity = getActivity();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mWindow = getDialog().getWindow();
    }

    @Override
    public void onStart() {
        super.onStart();

        int width = ViewGroup.LayoutParams.MATCH_PARENT;
        int height = ViewGroup.LayoutParams.MATCH_PARENT;
        mWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mWindow.setLayout(width, height);
        setCancelable(true);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        surePopUpBinding = SurePopUpBinding.inflate(inflater,container,false);

        surePopUpBinding.dismissBtn.setOnClickListener(this);

        surePopUpBinding.submitBtn.setOnClickListener(this);

        return surePopUpBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        GADsProject = new ViewModelProvider((ViewModelStoreOwner) mActivity).get(GADsProject.class);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.submitBtn) {
            GADsProject.submit();
        }
        dismiss();
    }
}
