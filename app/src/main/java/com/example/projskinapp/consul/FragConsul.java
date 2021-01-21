package com.example.projskinapp.consul;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.projskinapp.R;

import java.util.ArrayList;


public class FragConsul extends Fragment {
    private RecyclerView rvConsuldok;
    private ArrayList<ViewModelDoctor> listDataDok;
    private LinearLayoutManager linearLayout;
    private RecyclerView.Adapter adapter;
    Context context;
    ImageView btnBack;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_consul_hm, container, false);

//        listDataDok = new ArrayList<ViewModelDoctor>();
//        listDataDok.addAll(DoctorData.getListData());
//
//        rvConsuldok = (RecyclerView) view.findViewById(R.id.recycler_consul);
//        rvConsuldok.setHasFixedSize(true);
//
//        linearLayout = new LinearLayoutManager(getContext());
//
//        rvConsuldok.setLayoutManager(linearLayout);
//        adapter = new GridDoctorAdapter(getContext(), listDataDok);
//        rvConsuldok.setAdapter(adapter);

        return view;
    }
    
//    btnBack.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            finish();
//        }
//    });

}
