package com.example.waktusholat.service;

import com.example.waktusholat.waktusholat.WaktuSholatResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WaktuSholatRepository {
    @GET("v1/calendarByAddress?address=Sultanahmet Mosque, Istanbul, Turki & metode = 2 & bulan = 04 & tahun = 2017")
    Call<WaktuSholatResponse> getWaktuSholatDiscover();
}
