package com.example.projskinapp.models;

public class Produk {
    private String nm_prod,detail_prod,hrg_prod,gb_prod,merk_prod;

    public Produk(String nm_prod, String detail_prod, String hrg_prod, String gb_prod, String merk_prod) {
        this.nm_prod = nm_prod;
        this.detail_prod = detail_prod;
        this.hrg_prod = hrg_prod;
        this.gb_prod = gb_prod;
        this.merk_prod = merk_prod;
    }

    public String getNm_prod() {
        return nm_prod;
    }

    public String getDetail_prod() {
        return detail_prod;
    }

    public String getHrg_prod() {
        return hrg_prod;
    }

    public String getGb_prod() {
        return gb_prod;
    }

    public String getMerk_prod() {
        return merk_prod;
    }
}
