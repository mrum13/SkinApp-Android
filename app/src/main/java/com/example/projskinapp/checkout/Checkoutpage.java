package com.example.projskinapp.checkout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.projskinapp.R;
import com.example.projskinapp.fragment.FragmentAccount;
import com.example.projskinapp.home.Frag_Home;
import com.example.projskinapp.search.Fragsearch;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Checkoutpage extends AppCompatActivity {
    static Checkoutpage activity_checkoutpage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkoutpage);
    }

//        activity_checkoutpage = this;
//
//        loadFragment(new Fragcheckout());
//
//        //inisialisasi BottomnavigationView
//        BottomNavigationView bottomNavigationView = findViewById(R.id.shop);
//
//        //beri listener pada saat intem/menu bottomnavigation terpilih
//        BottomNavigationView.OnNavigationItemSelectedListener.this);
//
//    }
//
//    private boolean loadFragment(Fragcheckout fragcheckout) {
//        if (fragcheckout != null){
//            getSupportFragmentManager().beginTransaction().replace(R.id.fragcheckout, fragcheckout).commit();
//            return true;
//        }
//        return false;
//    }
}