package com.example.waktusholat.entity;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CatatanDao {
    @Insert
    Long insertData(DataCatatan dataCatatan);

    @Query("Select * from userdb")
    List<DataCatatan> getData();

    @Update
    int updateData(DataCatatan item);

    @Delete
    void deleteData(DataCatatan item);
}
