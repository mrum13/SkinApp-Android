package com.example.projskinapp.models;

public class Dokter {
    private String nm_dok,spes_dok,klinik_dok,nope_dok,about_dok,schedule_dok,gb_dok;

    public Dokter(String nm_dok, String spes_dok, String klinik_dok, String nope_dok, String about_dok, String schedule_dok, String gb_dok) {
        this.nm_dok = nm_dok;
        this.spes_dok = spes_dok;
        this.klinik_dok = klinik_dok;
        this.nope_dok = nope_dok;
        this.about_dok = about_dok;
        this.schedule_dok = schedule_dok;
        this.gb_dok = gb_dok;
    }

    public String getNm_dok() {
        return nm_dok;
    }

    public String getSpes_dok() {
        return spes_dok;
    }

    public String getKlinik_dok() {
        return klinik_dok;
    }

    public String getNope_dok() {
        return nope_dok;
    }

    public String getAbout_dok() {
        return about_dok;
    }

    public String getSchedule_dok() {
        return schedule_dok;
    }

    public String getGb_dok() {
        return gb_dok;
    }
}
