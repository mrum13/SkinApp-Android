package com.example.projskinapp.home;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.projskinapp.Activity_Consul;
import com.example.projskinapp.Activity_Profildok;
import com.example.projskinapp.R;
import com.example.projskinapp.consul.FragConsul;

import java.util.ArrayList;


public class Frag_Home extends Fragment {
    TextView findurdoc;
    private RecyclerView rvHome;
    private ArrayList<ViewModelHome> listDataHome;
//    private LinearLayoutManager linearLayout;
    private GridHomeMerkAdapter adapter;
    private  Frag_Home myContext;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        listDataHome = new ArrayList<ViewModelHome>();
        listDataHome.addAll(HomeMerkData.getListData());

        rvHome = (RecyclerView)view.findViewById(R.id.rvHome);
        rvHome.setHasFixedSize(true);

//       linearLayout = new LinearLayoutManager(getActivity(),LinearLayoutManager.);

        rvHome.setLayoutManager(new GridLayoutManager(getContext(),2 ));
        adapter = new GridHomeMerkAdapter(getContext(),listDataHome);
        rvHome.setAdapter(adapter);

        // FindUrDoctor
        findurdoc = view.findViewById(R.id.find_your_d);
        findurdoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent keDokter = new Intent(getActivity(), Activity_Consul.class);
                startActivity(keDokter);
            }
        });

        return view;
    }


}