package com.example.saveme;

public class listBencana {
    public String judul;
    public String bencana;
    public String lokasi;
    public String waktu;
    public String deskripsi;
    public String gambar;
    public String nama;

    public listBencana(String judul, String bencana, String lokasi, String waktu, String deskripsi, String gambar, String nama) {
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
}


