package com.example.projskinapp.models;

import java.util.List;

public class ProdukResponse {
    private boolean error;
    private List<Produk> produk;

    public ProdukResponse(boolean error, List<Produk> produk) {
        this.error = error;
        this.produk = produk;
    }

    public boolean isError() {
        return error;
    }

    public List<Produk> getProduk() {
        return produk;
    }
}
