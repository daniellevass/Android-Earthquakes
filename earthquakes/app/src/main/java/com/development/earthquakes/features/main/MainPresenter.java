package com.development.earthquakes.features.main;


import android.support.annotation.NonNull;

import com.development.earthquakes.api.EarthquakesClient;
import com.development.earthquakes.base.BasePresenter;
import com.development.earthquakes.interactors.GetTodaysEarthquakes;
import com.development.earthquakes.models.Earthquake;

import java.util.List;

public class MainPresenter extends BasePresenter<MainPresenter.View> {

    interface View {
        void onEarthquakes(List<Earthquake> earthquakes);
        void onError(Throwable throwable);
    }

    private final GetTodaysEarthquakes getTodaysEarthquakes;

    public MainPresenter(@NonNull final GetTodaysEarthquakes getTodaysEarthquakes) {
        this.getTodaysEarthquakes = getTodaysEarthquakes;
    }

    public void getTodaysEarthquakes() {
        getTodaysEarthquakes.execute(new EarthquakesClient.Callback() {
            @Override
            public void onResponse(List<Earthquake> earthquakes) {
                if (isViewAttached()){
                    getView().onEarthquakes(earthquakes);
                }
            }

            @Override
            public void onFailure(Throwable throwable) {
                if (isViewAttached()){
                    getView().onError(throwable);
                }
            }
        });
    }




}
