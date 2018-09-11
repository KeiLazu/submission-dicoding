package com.github.placesinindonesia.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.placesinindonesia.R;
import com.github.placesinindonesia.data.Places;
import com.github.placesinindonesia.data.PlacesData;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    View v;
    Context context;

    private final static String KEY_POS = "POSITION";

    ImageView imgPlace;
    TextView tvPlaceName, tvPlaceCountry, tvPlaceDesc;

    private ArrayList<Places> placesList;
    Places places;

    public DetailFragment() {
        // Required empty public constructor
    }

    public static DetailFragment newInstance(int position) {
        DetailFragment fragment = new DetailFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_POS, position);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_detail, container, false);
        context = v.getContext();

        InitWidgets();
        GetData();

        return v;
    }

    private void InitWidgets() {
        imgPlace = v.findViewById(R.id.detail_img_place);

        tvPlaceName = v.findViewById(R.id.detail_tv_title);
        tvPlaceCountry = v.findViewById(R.id.detail_tv_country_output);
        tvPlaceDesc = v.findViewById(R.id.detail_tv_desc_output);
    }

    private void GetData() {
        if (getArguments() != null) {
            placesList = PlacesData.getListData();
            places = placesList.get(getArguments().getInt(KEY_POS, 0));

            InvokeData();
        }
    }

    private void InvokeData() {
        Picasso.get().load(places.getImage())
                .fit().centerCrop()
                .into(imgPlace);

        tvPlaceName.setText(places.getPlacesName());
        tvPlaceCountry.setText(places.getCountry());
        tvPlaceDesc.setText(places.getPlacesDesc());
    }

}
