package com.example.saveme;

import android.os.Parcel;
import android.os.Parcelable;

public class Bencana implements Parcelable {
    public String judul;
    public String bencana;
    public String lokasi;
    public String waktu;
    public String deskripsi;
    public String gambar;
    public String nama;

    public Bencana(String judul, String bencana, String lokasi, String waktu, String deskripsi, String gambar, String nama) {
        this.judul = judul;
        this.lokasi = lokasi;
        this.waktu = waktu;
        this.gambar = gambar;
        this.nama = nama;
        this.bencana = bencana;
        this.deskripsi = deskripsi;
    }

    public String getBencana() {
        return bencana;
    }

    public void setBencana(String bencana) {
        this.bencana = bencana;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    protected Bencana(Parcel in) {
        judul = in.readString();
        bencana = in.readString();
        lokasi = in.readString();
        waktu = in.readString();
        deskripsi = in.readString();
        gambar = in.readString();
        nama = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(judul);
        dest.writeString(bencana);
        dest.writeString(lokasi);
        dest.writeString(waktu);
        dest.writeString(deskripsi);
        dest.writeString(gambar);
        dest.writeString(nama);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Bencana> CREATOR = new Parcelable.Creator<Bencana>() {
        @Override
        public Bencana createFromParcel(Parcel in) {
            return new Bencana(in);
        }

        @Override
        public Bencana[] newArray(int size) {
            return new Bencana[size];
        }
    };
}