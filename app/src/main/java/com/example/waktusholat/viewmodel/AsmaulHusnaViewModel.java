package com.example.waktusholat.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.waktusholat.asmaulhusna.AsmaulHusnaResponse;
import com.example.waktusholat.asmaulhusna.DataItem;
import com.example.waktusholat.service.ApiMain;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AsmaulHusnaViewModel extends ViewModel {

    private ApiMain apiMain;

    private MutableLiveData<ArrayList<DataItem>> listDiscoverAsmaulHusna = new MutableLiveData<>();

    public void setAsmaulHusnaDiscover(){
        if (this.apiMain == null){
            apiMain = new ApiMain();
        }
        apiMain.getApiAsmaulHusna().getAsmaulHusnaDiscover().enqueue(new Callback<AsmaulHusnaResponse>() {
            @Override
            public void onResponse(Call<AsmaulHusnaResponse> call, Response<AsmaulHusnaResponse> response) {
                AsmaulHusnaResponse responseDiscover = response.body();
                if(responseDiscover != null && responseDiscover.getData() != null){
                    ArrayList<DataItem> dataItems = responseDiscover.getData();
                    listDiscoverAsmaulHusna.postValue(dataItems);
                }
            }

            @Override
            public void onFailure(Call<AsmaulHusnaResponse> call, Throwable t) {

            }
        });
    }
    public LiveData<ArrayList<DataItem>> getAsmaulHusnaDiscover(){
        return listDiscoverAsmaulHusna;
    }
}
