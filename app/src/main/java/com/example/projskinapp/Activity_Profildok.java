package com.example.projskinapp;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.projskinapp.api.RetrofitClient;
import com.example.projskinapp.models.Dokter;
import com.example.projskinapp.models.DokterResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Activity_Profildok extends AppCompatActivity implements View.OnClickListener {
    private ImageView btnBack;
    private TextView tvNama,tvSpesialis,tvAbout,tvKlinik;
    private String dokter;
    private ImageView gambarDokter;

    private Dokter[] detailDokter;
    private List<Dokter> listDokter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__profildok);

        inisialisasiObjek();
        getIncomingIntent();
    }

    private void inisialisasiObjek(){
        btnBack = findViewById(R.id.back_icon1);
        tvNama = findViewById(R.id.dr_stella_k);
        tvSpesialis = findViewById(R.id.tv_spesialis_detail);
        tvAbout = findViewById(R.id.descdok);
        gambarDokter = findViewById(R.id.propic);
        tvKlinik = findViewById(R.id.tv_klinik_detail);
    }

    private void getIncomingIntent(){
        if(getIntent().hasExtra("namaDokter")) {
            dokter = getIntent().getStringExtra("namaDokter");
            Call<DokterResponse> call = RetrofitClient.getInstance().getApi().detailDokter(dokter);
            call.enqueue(new Callback<DokterResponse>() {
                @Override
                public void onResponse(Call<DokterResponse> call, Response<DokterResponse> response) {
                    DokterResponse dokterResponse =response.body();
                    if (!dokterResponse.isError()){
                        listDokter = response.body().getDokter();
                        detailDokter = listDokter.toArray(new Dokter[0]);
                        tvNama.setText(detailDokter[0].getNm_dok());
                        tvSpesialis.setText(detailDokter[0].getSpes_dok());
                        tvKlinik.setText(detailDokter[0].getKlinik_dok());
                        tvAbout.setText(detailDokter[0].getAbout_dok());
                        RequestOptions options = new RequestOptions()
                                .centerCrop()
                                .placeholder(R.mipmap.ic_launcher_round)
                                .error(R.mipmap.ic_launcher_round);
                        Glide.with(Activity_Profildok.this).load(detailDokter[0].getGb_dok()).apply(options).into(gambarDokter);

                    }
                    else {
                        Toast.makeText(Activity_Profildok.this, "Data tidak ada",Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<DokterResponse> call, Throwable t) {

                }
            });
        }
    }

    @Override
    public void onClick(View v) {
        //btn kembali
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}