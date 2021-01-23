package com.example.projskinapp.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.projskinapp.login.LoginActivity;
import com.example.projskinapp.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //yang terjadi
                Intent panggil = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(panggil);
                finish();
            }
        }, 4000);
    }
}
