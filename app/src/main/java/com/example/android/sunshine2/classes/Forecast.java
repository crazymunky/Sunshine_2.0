package com.example.android.sunshine2.classes;
public class Forecast {
    private String text;

    public Forecast(String text){
        this.setText(text);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
