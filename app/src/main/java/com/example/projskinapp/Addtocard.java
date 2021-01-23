package com.example.projskinapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.projskinapp.home.cardmenu.Produkimage;

public class Addtocard extends AppCompatActivity implements View.OnClickListener {
    private Button btnBackToShooping;
    private String merkProduk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addtocard);
        inisialisasiObjek();
        getIncomingIntent();
        btnBackToShooping.setOnClickListener(this);
    }

    private void inisialisasiObjek(){
        btnBackToShooping = findViewById(R.id.btn_backToShopping);
    }

    private void getIncomingIntent(){
        if (getIntent().hasExtra("merk")) {
            merkProduk= getIntent().getStringExtra("merk");
        }
    }

    @Override
    public void onClick(View view) {
        Intent kembali = new Intent(Addtocard.this, Produkimage.class);
        kembali.putExtra("tvNamaProduk", merkProduk);
        startActivity(kembali);
        finish();
    }
}