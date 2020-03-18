package com.example.tema2;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Users.class}, version=1 ,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public  abstract  UserDao userDao();

    private static AppDatabase instance;


    static AppDatabase getUsersDatabase(Context context)
    {
        if (instance == null)
        {
            instance = Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class,"app_database").build();

        }
        return instance;
    }


}
