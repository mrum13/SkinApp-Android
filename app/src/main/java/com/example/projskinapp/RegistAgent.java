package com.example.projskinapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class RegistAgent extends AppCompatActivity {
    FirebaseAuth safirebaseAuth;
    FirebaseFirestore fbstore;
    String userID;
    EditText fulname,email,pass,ntelp;
    TextView sigin;
    Button signup;
    ImageView eye;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist_agent);
        fulname = findViewById(R.id.full_name_f);
        email = findViewById(R.id.email_regform);
        pass = findViewById(R.id.password_fo);
        eye=findViewById(R.id.eye);
        ntelp = findViewById(R.id.notelp);
        signup = findViewById(R.id.sign_up_but);
        sigin = (TextView) findViewById(R.id.sign_in);
        safirebaseAuth=FirebaseAuth.getInstance();
        fbstore=FirebaseFirestore.getInstance();

        //        hide pass eye_close
//        eye.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (v.getId() == R.id.eye) {
//                    if (pass.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())) {
//                        //Saat Checkbox dalam keadaan Checked, maka password akan di tampilkan
//                        ((ImageView) (v)).setImageResource(R.drawable.ic_eye);
//                        pass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
//                    } else {
//                        //Jika tidak, maka password akan di sembuyikan
//                        ((ImageView) (v)).setImageResource(R.drawable.ic_eye_off);
//                        pass.setTransformationMethod(PasswordTransformationMethod.getInstance());
//                    }
//                }
//            }
//        });
//
//        signup.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//
//        final String nmlengkap = fulname.getText().toString();
//        final String emailreg = email.getText().toString();
//        final String passreg = pass.getText().toString();
//        final String ntelpreg = ntelp.getText().toString();
//
//        if (TextUtils.isEmpty(nmlengkap))
//        {
//            fulname.setError("is empty");
//            return;
//        }
//        if (TextUtils.isEmpty(emailreg))
//        {
//            email.setError("is empty");
//            return;
//        }
//        if (TextUtils.isEmpty(passreg))
//        {
//            pass.setError("is empty");
//            return;
//        }
//        if (TextUtils.isEmpty(ntelpreg))
//        {
//            pass.setError("is empty");
//            return;
//        }
//
//        userID = Objects.requireNonNull(safirebaseAuth.getCurrentUser()).getUid();
//        DocumentReference documentReference =fbstore.collection("SkinApp").document(userID);
//        Map<String, Object> user = new HashMap<>();
//        user.put("fullname", nmlengkap);
//        user.put("your email", emailreg);
//        user.put("password", passreg);
//        user.put("number phone",ntelpreg);
//
//        fbstore.collection("user").document(userID).collection("SkinApp").document("Kategori_Skincare").set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
//            @Override
//            public void onSuccess(Void aVoid) {
//                Log.d("tag", "DocumentSnapShot Success Upload!");
//            }
//        })
//        .addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                Log.w("tag", "Document Upload Error", e );
//            }
//        });
    }
}