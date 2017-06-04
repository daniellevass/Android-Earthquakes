package com.development.earthquakes.application;


import android.content.Context;
import android.support.annotation.NonNull;

import com.development.earthquakes.api.EarthquakesClient;
import com.development.earthquakes.api.EarthquakesService;
import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final EarthquakesApplication application;

    public ApplicationModule(final EarthquakesApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public EarthquakesService provideEarthquakeService() {
        return EarthquakesService.Factory.makeService();
    }

    @Provides
    @Singleton
    public EarthquakesClient provideEarthquakeClient(final EarthquakesService service) {
        return new EarthquakesClient(service);
    }
}
