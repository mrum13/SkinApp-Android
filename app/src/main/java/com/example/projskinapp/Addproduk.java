package com.example.projskinapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Addproduk extends AppCompatActivity {
    FirebaseAuth safirebaseAuth;
    FirebaseFirestore fbstore;
    StorageReference storageReference;

    ImageView upload;
    Button addproduk;
    EditText nmproduk, descproduk, price, kategori;
    TextView keterangan;
    String productRandomKey, userid, downloadImageUrl, saveCurrentDate, saveCurrentTime;
    private Uri imageUri = null;
    private ProgressDialog loadingBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addproduk_t);

        safirebaseAuth = FirebaseAuth.getInstance();
        fbstore = FirebaseFirestore.getInstance();
        userid = safirebaseAuth.getCurrentUser().getUid();
        storageReference = FirebaseStorage.getInstance().getReference();

        loadingBar = new ProgressDialog(this);
        addproduk = findViewById(R.id.btn_addproduk);
        nmproduk = findViewById(R.id.nmprod);
        descproduk = findViewById(R.id.descprod);
        price = findViewById(R.id.harga);
        upload = findViewById(R.id.btn_image1);
        kategori = findViewById(R.id.kategori);

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (ContextCompat.checkSelfPermission(Addproduk.this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                        Toast.makeText(Addproduk.this, "Permission Danied", Toast.LENGTH_LONG).show();
                        ActivityCompat.requestPermissions(Addproduk.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
                    } else {
                        OpenGallery();
                    }
                } else {
                    OpenGallery();
                }
            }
        });

        addproduk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValidateProductData();
            }
        });
    }

    private void ValidateProductData() {
        final String nm_Vprodukd = nmproduk.getText().toString();
        final String descVprod = descproduk.getText().toString();
        final String hrgV = price.getText().toString();
        final String kategorV = kategori.getText().toString();

        if (imageUri == null) {
            Toast.makeText(this, "Maaf upload produk kosong", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(nm_Vprodukd)) {
            keterangan.setText("Maaf nama produk kosong");
            nmproduk.setError("");
            return;
        } else if (TextUtils.isEmpty(descVprod)) {
            keterangan.setText("Maaf deskripsi produk kosong");
            descproduk.setError("");
            return;
        } else if (TextUtils.isEmpty(hrgV)) {
            keterangan.setText("Maaf harga produk kosong");
            price.setError("");
            return;
        } else if (TextUtils.isEmpty(kategorV)) {
            keterangan.setText("Maaf kategori produk kosong");
            kategori.setError("");
            return;
        } else {
            loadingBar.setTitle("Proses");
            loadingBar.setMessage("Proses penambahan data");
            loadingBar.setCanceledOnTouchOutside(false);
            loadingBar.show();

            Calendar calendar = Calendar.getInstance();

            SimpleDateFormat currentDate = new SimpleDateFormat("MMM dd, yyyy");
            saveCurrentDate = currentDate.format(calendar.getTime());

            SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm:ss a");
            saveCurrentTime = currentTime.format(calendar.getTime());
            productRandomKey = saveCurrentDate + saveCurrentTime;
            final StorageReference filePath = storageReference.child(imageUri.getLastPathSegment() + productRandomKey + ".jpg");
            final UploadTask uploadTask = filePath.putFile(imageUri);
            uploadTask.addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                    String message = e.toString();
                    Toast.makeText(Addproduk.this, "Error: " + message, Toast.LENGTH_SHORT).show();
                    loadingBar.dismiss();
                }
            }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Toast.makeText(Addproduk.this, "Product success upload...", Toast.LENGTH_SHORT).show();

                    Task<Uri> urlTask = uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>()
                    {
                        @Override
                        public Task<Uri> then(@io.reactivex.annotations.NonNull Task<UploadTask.TaskSnapshot> task) throws Exception
                        {
                            if (!task.isSuccessful())
                            {
                                throw task.getException();
                            }

                            downloadImageUrl = task.getResult().toString();
                            return filePath.getDownloadUrl();
                        }
                    }).addOnCompleteListener(new OnCompleteListener<Uri>()
                    {
                        @Override
                        public void onComplete(@io.reactivex.annotations.NonNull Task<Uri> task)
                        {
                            if (task.isSuccessful())
                            {
                                downloadImageUrl = task.getResult().toString();

                                Toast.makeText(Addproduk.this, "got the Product image Url Successfully...", Toast.LENGTH_SHORT).show();


                                Map<String, String> userData = new HashMap<>();
                                userData.put("Nama Produk", nm_Vprodukd);
                                userData.put("Deskripsi Produk", descVprod);
                                userData.put("Harga", hrgV);
                                userData.put("Kategori", kategorV);
                                userData.put("Foto Produk", downloadImageUrl);

                                fbstore.collection("SkinApp").document(userid).collection("Produk").document().set(userData).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            Toast.makeText(Addproduk.this, "User Data is Stored Successfully", Toast.LENGTH_LONG).show();
                                            Intent mainIntent = new Intent(Addproduk.this, Addproduk.class);
                                            startActivity(mainIntent);
                                            finish();
                                        } else {
                                            String error = task.getException().getMessage();
                                            Toast.makeText(Addproduk.this, "(FIRESTORE Error) : " + error, Toast.LENGTH_LONG).show();
                                        }
                                    }
                                });
                            }
                        }
                    });
                }
            });
        }
    }

    private void OpenGallery() {
        CropImage.activity()
                .setGuidelines(CropImageView.Guidelines.ON)
                .setAspectRatio(1, 1)
                .start(Addproduk.this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {

                imageUri = result.getUri();
                upload.setImageURI(imageUri);


            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {

                Exception error = result.getError();

            }
        }
    }

}