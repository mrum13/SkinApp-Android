package com.example.projskinapp.home;

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
import com.example.projskinapp.home.cardmenu.Produkimage;
import com.example.projskinapp.R;

import java.util.ArrayList;

public class GridHomeMerkAdapter extends RecyclerView.Adapter<GridHomeMerkAdapter.HomeViewHolder> {
    Context context;
    private ArrayList<ViewModelHome> vmh;

    public GridHomeMerkAdapter(Context context, ArrayList<ViewModelHome> vmh) {
        this.context = context;
        this.vmh = vmh;
    }

    @NonNull
    @Override
    public GridHomeMerkAdapter.HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardhome,parent,false);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final GridHomeMerkAdapter.HomeViewHolder holder, int position) {
       final ViewModelHome list = vmh.get(position);
       holder.tvMerk.setText(list.getHomeNames());

        Glide.with(holder.itemView.getContext())
                .load(list.getHomeImage())
                .apply(new RequestOptions().override(350, 550))
                  .into(holder.imgPhoto);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kedetail = new Intent(context, Produkimage.class);
                kedetail.putExtra("tvNamaProduk", list.getHomeNames());
                context.startActivity(kedetail);

            }
        });
    }

    @Override
    public int getItemCount() {
        return vmh.size();
    }
    public class HomeViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvMerk;

        public HomeViewHolder (@NonNull View itemView){
            super(itemView);

            imgPhoto = itemView.findViewById(R.id.merkorif);
            tvMerk = itemView.findViewById(R.id.merkskin);

        }
    }
    }
