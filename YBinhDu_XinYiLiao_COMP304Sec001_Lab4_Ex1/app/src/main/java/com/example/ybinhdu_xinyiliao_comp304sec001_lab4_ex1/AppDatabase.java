package com.example.ybinhdu_xinyiliao_comp304sec001_lab4_ex1;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Examiner.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract AppDao appDao();

}
