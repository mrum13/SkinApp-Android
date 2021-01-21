package com.example.projskinapp.search;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.projskinapp.R;
import com.example.projskinapp.models.Produk;

import java.util.List;

public class AdapterSearch extends RecyclerView.Adapter<AdapterSearch.viewHolder> {
    List<Produk> list;

    public AdapterSearch(List<Produk> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public AdapterSearch.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_search,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterSearch.viewHolder holder, int position) {
        final Produk produk = list.get(position);
        holder.textView.setText(produk.getNm_prod());

        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher_round);

        Glide.with(holder.itemView.getContext()).load(produk.getGb_prod()).apply(options).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private ImageView imageView;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.tv_card_search);
            imageView = itemView.findViewById(R.id.img_cv_search);
        }
    }
}
