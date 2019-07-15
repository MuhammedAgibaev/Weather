package com.agibaev.weatherapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.agibaev.weatherapp.data.Weather;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainFragment extends Fragment {

    Button button;
    TextView textView;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main, container, false);
        button = view.findViewById(R.id.btn);
        textView = view.findViewById(R.id.txt);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ApiService api= NetworkService.getServerapi();
                Call<Weather> call =api.GetMyWeather("hxRWXociZSUgAOptqOS3H9siIBQ6f3Wy");
                call.enqueue(new Callback<Weather>() {
                    @Override
                    public void onResponse(Call<Weather> call, Response<Weather> response) {
                        //Weather data=response.body();

                        Toast.makeText(getActivity(), response.body().getDailyForecast().toString(), Toast.LENGTH_LONG).show();
                        Log.d("Weatherstr", response.body().getDailyForecast().toString());

                    }

                    @Override
                    public void onFailure(Call<Weather> call, Throwable t) {
                        Log.d("Weatherstr ",  t.toString());
                    }
                });

                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.onOpenFragment();
            }
        });

        return view;
    }

    public  void setText(String text){
        textView.setText(text);
    }
}
