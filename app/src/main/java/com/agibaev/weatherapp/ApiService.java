package com.agibaev.weatherapp;

import com.agibaev.weatherapp.data.DailyForecast;
import com.agibaev.weatherapp.data.Weather;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

        @GET("222844")
        Call<Weather> GetMyWeather(@Query("apikey") String apiKey);
}
