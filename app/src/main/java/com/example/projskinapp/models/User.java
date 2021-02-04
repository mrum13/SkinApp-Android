package com.example.projskinapp.models;

public class User {
    private int id;
    private String email,name,alamat_user,kodepos_user,nope_user;

    public User(int id, String email, String name, String alamat_user, String kodepos_user, String nope_user) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.alamat_user = alamat_user;
        this.kodepos_user = kodepos_user;
        this.nope_user = nope_user;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getAlamat_user() {
        return alamat_user;
    }

    public String getKodepos_user() {
        return kodepos_user;
    }

    public String getNope_user() {
        return nope_user;
    }
}
