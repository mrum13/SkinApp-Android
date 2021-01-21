package com.example.projskinapp.search;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projskinapp.R;
import com.example.projskinapp.api.RetrofitClient;
import com.example.projskinapp.models.Produk;
import com.example.projskinapp.models.ProdukResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragsearch extends Fragment {
    private RecyclerView rvCari;
    private List<Produk> listProduk;
    private LinearLayoutManager linearLayoutManager;
    private String produk;
    private EditText etCari;
    private AdapterSearch adapterSearch;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragsearch_src, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        inisialisasiObjek(view);
    }

    private void inisialisasiObjek(@NonNull View view){
        rvCari = view.findViewById(R.id.rv_cari);
        etCari = view.findViewById(R.id.background);

        etCari.setOnEditorActionListener(editorActionListener);
    }

    private TextView.OnEditorActionListener editorActionListener =new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            switch (actionId) {
                case EditorInfo.IME_ACTION_SEND:
                    Toast.makeText(getActivity(), "Mencari", Toast.LENGTH_SHORT).show();
//                    shimmerPencarian.startShimmer(); //start Shimmer animation of shimmer
                    break;
            }
            produk = etCari.getText().toString().trim();
            rvCari.setHasFixedSize(true);
            linearLayoutManager = new LinearLayoutManager(getActivity());
            rvCari.setLayoutManager(linearLayoutManager);

            Call<ProdukResponse> call = RetrofitClient.getInstance().getApi().searchProduk(produk);
            call.enqueue(new Callback<ProdukResponse>() {
                @Override
                public void onResponse(Call<ProdukResponse> call, Response<ProdukResponse> response) {

                    ProdukResponse produkResponse =response.body();

                    if (!produkResponse.isError()){
                        listProduk = response.body().getProduk();
                        if (!listProduk.isEmpty()){
                            adapterSearch = new AdapterSearch(listProduk);
                            rvCari.setAdapter(adapterSearch);
                        }
                        else {
                            Toast.makeText(getActivity(), "Data tidak ditemukan",Toast.LENGTH_LONG).show();
                        }


                    }
                    else {
                        Toast.makeText(getActivity(), "Data tidak ditemukan",Toast.LENGTH_LONG).show();
                    }


                }

                @Override
                public void onFailure(Call<ProdukResponse> call, Throwable t) {

                }
            });
            return false;
        }
    };
}