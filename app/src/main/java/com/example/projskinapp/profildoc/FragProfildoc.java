package com.example.projskinapp.profildoc;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.projskinapp.R;

public class FragProfildoc extends Fragment {
    ImageView btnBack;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_frag_profildoc_hm, container, false);

        btnBack = root.findViewById(R.id.back_icon1);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });

        Bundle bundle = this.getArguments();
        String data = bundle.getString("key");

        TextView tvNama = root.findViewById(R.id.dr_stella_k);

        tvNama.setText(data);
        return root;
    }
}