package com.example.berksavac.androidnet;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class UserActivity extends AppCompatActivity {
Context context=this;
ListView listemiz;
List <Arac> list;
Database db=new Database(context);
ArrayAdapter  <String> madapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
    listemiz=(ListView) findViewById(R.id.listemiz);
    db.onUpgrade(db.getWritableDatabase(),1,2);
    db.AracEkle(new Arac("Renult","2018","34Cf2012","600","23.05.2020","23.05.2020"));
        db.AracEkle(new Arac("Renult","2018","34Cf2012","600","23.05.2020","23.05.2020"));
        db.AracEkle(new Arac("Renult","2018","34Cf2012","600","23.05.2020","23.05.2020"));
        db.AracEkle(new Arac("Renult","2018","34Cf2012","600","23.05.2020","23.05.2020"));
        db.AracEkle(new Arac("Renult","2018","34Cf2012","600","23.05.2020","23.05.2020"));
        db.AracEkle(new Arac("Renult","2018","34Cf2012","600","23.05.2020","23.05.2020"));

        list=db.AraclarıGetir();
    List<String> listİsim=new ArrayList<>();
    for (int i=0; i<list.size();i++){
        listİsim.add(i,list.get(i).getAy_model());
    }
    madapter=new ArrayAdapter<String>(context,R.layout.result_model,R.id.listMetin,listİsim);
    }

}