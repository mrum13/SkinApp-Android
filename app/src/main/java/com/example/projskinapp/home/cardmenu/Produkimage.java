package com.example.projskinapp.home.cardmenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.projskinapp.Activity_Profildok;
import com.example.projskinapp.R;
import com.example.projskinapp.api.RetrofitClient;
import com.example.projskinapp.consul.GridDoctorAdapter;
import com.example.projskinapp.home.cardmenu.adaptermenu.AdapterMenuSkincare;
import com.example.projskinapp.home.cardmenu.datamenu.DataMenuSkincare;
import com.example.projskinapp.home.cardmenu.viewmodelmenu.ViewModelMenuSkincare;
import com.example.projskinapp.models.Dokter;
import com.example.projskinapp.models.DokterResponse;
import com.example.projskinapp.models.Produk;
import com.example.projskinapp.models.ProdukResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Produkimage extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView rvMenuSkincare;
    private List<Produk> listProduk;
    private String merkProduk, kategori;
    private TextView tvNmProduk;
    private ImageView btnBack;
    private AdapterMenuSkincare adapterMenuSkincare;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produkimage);

        inisialisasiObjek();
        hideProgressBar();
        getIncomingIntent();
    }

    private void inisialisasiObjek(){
        tvNmProduk = findViewById(R.id.tv_menuskincare);
        btnBack = findViewById(R.id.back_icon);
        rvMenuSkincare = findViewById(R.id.rv_menuskincare);
        progressBar = findViewById(R.id.progress_circular);
    }

    @Override
    public void onClick(View v) {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void showProgressBar(){
        progressBar.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar(){
        progressBar.setVisibility(View.GONE);
    }

    private void getIncomingIntent(){
        if (getIntent().hasExtra("tvNamaProduk")) {
            merkProduk= getIntent().getStringExtra("tvNamaProduk");
        }

        if (merkProduk.equals("Oriflame")) {
            kategori = "Oriflame";
            tvNmProduk.setText(kategori);
        } else if (merkProduk.equals("RK")) {
            kategori = "RK";
            tvNmProduk.setText(kategori);
        } else if (merkProduk.equals("Morning Power")) {
//            list.addAll(DataMenuSkincare.getListDataPowerMor());
            kategori = "Morning Power";
            tvNmProduk.setText(kategori);
        }
        loadData(merkProduk);
    }

    private void setAdapterProduk(){
        rvMenuSkincare.setHasFixedSize(true);
        rvMenuSkincare.setLayoutManager(new GridLayoutManager(this, 2));
        adapterMenuSkincare = new AdapterMenuSkincare(listProduk, kategori);
        rvMenuSkincare.setAdapter(adapterMenuSkincare);
    }

    private void loadData(final String nama_merk){
        showProgressBar();
        Call<ProdukResponse> call = RetrofitClient.getInstance().getApi().allProduk(nama_merk);
        call.enqueue(new Callback<ProdukResponse>() {
            @Override
            public void onResponse(Call<ProdukResponse> call, Response<ProdukResponse> response) {
                ProdukResponse produkResponse =response.body();
                if (produkResponse.isError()){
                    hideProgressBar();
                    Toast.makeText(Produkimage.this, "Data tidak ada",Toast.LENGTH_LONG).show();
                }
                else {
                    listProduk = response.body().getProduk();
                    hideProgressBar();
                    setAdapterProduk();
                }
            }

            @Override
            public void onFailure(Call<ProdukResponse> call, Throwable t) {
                hideProgressBar();
                System.out.print(nama_merk);
            }
        });
    }
}