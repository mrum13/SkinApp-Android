package com.example.projskinapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.projskinapp.api.RetrofitClient;
import com.example.projskinapp.login.LoginActivity;
import com.example.projskinapp.models.DefaultResponse;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Registerform extends AppCompatActivity {
    String userID;
    EditText fulname,email,pass,ntelp;
    TextView sigin;
    Button signup;
    ImageView eye;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerform);
        fulname = findViewById(R.id.full_name_f);
        email = findViewById(R.id.email_regform);
        pass = findViewById(R.id.password_fo);
        eye=findViewById(R.id.eye);
        ntelp = findViewById(R.id.notelp);
        signup = findViewById(R.id.sign_up_but);

        //hide pass eye_close
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


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String nmlengkap = fulname.getText().toString();
                final String emailreg = email.getText().toString();
                final String passreg = pass.getText().toString();
                final String ntelpreg = ntelp.getText().toString();

                if (TextUtils.isEmpty(nmlengkap))
                {
                    fulname.setError("is empty");
                    return;
                }
                if (TextUtils.isEmpty(emailreg))
                {
                    email.setError("is empty");
                    return;
                }
                if (TextUtils.isEmpty(passreg))
                {
                    pass.setError("is empty");
                    return;
                }
                if (TextUtils.isEmpty(ntelpreg))
                {
                    pass.setError("is empty");
                    return;
                }

                Call<DefaultResponse> call= RetrofitClient.getInstance().getApi().createUser(emailreg,passreg,nmlengkap,ntelpreg);
                call.enqueue(new Callback<DefaultResponse>() {
                    @Override
                    public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                        if(response.code()==201){
                            DefaultResponse dr = response.body();
                            Toast.makeText(Registerform.this, dr.getMsg(),Toast.LENGTH_LONG).show();
                            startActivity(new Intent(Registerform.this, LoginActivity.class));
                        }
                        else if (response.code()==422){
                            Toast.makeText(Registerform.this,"Pengguna sudah ada",Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<DefaultResponse> call, Throwable t) {
                        Toast.makeText(Registerform.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        //        SignIn
        sigin = (TextView) findViewById(R.id.sign_in);
        sigin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sigin = new Intent(Registerform.this, LoginActivity.class);
                startActivity(sigin);
            }
        });
    }
}