package com.example.petvirtual;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

       SharedPreferences sharedPreferences = getSharedPreferences("StatusLogin", MODE_PRIVATE);
       SharedPreferences.Editor editor = sharedPreferences.edit();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Executado sempre quando o timer acabar
                if(sharedPreferences.contains("statuslog")){
                    Intent i = new Intent(getApplicationContext(), MenuActivity.class);
                    startActivity(i);
                    finish();
                }else{
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
                    finish();
                }

            }
        },1500);
    }
}