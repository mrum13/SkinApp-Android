package com.example.projskinapp.models;

import java.util.List;

public class DokterResponse {
    private boolean error;
    private List<Dokter> dokter;

    public DokterResponse(boolean error, List<Dokter> dokter) {
        this.error = error;
        this.dokter = dokter;
    }

    public boolean isError() {
        return error;
    }

    public List<Dokter> getDokter() {
        return dokter;
    }
}
