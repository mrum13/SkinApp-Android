package com.example.projskinapp.checkout;

public class ViewModelCheckout {
    public ViewModelCheckout () {
        this.checkoutNames = checkoutNames;
        this.checkoutHarga = checkoutHarga;
        this.checkoutWarna = checkoutWarna;
        this.checkoutImage1 = checkoutImage1;
        this.checkoutImage2 = checkoutImage2;
    }

    String checkoutNames, checkoutHarga, checkoutWarna;
    int checkoutImage1, checkoutImage2;

    public String getCheckoutNames() {
        return checkoutNames;
    }

    public void setCheckoutNames(String checkoutNames) {
        this.checkoutNames = checkoutNames;
    }

    public String getCheckoutHarga() {
        return checkoutHarga;
    }

    public void setCheckoutHarga(String checkoutHarga) {
        this.checkoutHarga = checkoutHarga;
    }

    public String getCheckoutWarna() {
        return checkoutWarna;
    }

    public void setCheckoutWarna(String checkoutWarna) {
        this.checkoutWarna = checkoutWarna;
    }

    public int getCheckoutImage1() {
        return checkoutImage1;
    }

    public void setCheckoutImage1(int checkoutImage1) {
        this.checkoutImage1 = checkoutImage1;
    }

    public int getCheckoutImage2() {
        return checkoutImage2;
    }

    public void setCheckoutImage2(int checkoutImage2) {
        this.checkoutImage2 = checkoutImage2;
    }
}
