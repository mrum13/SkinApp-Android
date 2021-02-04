package com.example.projskinapp.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;


import com.example.projskinapp.checkproduct.MyOrder;
import com.example.projskinapp.R;
import com.example.projskinapp.Registerform;
import com.example.projskinapp.fragment.FragmentAccount;
import com.example.projskinapp.search.Fragsearch;
import com.example.projskinapp.storage.SharedPrefManager;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    static Home activity_home;

    public static Home getInstance() {
        return activity_home;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        activity_home = this;

        loadFragment(new Frag_Home());

        //inisialisasi BottomnavigationView
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNav);

        //beri listener pada saat intem/menu bottomnavigation terpilih
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(!SharedPrefManager.getInstance(this).isLoggedIn()){
            Intent intent = new Intent(this, Registerform.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fraghome, fragment).commit();
            return true;
        }
        return false;
    }

    //method listener untuk logika pemilihan
    @Override
    public boolean onNavigationItemSelected (@NonNull MenuItem item){
        Fragment fragment = null;
        //switch case fragment{}
        switch (item.getItemId()){
            case R.id.hm:
                fragment = new Frag_Home();
                break;
            case R.id.sr:
                fragment = new Fragsearch();
                break;
            case R.id.shop:
                fragment = new MyOrder();
                break;
            case R.id.cont: 
                fragment = new FragmentAccount();
                break;
        }
        return loadFragment(fragment);
    }


}