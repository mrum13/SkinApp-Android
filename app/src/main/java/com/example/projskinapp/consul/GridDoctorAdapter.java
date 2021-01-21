package com.example.projskinapp.consul;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.projskinapp.Activity_Consul;
import com.example.projskinapp.Activity_Profildok;
import com.example.projskinapp.R;
import com.example.projskinapp.home.GridHomeMerkAdapter;
import com.example.projskinapp.models.Dokter;
import com.example.projskinapp.profildoc.FragProfildoc;

import java.util.ArrayList;
import java.util.List;

public class GridDoctorAdapter extends RecyclerView.Adapter<GridDoctorAdapter.DoctorViewModel> {
    private List<Dokter> dataDokter;

    public GridDoctorAdapter(List<Dokter> dataDokter) {
        this.dataDokter = dataDokter;
    }

    @NonNull
    @Override
    public GridDoctorAdapter.DoctorViewModel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate
                (R.layout.cardconsuldoc,parent,false);
        DoctorViewModel DOH = new DoctorViewModel(view);
        return DOH;
    }

    @Override
    public void onBindViewHolder(@NonNull final GridDoctorAdapter.DoctorViewModel holder, int position) {
        final Dokter list = dataDokter.get(position);

        holder.txtnamadok.setText(list.getNm_dok());
        holder.txtspesialis.setText(list.getSpes_dok());
        holder.txtKlinik.setText(list.getKlinik_dok());

        Glide.with(holder.itemView.getContext()).load(list.getGb_dok()).into(holder.img);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent keDetailDokter = new Intent(holder.itemView.getContext(), Activity_Profildok.class);
                keDetailDokter.putExtra("namaDokter", list.getNm_dok());
                holder.itemView.getContext().startActivity(keDetailDokter);
            }
        });

    }

    @Override
    public int getItemCount() {
            return dataDokter.size();
    }

    public class DoctorViewModel extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView txtnamadok,txtspesialis,txtKlinik;
        private FragProfildoc fragment;

        public DoctorViewModel(@NonNull View itemView) {
            super(itemView);

            img=itemView.findViewById(R.id.dokA);
            txtnamadok=itemView.findViewById(R.id.dr_stella);
            txtspesialis=itemView.findViewById(R.id.tv_spesialis);
            txtKlinik=itemView.findViewById(R.id.tv_rumah_sakit);

        }

    }
}
