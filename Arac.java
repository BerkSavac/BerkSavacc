package com.example.berksavac.androidnet;

public class Arac {
    int id;
    String ay_marka;

    public Arac() {
    }

    public Arac(String ay_marka, String ay_model, String ay_plaka, String ay_sigortatarih, String ay_vergi, String ay_kiralamabitis) {
    this.ay_marka=ay_marka;
    this.ay_model=ay_model;
    this.ay_plaka=ay_plaka;
    this.ay_sigortatarih=ay_sigortatarih;
    this.ay_vergi=ay_vergi;
    this.ay_kiralamabitis=ay_kiralamabitis;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAy_marka() {
        return ay_marka;
    }

    public void setAy_marka(String ay_marka) {
        this.ay_marka = ay_marka;
    }

    public String getAy_model() {
        return ay_model;
    }

    public void setAy_model(String ay_model) {
        this.ay_model = ay_model;
    }

    public String getAy_plaka() {
        return ay_plaka;
    }

    public void setAy_plaka(String ay_plaka) {
        this.ay_plaka = ay_plaka;
    }

    public String getAy_vergi() {
        return ay_vergi;
    }

    public void setAy_vergi(String ay_vergi) {
        this.ay_vergi = ay_vergi;
    }

    public String getAy_sigortatarih() {
        return ay_sigortatarih;
    }

    public void setAy_sigortatarih(String ay_sigortatarih) {
        this.ay_sigortatarih = ay_sigortatarih;
    }

    public String getAy_kiralamabitis() {
        return ay_kiralamabitis;
    }

    public void setAy_kiralamabitis(String ay_kiralamabitis) {
        this.ay_kiralamabitis = ay_kiralamabitis;
    }

    String ay_model;
    String ay_plaka;
    String ay_vergi;
    String ay_sigortatarih;
    String ay_kiralamabitis;



}
