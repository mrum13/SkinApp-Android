package com.example.projskinapp.checkout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.projskinapp.R;

import java.util.ArrayList;

public class GridCheckoutAdapter extends RecyclerView.Adapter<GridCheckoutAdapter.CheckoutViewModel> {
    Context context;
    private ArrayList<ViewModelCheckout> vmc;

    public GridCheckoutAdapter(Context context, ArrayList<ViewModelCheckout> vmc) {
        this.context = context;
        this.vmc = vmc;

    }

    @NonNull
    @Override
    public GridCheckoutAdapter.CheckoutViewModel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate
                (R.layout.cardcheckoutpage_shop,parent,false);
        GridCheckoutAdapter.CheckoutViewModel DOH = new GridCheckoutAdapter.CheckoutViewModel(view);
        return DOH;
    }

    @Override
    public void onBindViewHolder(@NonNull GridCheckoutAdapter.CheckoutViewModel holder, int position) {
        holder.txtnamacheckout.setText(vmc.get(position).getCheckoutNames());
        holder.txtcheckoutharga.setText(vmc.get(position).getCheckoutHarga());
        holder.txtcheckoutwarna.setText(vmc.get(position).getCheckoutWarna());

        Glide.with(context).load(vmc.get(position).getCheckoutImage1()).into(holder.image1);
        Glide.with(context).load(vmc.get(position).getCheckoutImage2()).into(holder.image2);

    }

    @Override
    public int getItemCount() {
        return vmc.size();
    }


    public class CheckoutViewModel extends RecyclerView.ViewHolder {
        private ImageView image1, image2;
        private TextView txtnamacheckout, txtcheckoutharga, txtcheckoutwarna;

        public CheckoutViewModel(@NonNull View itemView) {
            super(itemView);

            image1=itemView.findViewById(R.id.checkfoundorif);
            image2=itemView.findViewById(R.id.closeicon);
            txtnamacheckout=itemView.findViewById(R.id.neww);
            txtcheckoutharga=itemView.findViewById(R.id.usd_999);
            txtcheckoutwarna=itemView.findViewById(R.id.white);
        }
    }
}

