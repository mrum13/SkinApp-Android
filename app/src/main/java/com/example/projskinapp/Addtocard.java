package com.example.projskinapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class Addtocard extends AppCompatActivity {
    private Button btnBackToShooping;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addtocard);
        inisialisasiObjek();
    }

    private void inisialisasiObjek(){
        btnBackToShooping = findViewById(R.id.btn_backToShopping);
    }
}