package com.example.projskinapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.projskinapp.api.RetrofitClient;
import com.example.projskinapp.consul.DoctorData;
import com.example.projskinapp.consul.GridDoctorAdapter;
import com.example.projskinapp.consul.ViewModelDoctor;
import com.example.projskinapp.models.Dokter;
import com.example.projskinapp.models.DokterResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Activity_Consul extends AppCompatActivity {

    private RecyclerView rvConsuldok;
    private List<Dokter> listDataDok;
    private LinearLayoutManager linearLayout;
    private GridDoctorAdapter adapter;
    Context context;
    ImageView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__consul);

        btnBack = findViewById(R.id.back_icon);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        rvConsuldok = (RecyclerView) findViewById(R.id.recycler_consul);
        rvConsuldok.setHasFixedSize(true);
//
        linearLayout = new LinearLayoutManager(Activity_Consul.this);

        Call<DokterResponse> call = RetrofitClient.getInstance().getApi().getAllDokter();
        call.enqueue(new Callback<DokterResponse>() {
            @Override
            public void onResponse(Call<DokterResponse> call, Response<DokterResponse> response) {
                listDataDok = response.body().getDokter();
                rvConsuldok.setLayoutManager(linearLayout);
                adapter = new GridDoctorAdapter(listDataDok);
                rvConsuldok.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<DokterResponse> call, Throwable t) {

            }
        });
    }
}