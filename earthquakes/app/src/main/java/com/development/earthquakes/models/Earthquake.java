package com.development.earthquakes.models;


import android.support.annotation.NonNull;

public class Earthquake {


    @NonNull private String place;
    private float mag;
    private long time;
    private boolean tsunami;
    @NonNull private String type;

    public Earthquake(@NonNull String place, float mag, long time, boolean tsunami,
                      @NonNull String type) {
        this.place = place;
        this.mag = mag;
        this.time = time;
        this.tsunami = tsunami;
        this.type = type;
    }

    @NonNull
    public String getPlace() {
        return place;
    }

    public float getMag() {
        return mag;
    }

    public long getTime() {
        return time;
    }

    public boolean isTsunami() {
        return tsunami;
    }

    @NonNull
    public String getType() {
        return type;
    }
}
