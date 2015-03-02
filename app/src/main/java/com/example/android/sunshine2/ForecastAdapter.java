package com.example.android.sunshine2;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.sunshine2.classes.Forecast;

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ViewHolder> {
    private Forecast[] mDataForecasts;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mForecastText;
        public ViewHolder(View v) {
            super(v);
            mForecastText = (TextView) v.findViewById(R.id.forecast_text);
        }
    }

    public ForecastAdapter(Forecast[] forecasts) {
        mDataForecasts = forecasts;
    }

    @Override
    public ForecastAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.forecast_card, parent, false);

        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mForecastText.setText(mDataForecasts[position].getText());

    }


    @Override
    public int getItemCount() {
        return mDataForecasts.length;
    }
}