package com.devjurnal.firebasedncc;

/**
 * Created by DevJurnal on 2/6/18.
 */

public class AnggotaModel {
    String id_anggota;
    String nama;
    String alamat;
    String jns_kelamin;

    public AnggotaModel() {
    }



    public AnggotaModel(String id_anggota, String nama, String alamat, String jns_kelamin) {
        this.id_anggota = id_anggota;
        this.nama = nama;
        this.alamat = alamat;
        this.jns_kelamin = jns_kelamin;
    }

    public String getId_anggota() {
        return id_anggota;
    }

    public void setId_anggota(String id_anggota) {
        this.id_anggota = id_anggota;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getJns_kelamin() {
        return jns_kelamin;
    }

    public void setJns_kelamin(String jns_kelamin) {
        this.jns_kelamin = jns_kelamin;
    }
}
