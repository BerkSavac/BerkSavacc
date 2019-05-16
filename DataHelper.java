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
        String sql = "create table arac(no integer primary key, nama text null, birthday text null, jk text null, alamat text null);";
        Log.d("Data", "onCreate: " + sql);
        db.execSQL(sql);

        sql = "INSERT INTO arac(no, nama, birthday, jk, alamat) VALUES ('1', 'MacTavish', '1987-05-17', 'L', 'Scotland');";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}