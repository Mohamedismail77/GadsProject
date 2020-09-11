package com.ismail.gads.bindings;

import android.net.Uri;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.bumptech.glide.Glide;

public class EditTextBinding {

    @BindingAdapter("source")
    public static void setImageUrl(EditText view, MutableLiveData<String> source) {

        view.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                source.setValue(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

}
