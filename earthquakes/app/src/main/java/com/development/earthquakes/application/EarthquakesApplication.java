package com.development.earthquakes.application;

import android.app.Application;

public class EarthquakesApplication extends Application {

    private ApplicationComponent applicationComponent = createComponent();

    protected ApplicationComponent createComponent() {
        return DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
