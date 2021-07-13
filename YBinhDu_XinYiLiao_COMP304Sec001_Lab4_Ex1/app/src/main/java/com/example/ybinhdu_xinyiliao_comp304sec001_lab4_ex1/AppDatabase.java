package com.example.ybinhdu_xinyiliao_comp304sec001_lab4_ex1;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Examiner.class, Applicant.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract AppDao appDao();

    //public static AppDatabase appDatabase;


    //public static AppDatabase getDatabase(Context context){
    //    if (appDatabase == null){
    //        return Room.databaseBuilder(context,AppDatabase.class, "AppDB")
    //                .allowMainThreadQueries().build();
    //    }
    //    return appDatabase;
    //}

}
