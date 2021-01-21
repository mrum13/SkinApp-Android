package com.example.projskinapp.consul;

public class ViewModelDoctor {
    public ViewModelDoctor() {
        this.doctorNames = doctorNames;
        this.doctorSpecialis = doctorSpecialis;
        this.doctorImages = doctorImages;
    }

    String doctorNames, doctorSpecialis;

    int doctorImages ;

    public String getDoctorNames() {
        return doctorNames;
    }

    public void setDoctorNames(String doctorNames) {
        this.doctorNames = doctorNames;
    }

    public String getDoctorSpecialis() {
        return doctorSpecialis;
    }

    public void setDoctorSpecialis(String doctorSpecialis) {
        this.doctorSpecialis = doctorSpecialis;
    }

    public int getDoctorImages() {
        return doctorImages;
    }

    public void setDoctorImages(int doctorImages) {
        this.doctorImages = doctorImages;
    }
}
