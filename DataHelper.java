package com.arif_ginanjar.lesson5crudsqllite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;



public class DataHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "aracTablom.db";
    private static final int DATABASE_VERSION = 1;

    public DataHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table arac(no integer primary key, nama text null, birthday text null, jk text null, alamat text null);";asda
        Log.d("Data", "onCreate: " + sql);
        db.execSQL(sql);

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
