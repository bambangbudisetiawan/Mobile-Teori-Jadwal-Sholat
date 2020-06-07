package com.example.waktusholat.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiMain {
    private Retrofit retrofit;

    public WaktuSholatRepository getApiWaktuSholat(){
        String BASE_URL = "https://api.aladhan.com/";
        if (retrofit == null){
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(WaktuSholatRepository.class);
    }

    public AsmaulHusnaRepository getApiAsmaulHusna(){
        String BASE_URL = "https://api.aladhan.com/";
        if (retrofit == null){
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(AsmaulHusnaRepository.class);
    }

    //kalau mau nambah disini
    //public WAKJADA
}
