package com.example.android.sunshine2.classes;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Forecast {
    private Calendar fecha;
    private Double minTemp;
    private Double maxTemp;
    private String description;

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public Double getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(Double minTemp) {
        this.minTemp = minTemp;
    }

    public Double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(Double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE MMM dd");
        simpleDateFormat.setTimeZone(this.getFecha().getTimeZone());

        return simpleDateFormat.format(this.getFecha().getTime()) + " - " + this.getDescription() + " - " + this.getMaxTemp()+"/"+this.getMinTemp();

    }
}
