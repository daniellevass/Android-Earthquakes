package com.development.earthquakes.features.main;


import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.TextView;

import com.development.earthquakes.R;
import com.development.earthquakes.models.Earthquake;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.Component;

public class MainEarthquakeHolder extends ViewHolder{


    @BindView(R.id.lblTime)
    TextView lblTime;

    @BindView(R.id.lblDescription)
    TextView lblDescription;

    private Context context;


    public MainEarthquakeHolder(Context context, View itemView) {
        super(itemView);
        this.context = context;
        ButterKnife.bind(this, itemView);
    }

    public void bindCard(Earthquake earthquake) {

        Date date = new Date(earthquake.getTime());
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH);

        lblTime.setText(dateFormat.format(date));

        lblDescription.setText(String.format(Locale.ENGLISH, "%.2f %s ",
                earthquake.getMag(), earthquake.getPlace()));

        int textColour = calculateColour(earthquake.getMag());

        itemView.setBackgroundColor(ContextCompat.getColor(context, textColour));
//        lblDescription.setTextColor(ContextCompat.getColor(context, textColour));

    }

    private int calculateColour(float magnitude){

        if (magnitude > 7f){
            return R.color.earthquake_large;
        }

        if (magnitude > 5f){
            return R.color.earthquake_medium;
        }

        if (magnitude > 2f){
            return R.color.earthquake_small_medium;
        }

        return R.color.earthquake_small;
    }



}
