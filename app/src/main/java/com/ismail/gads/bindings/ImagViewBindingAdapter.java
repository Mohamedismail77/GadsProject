package com.ismail.gads.bindings;

import android.net.Uri;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class ImagViewBindingAdapter {

    @BindingAdapter("image_url")
    public static void setImageUrl(ImageView view, String url) {
        Glide.with(view.getContext()).load(Uri.parse(url)).into(view);
    }

}

