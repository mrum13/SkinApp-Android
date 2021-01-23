package com.example.projskinapp.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projskinapp.Forgotpass;
import com.example.projskinapp.R;
import com.example.projskinapp.Registerform;
import com.example.projskinapp.api.RetrofitClient;
import com.example.projskinapp.home.Home;
import com.example.projskinapp.models.LoginResponse;
import com.example.projskinapp.storage.SharedPrefManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    TextView forgot_pass, register;
    Button masuk;
    private EditText mail, pass;
    ImageView eye;
    private String email,password;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mail=findViewById(R.id.email_form);
        pass=findViewById(R.id.pass_form);
        eye=findViewById(R.id.eye);
        progressBar = findViewById(R.id.progress_circular);
        progressBar.setVisibility(View.GONE);

        // forgot_pass
        forgot_pass = (TextView) findViewById(R.id.forgot_pass);
        forgot_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent forgot  = new Intent(LoginActivity.this, Forgotpass.class);
                startActivity(forgot);
            }
        });

        // hide pass eye_close
        eye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.eye) {
                    if (pass.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())) {
                        //Saat Checkbox dalam keadaan Checked, maka password akan di tampilkan
                        ((ImageView) (v)).setImageResource(R.drawable.ic_eye);
                        pass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    } else {
                        //Jika tidak, maka password akan di sembuyikan
                        ((ImageView) (v)).setImageResource(R.drawable.ic_eye_off);
                        pass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    }
                }
            }
        });

        // Masuk
        masuk = (Button) findViewById(R.id.sign_in_but);
        masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                email = mail.getText().toString();
                password =pass.getText().toString();

                Call<LoginResponse> call = RetrofitClient.getInstance().getApi().userLogin(email,password);
                call.enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        LoginResponse loginResponse =response.body();
                        if (!loginResponse.isError()){
                            progressBar.setVisibility(View.GONE);
                            SharedPrefManager.getInstance(LoginActivity.this).saveUser(loginResponse.getUser());
                            Toast.makeText(LoginActivity.this, "Login Berhasil",Toast.LENGTH_SHORT).show();

                            Intent keHome = new Intent(LoginActivity.this, Home.class);
                            keHome.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(keHome);
                        }
                        else {
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(LoginActivity.this, loginResponse.getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(LoginActivity.this, "Gagal Koneksi",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        // Register
        register = (TextView) findViewById(R.id.dont_reg_);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regis = new Intent(LoginActivity.this, Registerform.class);
                startActivity(regis);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(SharedPrefManager.getInstance(this).isLoggedIn()){
            Intent intent = new Intent(this, Home.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }
}