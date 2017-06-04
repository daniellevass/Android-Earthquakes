package com.development.earthquakes.api;


import com.google.gson.annotations.SerializedName;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface EarthquakesService {

    String ENDPOINT = "https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/";

    @GET("all_day.geojson")
    Call<EarthquakeResponse> getAllTodayEarthquakes();

    class Factory {

        public static EarthquakesService makeService() {
            final OkHttpClient okHttpClient = new OkHttpClient().newBuilder().build();
            final Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(ENDPOINT)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build();

            return retrofit.create(EarthquakesService.class);
        }
    }

    class EarthquakeResponse {
        public List<Earthquake> features;
    }

    class Earthquake{
        @SerializedName("properties")
        public Property property;
    }

    class Property {
        public String place;
        public float mag;
        public long time;
        public int tsunami;
        public String type;
    }

}
