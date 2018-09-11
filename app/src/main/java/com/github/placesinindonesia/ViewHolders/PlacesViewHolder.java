package com.github.placesinindonesia.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.placesinindonesia.R;

/**
 * Created by Kei Lazu on 9/11/2018
 * check https://github.com/KeiLazu for more
 */
public class PlacesViewHolder extends RecyclerView.ViewHolder {

    public ImageView imgPlaces;
    public TextView tvTitles;

    public PlacesViewHolder(View v) {
        super(v);

        imgPlaces = v.findViewById(R.id.list_item_lv_iv_images);
        tvTitles = v.findViewById(R.id.list_item_lv_tv_title);

    }
}
