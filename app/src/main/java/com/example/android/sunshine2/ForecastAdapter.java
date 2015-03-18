package com.example.android.sunshine2;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.sunshine2.classes.Forecast;

import java.util.List;

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ViewHolder> {
    private List<Forecast> mDataForecasts;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mForecastText;
        public ViewHolder(View v) {
            super(v);
            mForecastText = (TextView) v.findViewById(R.id.forecast_text);
        }
    }

    public ForecastAdapter(List<Forecast> forecasts) {
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
        Forecast forecast = mDataForecasts.get(position);
        if(forecast!=null)
            holder.mForecastText.setText(mDataForecasts.get(position).toString());
    }


    @Override
    public int getItemCount() {
        return mDataForecasts.size();
    }
}