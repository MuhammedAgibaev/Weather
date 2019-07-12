package com.agibaev.weatherapp;

import com.agibaev.weatherapp.data.DailyForecast;
import com.agibaev.weatherapp.data.Day;
import com.agibaev.weatherapp.data.GeoPosition;
import com.agibaev.weatherapp.data.Temperature;

import java.util.List;
import retrofit2.http.GET;

public interface ApiService {
        @GET("getDay")
        List<Day> getDay();

        @GET("getTemperature")
        List<Temperature> getTemperature();

        @GET("getGeoPosition")
        List<GeoPosition> getGeoPosition();

        @GET("DailyForecast")
        List<DailyForecast> DailyForecast();
}
