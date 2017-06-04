package com.development.earthquakes.api;


import android.support.annotation.NonNull;

import com.development.earthquakes.models.Earthquake;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class EarthquakesClient {

    private final EarthquakesService service;

    public EarthquakesClient(@NonNull final EarthquakesService service) {
        this.service = service;
    }

    public interface Callback {
        void onResponse(List<Earthquake> earthquakes);
        void onFailure(Throwable throwable);
    }

    public void getTodaysEarthquakes(@NonNull final EarthquakesClient.Callback callback) {

        service.getAllTodayEarthquakes().enqueue(new retrofit2.Callback<EarthquakesService.EarthquakeResponse>() {
            @Override
            public void onResponse(Call<EarthquakesService.EarthquakeResponse> call, Response<EarthquakesService.EarthquakeResponse> response) {
                callback.onResponse(parseEarthquakes(response.body()));
            }

            @Override
            public void onFailure(Call<EarthquakesService.EarthquakeResponse> call, Throwable throwable) {
                callback.onFailure(throwable);
            }
        });
    }

    private List<Earthquake> parseEarthquakes(EarthquakesService.EarthquakeResponse earthquakeResponse){
        List<Earthquake> earthquakes = new ArrayList<>();

        if (earthquakeResponse != null &&
                earthquakeResponse.features != null &&
                !earthquakeResponse.features.isEmpty()){

            for (EarthquakesService.Earthquake earthquake : earthquakeResponse.features){

                if (earthquake.property != null
                        && earthquake.property.place != null){

                    boolean isTsunami = false;
                    if (earthquake.property.tsunami == 1){
                        isTsunami = true;
                    }

                    earthquakes.add(new Earthquake(
                            earthquake.property.place,
                            earthquake.property.mag,
                            earthquake.property.time,
                            isTsunami,
                            earthquake.property.type)) ;
                }
            }


        }

        return earthquakes;
    }
}
