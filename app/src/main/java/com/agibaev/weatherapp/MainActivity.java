package com.agibaev.weatherapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends FragmentActivity {

    public static String TEXT = "text";

    MainFragment fragment = new MainFragment();
    SecondFragment secondFragment = new SecondFragment();
    FragmentManager fm = getSupportFragmentManager();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.main_continer, fragment);
        ft.commit();
    }

    public void onOpenFragment (){
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.main_continer, secondFragment);
        ft.commit();
    }

    public void onCloseFragment(){
        FragmentTransaction ft = fm.beginTransaction();
        ft.remove(secondFragment);
        ft.commit();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 1){
            if (resultCode == RESULT_OK){
                String text = data.getStringExtra(MainActivity.TEXT);
                fragment.setText(text);
            }
        }
    }

    public void setText(String text){
        fragment.setText(text);
    }
}