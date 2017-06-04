package com.development.earthquakes.interactors;


import com.development.earthquakes.api.EarthquakesClient;
import com.development.earthquakes.api.EarthquakesService;

import javax.inject.Inject;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetTodaysEarthquakes {

    final EarthquakesClient earthquakesClient;

    @Inject
    public GetTodaysEarthquakes(final EarthquakesClient earthquakesClient) {
        this.earthquakesClient = earthquakesClient;
    }

    public void execute(EarthquakesClient.Callback callback) {
        earthquakesClient.getTodaysEarthquakes(callback);
    }
}
