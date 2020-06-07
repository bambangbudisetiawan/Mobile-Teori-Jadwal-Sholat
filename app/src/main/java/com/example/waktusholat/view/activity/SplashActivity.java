package com.example.waktusholat.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.waktusholat.R;


public class SplashActivity extends AppCompatActivity {

        private int waktu_loading=4000;
        //4000 4 detik , ini perMiliSecond

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_splash);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    //setelah loading langsung masuk ke MainActivity

                    Intent splash = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(splash);
                    finish();
                }
            },waktu_loading);

        }
    }
