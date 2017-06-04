package com.development.earthquakes.features.main;


import com.development.earthquakes.application.ApplicationComponent;
import com.development.earthquakes.interactors.InteractorsModule;

import dagger.Component;

@MainScope
@Component( dependencies = ApplicationComponent.class, modules = {MainModule.class, InteractorsModule.class})
public interface MainComponent {

    void inject(MainActivity mainActivity);

    MainPresenter mainPresenter();
}
