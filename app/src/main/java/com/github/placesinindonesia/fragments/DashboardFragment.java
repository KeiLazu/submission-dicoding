package com.github.placesinindonesia.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.placesinindonesia.R;
import com.github.placesinindonesia.activities.MainActivity;
import com.github.placesinindonesia.adapters.PlacesCardAdapter;
import com.github.placesinindonesia.adapters.PlacesGridAdapter;
import com.github.placesinindonesia.adapters.PlacesListAdapter;
import com.github.placesinindonesia.data.Places;
import com.github.placesinindonesia.data.PlacesData;
import com.github.placesinindonesia.utils.ItemClickSupport;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment {

    View v;
    Context context;

    RecyclerView rvPlaces;

    PlacesListAdapter placesListAdapter;
    PlacesGridAdapter placesGridAdapter;
    PlacesCardAdapter placesCardAdapter;

    LinearLayoutManager llmPlaces;
    GridLayoutManager glmPlaces;

    private ArrayList<Places> placesList;

    public DashboardFragment() {
        // Required empty public constructor
    }

    public static DashboardFragment newInstance() {
        DashboardFragment fragment = new DashboardFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_dashboard, container, false);
        context = v.getContext();

        InitData();
        InitRv();

        return v;
    }

    private void InitData() {
        placesList = PlacesData.getListData();
    }

    private void InitRv() {
        rvPlaces = v.findViewById(R.id.dashboard_rv_places);
        placesListAdapter = new PlacesListAdapter(context);
        placesCardAdapter = new PlacesCardAdapter(context);
        placesGridAdapter = new PlacesGridAdapter(context);

        UseLinearList();

        ItemClickSupport.addTo(rvPlaces).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                if (getActivity() instanceof MainActivity) {
                    MainActivity activity = (MainActivity) getActivity();
                    activity.ToDetailFragment(position);
                }
            }
        });

    }

    public void UseLinearList() {
        placesListAdapter.setListPlacesData(placesList);
        rvPlaces.setAdapter(placesListAdapter);

        llmPlaces = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        rvPlaces.setLayoutManager(llmPlaces);
    }

    public void UseGridList() {
        placesGridAdapter.setListPlacesData(placesList);
        rvPlaces.setAdapter(placesGridAdapter);

        glmPlaces = new GridLayoutManager(context, 2, LinearLayoutManager.VERTICAL, false);
        rvPlaces.setLayoutManager(glmPlaces);
    }

    public void UseCardList() {
        placesCardAdapter.setListPlacesData(placesList);
        rvPlaces.setAdapter(placesCardAdapter);

        llmPlaces = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        rvPlaces.setLayoutManager(llmPlaces);
    }

}
