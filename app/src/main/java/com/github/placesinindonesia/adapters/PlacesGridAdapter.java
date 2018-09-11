package com.github.placesinindonesia.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.placesinindonesia.R;
import com.github.placesinindonesia.ViewHolders.PlacesViewHolder;
import com.github.placesinindonesia.data.Places;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Kei Lazu on 9/11/2018
 * check https://github.com/KeiLazu for more
 */
public class PlacesGridAdapter extends RecyclerView.Adapter<PlacesViewHolder> {

    Context context;
    ArrayList<Places> listPlacesData;

    public ArrayList<Places> getListPlacesData() {
        return listPlacesData;
    }

    public void setListPlacesData(ArrayList<Places> listPlacesData) {
        this.listPlacesData = listPlacesData;
    }

    public PlacesGridAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public PlacesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_item_places_listview, parent, false);
        PlacesViewHolder vh = new PlacesViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull PlacesViewHolder holder, int position) {
        Places places = getListPlacesData().get(position);

//        RequestOptions ro = new RequestOptions()
//                .centerCrop()
//                .priority(Priority.HIGH);
//
//        Glide.with(context)
//                .load(places.getImage())
//                .apply(ro)
//                .into(holder.imgPlaces);

        Picasso.get().load(places.getImage()).centerInside().fit()
                .into(holder.imgPlaces);

        holder.tvTitles.setText(places.getPlacesName());
    }

    @Override
    public int getItemCount() {
        return getListPlacesData().size();
    }
}
