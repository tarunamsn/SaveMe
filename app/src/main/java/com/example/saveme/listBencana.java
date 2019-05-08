package com.example.saveme;

public class listBencana {
    public String judul;
    public String lokasi;
    public String waktu;
    public Byte gambar;
    public String id;

    public listBencana(String judul, String lokasi, String waktu, Byte gambar, String id) {
        this.judul = judul;
        this.lokasi = lokasi;
        this.waktu = waktu;
        this.gambar = gambar;
        this.id = id;
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

    public Byte getGambar() {
        return gambar;
    }

    public void setGambar(Byte gambar) {
        this.gambar = gambar;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}


