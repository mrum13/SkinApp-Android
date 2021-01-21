package com.example.projskinapp.models;

public class Cart {
    String nm_crprod,merk_crprod,quantity_crprod,hrg_crprod,total;

    public Cart(String nm_crprod, String merk_crprod, String quantity_crprod, String hrg_crprod, String total) {
        this.nm_crprod = nm_crprod;
        this.merk_crprod = merk_crprod;
        this.quantity_crprod = quantity_crprod;
        this.hrg_crprod = hrg_crprod;
        this.total = total;
    }

    public String getNm_crprod() {
        return nm_crprod;
    }

    public String getMerk_crprod() {
        return merk_crprod;
    }

    public String getQuantity_crprod() {
        return quantity_crprod;
    }

    public String getHrg_crprod() {
        return hrg_crprod;
    }

    public String getTotal() {
        return total;
    }
}
