package com.example.projskinapp.home.cardmenu.datamenu;

import com.example.projskinapp.R;
import com.example.projskinapp.home.cardmenu.viewmodelmenu.ViewModelMenuSkincare;

import java.util.ArrayList;

public class DataMenuSkincare {
    private static int[] gambarOriflame = {
            R.drawable.foundorif,
            R.drawable.lipbalmorif,
            R.drawable.orbedak,
            R.drawable.ormasker,
            R.drawable.eyebrowkitorif,
            R.drawable.eyeshadoworif,
            R.drawable.creamniteorif


    };

    private static String[] judulOriflame = {
            "Foundation",
            "Lipbalm",
            "Illuskin Powder",
            "Love Nature Mask",
            "The One Eyebrow Kit",
            "Eye Shadow",
            "Cream Night"


    };

    private static int[] gambarRK = {
            R.drawable.rkcushion,
            R.drawable.rk_cushion2,
            R.drawable.rk_glow,
            R.drawable.rk_hb,
            R.drawable.rk_jl1,
            R.drawable.rk_lipmate,
            R.drawable.rk_liptint,
            R.drawable.rk_scrub2,
            R.drawable.rk_treatment,
            R.drawable.rk_vit


    };

    private static String[] judulRK = {
            "Cushion",
            "RK Cushion",
            "RK Glow",
            "Beauty Lotion",
            "Red Jelly",
            "RK Lipmatte",
            "RK Liptint",
            "Beauty Scrub",
            "RK Glow Treatment",
            "RK Vit Slimming Collagen"


    };

    private static int[] gambarPowerMor = {
            R.drawable.morningpower,


    };

    private static String[] judulPowerMor = {
            "Morning Power"

    };

    public static ArrayList<ViewModelMenuSkincare> getListDataOriflame() {
        ArrayList<ViewModelMenuSkincare> list = new ArrayList<>();
        for (int position = 0; position < gambarOriflame.length; position++) {
            ViewModelMenuSkincare model = new ViewModelMenuSkincare();
            model.setGambarMenuSkincare(gambarOriflame[position]);
            model.setTvMeneSc(judulOriflame[position]);
            list.add(model);
        }
        return list;
    }

    public static ArrayList<ViewModelMenuSkincare> getListDataRK() {
        ArrayList<ViewModelMenuSkincare> list = new ArrayList<>();
        for (int position = 0; position < gambarRK.length; position++) {
            ViewModelMenuSkincare model = new ViewModelMenuSkincare();
            model.setGambarMenuSkincare(gambarRK[position]);
            model.setTvMeneSc(judulRK[position]);
            list.add(model);
        }
        return list;
    }

    public static ArrayList<ViewModelMenuSkincare> getListDataPowerMor() {
        ArrayList<ViewModelMenuSkincare> list = new ArrayList<>();
        for (int position = 0; position < gambarPowerMor.length; position++) {
            ViewModelMenuSkincare model = new ViewModelMenuSkincare();
            model.setGambarMenuSkincare(gambarPowerMor[position]);
            model.setTvMeneSc(judulPowerMor[position]);
            list.add(model);
        }
        return list;
    }
}
