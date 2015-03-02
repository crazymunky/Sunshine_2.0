package com.example.android.sunshine2;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.sunshine2.classes.Forecast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public  class ForecastFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public ForecastFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.forecast_card_list);
        mLayoutManager = new LinearLayoutManager(getActivity());

        Forecast[] forecastArray = {
                new Forecast("Today - Sunny - 88/63"),
                new Forecast("Tomorrow - Foggy - 70/46"),
                new Forecast("Weds - Cloudy - 72/63"),
                new Forecast("Thurs - Rainy - 64/51"),
                new Forecast("Fri - Foggy - 70/46"),
                new Forecast("Sat - Sunny - 76/68"),
                new Forecast("Sun - Shadowy - 76/68"),
                new Forecast("Today - Sunny - 88/63"),
                new Forecast("Tomorrow - Foggy - 70/46"),
                new Forecast("Weds - Cloudy - 72/63"),
                new Forecast("Thurs - Rainy - 64/51"),
                new Forecast("Fri - Foggy - 70/46"),
                new Forecast("Sat - Sunny - 76/68"),
                new Forecast("Today - Sunny - 88/63"),
                new Forecast("Tomorrow - Foggy - 70/46"),
                new Forecast("Weds - Cloudy - 72/63"),
                new Forecast("Thurs - Rainy - 64/51"),
                new Forecast("Fri - Foggy - 70/46"),
                new Forecast("Sat - Sunny - 76/68"),
                new Forecast("Sun - Shadowy - 76/68"),
                new Forecast("Today - Sunny - 88/63"),
                new Forecast("Tomorrow - Foggy - 70/46"),
                new Forecast("Weds - Cloudy - 72/63"),
                new Forecast("Thurs - Rainy - 64/51"),
                new Forecast("Fri - Foggy - 70/46"),
                new Forecast("Sat - Sunny - 76/68"),
                new Forecast("Sun - Shadowy - 76/68")
        };

        mAdapter = new ForecastAdapter(forecastArray);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        return rootView;
    }
    public class FetchWeatherTask extends AsyncTask<Void, Void, Void> {

        private final String LOG_TAG = FetchWeatherTask.class.getSimpleName();

        @Override
        protected Void doInBackground(Void[] params) {

            // These two need to be declared outside the try/catch
// so that they can be closed in the finally block.
            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;

// Will contain the raw JSON response as a string.
            String forecastJsonStr = null;

            try {
                // Construct the URL for the OpenWeatherMap query
                // Possible parameters are available at OWM's forecast API page, at
                // http://openweathermap.org/API#forecast
                URL url = new URL("http://api.openweathermap.org/data/2.5/forecast/daily?q=94043&mode=json&units=metric&cnt=7");

                // Create the request to OpenWeatherMap, and open the connection
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();

                // Read the input stream into a String
                InputStream inputStream = urlConnection.getInputStream();
                StringBuffer buffer = new StringBuffer();
                if (inputStream == null) {
                    // Nothing to do.
                    return null;
                }
                reader = new BufferedReader(new InputStreamReader(inputStream));

                String line;
                while ((line = reader.readLine()) != null) {
                    // Since it's JSON, adding a newline isn't necessary (it won't affect parsing)
                    // But it does make debugging a *lot* easier if you print out the completed
                    // buffer for debugging.
                    buffer.append(line + "\n");
                }

                if (buffer.length() == 0) {
                    // Stream was empty.  No point in parsing.
                    return null;
                }
                forecastJsonStr = buffer.toString();
            } catch (IOException e) {
                Log.e(LOG_TAG, "Error ", e);
                // If the code didn't successfully get the weather data, there's no point in attempting
                // to parse it.
                return null;
            } finally{
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (final IOException e) {
                        Log.e(LOG_TAG, "Error closing stream", e);
                    }
                }
            }
            return null;
        }
    }

}