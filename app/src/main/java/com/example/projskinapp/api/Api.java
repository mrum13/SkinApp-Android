package com.example.projskinapp.api;

import com.example.projskinapp.models.DefaultResponse;
import com.example.projskinapp.models.DokterResponse;
import com.example.projskinapp.models.LoginResponse;
import com.example.projskinapp.models.ProdukResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {
    @FormUrlEncoded
    @POST("createUser")
    Call<DefaultResponse> createUser(
            @Field("email") String email,
            @Field("password") String password,
            @Field("name") String name,
            @Field("nope") String nope
    );

    @FormUrlEncoded
    @POST("userLogin")
    Call<LoginResponse> userLogin(
            @Field("email") String email,
            @Field("password") String password
    );

    @GET("allDokter")
    Call<DokterResponse> getAllDokter();

    @FormUrlEncoded
    @POST("detailDokter")
    Call<DokterResponse> detailDokter(
            @Field("dokter") String nama_dokter
    );

    @FormUrlEncoded
    @POST("allProduk")
    Call<ProdukResponse> allProduk(
            @Field("produk") String nama_merk
    );

    @FormUrlEncoded
    @POST("searchProduk")
    Call<ProdukResponse> searchProduk(
            @Field("produk") String nama_produk
    );

    @FormUrlEncoded
    @POST("detailProduk")
    Call<ProdukResponse> detailProduk(
            @Field("nama_produk") String nama_produk
    );

    @FormUrlEncoded
    @POST("addCart")
    Call<DefaultResponse> addToCart(
            @Field("nm_crprod") String namaProduk,
            @Field("merk_crprod") String merkProduk,
            @Field("quantity_crprod") String quantityProduk,
            @Field("hrg_crprod") String hargaProduk,
            @Field("total") String totalProduk
    );
}
