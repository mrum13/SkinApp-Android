package com.example.projskinapp.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.projskinapp.Addproduk;
import com.example.projskinapp.login.LoginActivity;
import com.example.projskinapp.R;
import com.example.projskinapp.RegistAgent;
import com.example.projskinapp.models.User;
import com.example.projskinapp.storage.SharedPrefManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;


public class FragmentAccount extends Fragment {

    Button signout, reg4agen, Order;
    FirebaseAuth FSignauth;
    String UserId;

    TextView user;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    //  i   nflate
        View view = inflater.inflate(R.layout.fragment_account, container, false);

        signout = view.findViewById(R.id.signout);
        reg4agen = view.findViewById(R.id.reg4agent);
        Order = view.findViewById(R.id.orders);
        user = view.findViewById(R.id.username);

        //nama dan email berdasarkan data login
        User dataUser = SharedPrefManager.getInstance(getActivity()).getUser();
        user.setText(dataUser.getName());
//        tv_email.setText(user.getEmail());

        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signout();
            }
        });

        reg4agen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kereges = new Intent(getActivity(), RegistAgent.class);
                startActivity(kereges);
            }
        });

        Order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent order = new Intent(getActivity(), Addproduk.class);
                startActivity(order);
            }
        });

        return view;
    }

    private void signout()
    {
        SharedPrefManager.getInstance(getActivity()).clear();
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}

//    btn_return,btn_accountinfo,btn_help;
//    CircleImageView image;
//    TextView username,tipemember;
//    FirebaseAuth fAuth;
//    FirebaseFirestore fStore;
//    String userid;
//    StorageReference storageReference;
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.fragment_account);
//
//        btn_order=findViewById(R.id.orders);
//        btn_keluar=findViewById(R.id.signout);
//        btn_return=findViewById(R.id.returns);
//        btn_accountinfo=findViewById(R.id.help)
//        username=findViewById(R.id.username);
//        tipemember=findViewById(R.id.tipeanggota);
//        image=findViewById(R.id.item_photo);
//
//        // Database
//        fAuth = FirebaseAuth.getInstance();
//        fStore = FirebaseFirestore.getInstance();
//        userid = fAuth.getCurrentUser().getUid();
//        storageReference = FirebaseStorage.getInstance().getReference();
//        // --------------------------------------------------------------
//
//        DocumentReference documentReference = fStore.collection("users").document(userid);
//        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
//            @Override
//            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
//                if(documentSnapshot.exists()){
//                    username.setText(documentSnapshot.getString("username"));
//                    tipemember.setText(documentSnapshot.getString("tipeanggota"));
//
//
//                }else {
//                    Log.d("tag", "onEvent: Document do not exists");
//                }
//            }
//        });
//
//        btn_keluar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v)
//            {
//                FirebaseAuth.getInstance().signOut();
//                startActivity(new Intent(getApplicationContext(), MainActivity.class));
//                finish();
//            }
//        });
//
//        StorageReference profileRef = storageReference.child("users/"+fAuth.getCurrentUser().getUid()+"/profile.jpg");
//        profileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
//            @Override
//            public void onSuccess(Uri uri) {
//                Picasso.get().load(uri).into(image);
//            }
//        });
//
//        image.setOnClickListener(new View.OnClickListener() {
//            @Override
////            public void onClick(View v)
//            {
//                Intent openGalleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                startActivityForResult(openGalleryIntent,1000);
//            }
//        });
//
//
//    }
//
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @androidx.annotation.Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if(requestCode == 1000){
//            if(resultCode == Activity.RESULT_OK){
//                Uri imageUri = data.getData();
//
//                //profileImage.setImageURI(imageUri);
//
//                uploadImageToFirebase(imageUri);
//
//
//            }
//        }
//
//    }
//
//    private void uploadImageToFirebase(Uri imageUri) {
//        // uplaod image to firebase storage
//        final StorageReference fileRef = storageReference.child("users/"+fAuth.getCurrentUser().getUid()+"/profile.jpg");
//        fileRef.putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//            @Override
//            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                fileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
//                    @Override
//                    public void onSuccess(Uri uri) {
//                        Picasso.get().load(uri).into(image);
//                    }
//                });
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                Toast.makeText(getApplicationContext(), "Failed.", Toast.LENGTH_SHORT).show();
//            }
//        });
//
////    }
//
//}
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_account, container, false);
//    }
//}