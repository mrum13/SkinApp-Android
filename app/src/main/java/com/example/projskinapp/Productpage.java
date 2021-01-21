package com.example.projskinapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.projskinapp.api.RetrofitClient;
import com.example.projskinapp.login.LoginActivity;
import com.example.projskinapp.models.DefaultResponse;
import com.example.projskinapp.models.Produk;
import com.example.projskinapp.models.ProdukResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Productpage extends AppCompatActivity implements View.OnClickListener {
    private TextView merkProdukDetail,deskripsiProdukDetail,namaProdukDetail,hargaProdukDetail;
    private ImageView gambarProduk;
    private Button btnAddToCart;
    private String namaProduk,merkProduk,quantityProduk,hargaProduk,totalProduk;
    private List<Produk> listProduk;
    private Produk[] detailProduk;
    private int harga,total,quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productpage);

        inisialisasiObjek();
        btnAddToCart.setVisibility(View.GONE);
        getIncomingIntent();
        btnAddToCart.setOnClickListener(this);
    }

    private void inisialisasiObjek(){
        merkProdukDetail = findViewById(R.id.merk_produk);
        deskripsiProdukDetail = findViewById(R.id.deskripsi_produk);
        gambarProduk = findViewById(R.id.gambar_produk);
        btnAddToCart = findViewById(R.id.btn_addtocart);
        namaProdukDetail = findViewById(R.id.nama_produk_detail);
        hargaProdukDetail = findViewById(R.id.harga_produk);
    }

    private void getIncomingIntent(){
        if(getIntent().hasExtra("nama_produk")) {
            namaProduk = getIntent().getStringExtra("nama_produk");

            Call<ProdukResponse> call = RetrofitClient.getInstance().getApi().detailProduk(namaProduk);
            call.enqueue(new Callback<ProdukResponse>() {
                @Override
                public void onResponse(Call<ProdukResponse> call, Response<ProdukResponse> response) {
                    ProdukResponse produkResponse =response.body();
                    if (!produkResponse.isError()){
                        listProduk = response.body().getProduk();
                        if (listProduk == null) {
                            merkProdukDetail.setText("Data tidak ada");

                        }
                        else {
                            detailProduk = listProduk.toArray(new Produk[0]);
                            merkProdukDetail.setText(detailProduk[0].getMerk_prod());
                            namaProdukDetail.setText(detailProduk[0].getNm_prod());
                            deskripsiProdukDetail.setText(detailProduk[0].getDetail_prod());
                            hargaProdukDetail.setText(detailProduk[0].getHrg_prod());
                            RequestOptions options = new RequestOptions()
                                    .centerCrop()
                                    .placeholder(R.mipmap.ic_launcher_round)
                                    .error(R.mipmap.ic_launcher_round);
                            Glide.with(Productpage.this).load(detailProduk[0].getGb_prod()).apply(options).into(gambarProduk);

                            merkProduk = merkProdukDetail.getText().toString().trim();
                            quantityProduk = "1";
                            quantity = Integer.parseInt(quantityProduk);
                            hargaProduk = hargaProdukDetail.getText().toString().trim();
                            harga = Integer.parseInt(hargaProduk);
                            total = harga*quantity;
                            totalProduk = String.valueOf(total);
                            btnAddToCart.setVisibility(View.VISIBLE);
                        }
                    }
                    else {

                    }
                }

                @Override
                public void onFailure(Call<ProdukResponse> call, Throwable t) {

                }
            });
        }
    }

    @Override
    public void onClick(View v) {
        prosesCart();
    }

    private void prosesCart(){
        Call<DefaultResponse> call= RetrofitClient.getInstance().getApi().addToCart(namaProduk,merkProduk,quantityProduk,hargaProduk,totalProduk);
        call.enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                if(response.code()==201){
                    DefaultResponse dr = response.body();
                    Toast.makeText(Productpage.this, dr.getMsg(),Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Productpage.this, Addtocard.class));
                }
                else if (response.code()==422){
                    Toast.makeText(Productpage.this,"Produk gagal ditambahkan",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {
                Toast.makeText(Productpage.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}