package com.development.earthquakes.features.main;


import com.development.earthquakes.interactors.GetTodaysEarthquakes;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    private final MainActivity activity;

    public MainModule(MainActivity activity){
        this.activity = activity;
    }

    @Provides
    @MainScope
    public MainPresenter provideMainPresenter(GetTodaysEarthquakes getTodaysEarthquakes) {
        return new MainPresenter(getTodaysEarthquakes);
    }


}
