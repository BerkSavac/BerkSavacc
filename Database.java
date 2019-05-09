package com.example.berksavac.androidnet;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {

    public static final String DB_NAME = "local.db";
    public static final int DB_VERSION = 1;

    public static final String Cars_Table = "cars";

    public static final String ID = "id";
    public static final String a_marka= "Arac_markasi";
    public static final String a_model = "Arac_model";
    public static final String a_plaka= "Arac_plaka";
    public static final String a_vergi = "Arac_vergi";
    public static final String a_sigorta = "Arac_sigorta";

    public static final String a_kiralamabitis = "Arac_kiralamabitis";


    public static final String CREATE_Cars_TABLE_ =
            "CREATE TABLE  " + Cars_Table + "(" +
                    ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    a_marka + " TEXT NOT NULL," +
                    a_model + " TEXT,"+
                    a_plaka + "TEXT,"+
                    a_vergi + "TEXT,"+
                    a_sigorta + "TEXT,"+
                    a_kiralamabitis + "TEXT"+" )";




    public Database(Context context) {
        super(context, Cars_Table, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_Cars_TABLE_);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " +Cars_Table);
        this.onCreate(db);
    }
    public void  AracEkle(Arac arac)  {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues degerler = new ContentValues();
        degerler.put(a_marka,arac.ay_marka);
        degerler.put(a_model,arac.ay_model);
        degerler.put(a_plaka,arac.ay_plaka);
        degerler.put(a_sigorta,arac.ay_sigortatarih);
        degerler.put(a_vergi,arac.ay_vergi);
        degerler.put(a_kiralamabitis,arac.ay_kiralamabitis);

        db.insert(Cars_Table,null,degerler);
        db.close();
    }


    public List<Arac> AraclarıGetir(){
        List<Arac> aracs = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + Cars_Table;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Arac arac = new Arac();
                arac.setId(cursor.getInt(cursor.getColumnIndex(String.valueOf(arac.id))));
                arac.setAy_marka(cursor.getString(cursor.getColumnIndex(arac.ay_marka)));
                arac.setAy_model(cursor.getString(cursor.getColumnIndex(arac.ay_model)));

                aracs.add(arac);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return aracs;
    }
    }

