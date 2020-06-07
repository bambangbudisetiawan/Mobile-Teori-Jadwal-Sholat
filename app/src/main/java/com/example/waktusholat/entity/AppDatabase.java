package com.example.waktusholat.entity;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {DataCatatan.class} , version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CatatanDao dao();
    private static AppDatabase appDatabase;

    public static AppDatabase iniDb(Context context){
        if(appDatabase == null)
            appDatabase = Room.databaseBuilder(context, AppDatabase.class,
                "userdb").allowMainThreadQueries().build();

        return appDatabase;
    }
}
