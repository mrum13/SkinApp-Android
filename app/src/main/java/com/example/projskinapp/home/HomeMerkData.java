package com.example.projskinapp.home;

import com.example.projskinapp.R;

import java.util.ArrayList;

public class HomeMerkData {
    private static String[] homeNames = {
            "Oriflame",
            "RK",
            "Morning Power"
    };

    private static int[] homeImage = {
            R.drawable.foundorif,
            R.drawable.rkcushion,
            R.drawable.morningpower
    };

    static ArrayList<ViewModelHome> getListData() {
        ArrayList<ViewModelHome> list = new ArrayList<>();
        for (int position = 0; position < homeNames.length; position++) {
           ViewModelHome home = new ViewModelHome();
            home.setHomeNames(homeNames[position]);
            home.setHomeImage(homeImage[position]);
            list.add(home);
        }
        return list;
    }
}
