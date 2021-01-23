package com.example.projskinapp.home.cardmenu.adaptermenu;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.projskinapp.Productpage;
import com.example.projskinapp.R;
import com.example.projskinapp.home.cardmenu.Produkimage;
import com.example.projskinapp.home.cardmenu.viewmodelmenu.ViewModelMenuSkincare;
import com.example.projskinapp.models.Dokter;
import com.example.projskinapp.models.Produk;

import java.util.ArrayList;
import java.util.List;

public class AdapterMenuSkincare extends RecyclerView.Adapter<AdapterMenuSkincare.ViewHolder> {
    private List<Produk> list;
    private String kategori;

    public AdapterMenuSkincare(List<Produk> list, String kategori) {
        this.list = list;
        this.kategori = kategori;
    }

    @NonNull
    @Override
    public AdapterMenuSkincare.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardprodukimage, parent, false);
       return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final AdapterMenuSkincare.ViewHolder holder, int position) {
        final Produk data = list.get(position);

        Glide.with(holder.itemView.getContext())
                .load(data.getGb_prod())
                .apply(new RequestOptions())
                .into(holder.img);
        holder.tv.setText(data.getNm_prod());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent keDetailProduk = new Intent(holder.itemView.getContext(), Productpage.class);
                keDetailProduk.putExtra("nama_produk", data.getNm_prod());
                holder.itemView.getContext().startActivity(keDetailProduk);
                ((Produkimage)holder.itemView.getContext()).finish();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView tv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.img_cardorif);
            tv = itemView.findViewById(R.id.tv_card_menu_bawah);
        }
    }
}
