package com.development.earthquakes.interactors;

import com.development.earthquakes.api.EarthquakesClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class InteractorsModule {

    @Provides
    public GetTodaysEarthquakes provideGetTodaysEarthquakes(EarthquakesClient earthquakesClient) {
        return new GetTodaysEarthquakes(earthquakesClient);
    }
}
