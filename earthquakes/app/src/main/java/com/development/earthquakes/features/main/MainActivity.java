package com.development.earthquakes.features.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.development.earthquakes.R;
import com.development.earthquakes.api.EarthquakesClient;
import com.development.earthquakes.application.EarthquakesApplication;
import com.development.earthquakes.interactors.GetTodaysEarthquakes;
import com.development.earthquakes.models.Earthquake;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainPresenter.View {

    @Inject MainPresenter mainPresenter;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    MainRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createComponentAndInject();

        ButterKnife.bind(this);

        mainPresenter.onViewAttached(this);
        mainPresenter.getTodaysEarthquakes();

        adapter = new MainRecyclerViewAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setAdapter(adapter);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.onViewDetached();
    }

    @Override
    public void onEarthquakes(List<Earthquake> earthquakes) {
        adapter.setEarthquakes(earthquakes);
    }

    @Override
    public void onError(Throwable throwable) {
        //here we'd probably aim to handle this better
        Toast.makeText(MainActivity.this,
                "Error = " + throwable.getLocalizedMessage(),
                Toast.LENGTH_SHORT).show();
    }

    public void createComponentAndInject() {
        MainComponent component = DaggerMainComponent.builder().applicationComponent(((EarthquakesApplication) getApplication()).getApplicationComponent())
                .mainModule(new MainModule(this)).build();

        component.inject(this);
    }

}
