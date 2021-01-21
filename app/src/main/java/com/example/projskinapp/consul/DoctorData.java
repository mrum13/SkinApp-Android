package com.example.projskinapp.consul;

import com.example.projskinapp.R;

import java.util.ArrayList;
import java.util.Collection;

public class DoctorData {
    private static String[] doctorNames= {
            "Dr. Stella",
            "Dr. B",
    };



    private static String[] doctorSpecialis = {
            "Kulit - Jakarta",
            "Kulit - Jawa."
    };

    private static int[] doctorImages = {
            R.drawable.doka,
            R.drawable.doka
    };

    static ArrayList<ViewModelDoctor> getListData() {
        ArrayList<ViewModelDoctor> list = new ArrayList<>();
        for (int position = 0; position < doctorNames.length; position++) {
            ViewModelDoctor hero = new ViewModelDoctor();
            hero.setDoctorNames(doctorNames[position]);
            hero.setDoctorSpecialis(doctorSpecialis[position]);
            hero.setDoctorImages(doctorImages[position]);
            list.add(hero);
        }
        return list;
    }


}
