package com.example.waktusholat.note;

import android.view.View;

import com.example.waktusholat.entity.AppDatabase;
import com.example.waktusholat.entity.DataCatatan;

import java.util.List;

public interface MainContract {
    interface view extends View.OnClickListener{
        void successAdd();
        void successDelete();
        void resetForm();
        void getData(List<DataCatatan> list);
        void editData(DataCatatan item);
        void deleteData(DataCatatan item);
    }

    interface presenter{
        void insertData(String tittle, String note, AppDatabase database);
        void readData(AppDatabase database);
        void editData(String tittle, String note, int id, AppDatabase database);
        void deleteData(DataCatatan dataCatatan, AppDatabase database);
    }
}
