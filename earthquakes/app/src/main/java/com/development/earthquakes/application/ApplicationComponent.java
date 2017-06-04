package com.development.earthquakes.application;


import com.development.earthquakes.api.EarthquakesClient;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
    EarthquakesClient earthquakesClient();
}
