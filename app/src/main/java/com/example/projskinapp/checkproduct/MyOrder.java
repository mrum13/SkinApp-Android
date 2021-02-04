package com.example.projskinapp.checkproduct;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.projskinapp.R;
import com.example.projskinapp.api.RetrofitClient;
import com.example.projskinapp.models.Dokter;
import com.example.projskinapp.models.DokterResponse;
import com.example.projskinapp.models.User;
import com.example.projskinapp.models.UserResponse;
import com.example.projskinapp.storage.SharedPrefManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyOrder extends Fragment {
    private TextView tvNama,tvTelp,tvAlamat;
    private String user;
    private User[] detailUser;
    private List<User> listUser;
    private ProgressBar progressBar;
    private RecyclerView rvCheck;
    private LinearLayoutManager linearLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_myorder_shop, container, false);

        tvNama = view.findViewById(R.id.nmpengrim);
        tvTelp = view.findViewById(R.id.telp);
        tvAlamat = view.findViewById(R.id.almpengrim);
        progressBar = view.findViewById(R.id.progress_circular);

        showProgressBar();

        User dataUser = SharedPrefManager.getInstance(getActivity()).getUser();
        user = dataUser.getName();

        Call<UserResponse> call = RetrofitClient.getInstance().getApi().getCurrentUser(user);
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                UserResponse userResponse =response.body();
                if (!userResponse.isError()){
                    listUser = response.body().getUser();
                    detailUser = listUser.toArray(new User[0]);
                    tvNama.setText(detailUser[0].getName());
                    tvTelp.setText(detailUser[0].getNope_user());
                    tvAlamat.setText(detailUser[0].getAlamat_user());
                    hideProgressBar();
                }
                else {
//                    Toast.makeText(MyOrder.this, "Data tidak ada",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {

            }
        });

        return view;
    }

    private void showProgressBar(){
        progressBar.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar(){
        progressBar.setVisibility(View.GONE);
    }
}