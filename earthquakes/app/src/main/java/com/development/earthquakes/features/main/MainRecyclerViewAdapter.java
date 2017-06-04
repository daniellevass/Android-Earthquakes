package com.development.earthquakes.features.main;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.development.earthquakes.R;
import com.development.earthquakes.models.Earthquake;

import java.util.ArrayList;
import java.util.List;

public class MainRecyclerViewAdapter extends RecyclerView.Adapter<MainEarthquakeHolder>{

    private List<Earthquake> earthquakes;
    private Context context;

    public MainRecyclerViewAdapter(Context context) {
        this.earthquakes = new ArrayList<>();
        this.context = context;
    }

    @Override
    public MainEarthquakeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MainEarthquakeHolder(context,
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.activity_main_row, parent, false));
    }

    @Override
    public void onBindViewHolder(MainEarthquakeHolder holder, int position) {
        holder.bindCard(earthquakes.get(position));
    }

    @Override
    public int getItemCount() {
        return earthquakes.size();
    }


    public void setEarthquakes(@NonNull List<Earthquake> earthquakes) {
        this.earthquakes = earthquakes;
        notifyDataSetChanged();
    }
}
