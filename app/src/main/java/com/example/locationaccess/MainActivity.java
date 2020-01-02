package com.example.locationaccess;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.locationaccess.utils.CustomEditButton;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {
    String data;
    EditText editText;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        CustomEditButton customEditButton = findViewById(R.id.llButton);
        ImageView customButton = findViewById(R.id.btnCustomButton);
        Button submit = findViewById(R.id.submit);
        editText = ((EditText) customEditButton.getChildAt(0).findViewById(R.id.tvCustomEditText));

        customEditButton.setButtonCall(true);

        customEditButton.setOnButtonClickListener(new CustomEditButton.OnButtonClickListener() {
            @Override
            public void onClick(View view) {
                /*On Button Clicked*/
                Toast.makeText(getApplicationContext(), "Button Clicked", Toast.LENGTH_LONG).show();
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = editText.getText().toString().trim();
                Toast.makeText(getApplicationContext(), data, Toast.LENGTH_LONG).show();
            }
        });
        customEditButton.setOnValueChangeListener(new CustomEditButton.OnValueChangeListener() {
            @Override
            public void onValueChange(String value) {
                /*Geting realtime value here*/
            }
        });

    }
}