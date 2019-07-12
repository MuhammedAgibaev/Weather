package com.agibaev.weatherapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

public class SecondFragment extends Fragment {

    Button button;
    EditText editText;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_second, container, false);
        button = view.findViewById(R.id.btn1);
        editText = view.findViewById(R.id.edtxt);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity mainActivity = (MainActivity) getActivity();
                //mainActivity.setResultFragment(editText.getText().toString());
                mainActivity.setText(editText.getText().toString());
                mainActivity.onCloseFragment();
            }
        });

        return view;
    }

}
