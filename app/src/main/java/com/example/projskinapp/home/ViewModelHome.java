package com.example.projskinapp.home;

public class ViewModelHome {
    private String homeNames;
    private int homeImage;


    public String getHomeNames() {
        return homeNames;
    }

    public void setHomeNames(String homeNames) {
        this.homeNames = homeNames;
    }

    public int getHomeImage() {
        return homeImage;
    }

    public void setHomeImage(int homeImage) {
        this.homeImage = homeImage;
    }

    public ViewModelHome() {
        this.homeNames = homeNames;
        this.homeImage = homeImage;
    }
}
