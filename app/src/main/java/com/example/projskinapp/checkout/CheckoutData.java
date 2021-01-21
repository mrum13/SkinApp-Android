package com.example.projskinapp.checkout;

import com.example.projskinapp.R;
import com.example.projskinapp.consul.ViewModelDoctor;

import java.util.ArrayList;

public class CheckoutData {
    private static String[] checkoutNames= {
            "New",
            "New",
    };


    private static String[] checkoutHarga = {
            "USD 999",
            "USD 249"
    };

    private static int[] checkoutImages1 = {
            R.drawable.foundorif,
            R.drawable.lipbalmorif
    };

    private static int[] checkoutImages2 = {
            R.drawable.close_icon,
            R.drawable.close_icon
    };

    private static String[] checkoutWarna = {
            "White",
            "White"
    };

    static ArrayList<ViewModelCheckout> getListData() {
        ArrayList<ViewModelCheckout> list = new ArrayList<>();
        for (int position = 0; position < checkoutNames.length; position++) {
            ViewModelCheckout checkout = new ViewModelCheckout();
            checkout.setCheckoutNames(checkoutNames[position]);
            checkout.setCheckoutHarga(checkoutHarga[position]);
            checkout.setCheckoutImage1(checkoutImages1[position]);
            checkout.setCheckoutImage2(checkoutImages2[position]);
            checkout.setCheckoutWarna(checkoutWarna[position]);
            list.add(checkout);
        }
        return list;
    }
}