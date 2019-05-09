package com.example.saveme;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfilBencana extends AppCompatActivity {
    ImageView ImageView;
    TextView judul, lokasi, waktu, id, deskripsi, bencana;
    int imageView3;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Intent intent = getIntent();
        listBencana listBencana = intent.getParcelableExtra("objek");
        judul = findViewById(R.id.txJudul);
        bencana = findViewById(R.id.txBencana);
        lokasi = findViewById(R.id.txLokasi);
        waktu = findViewById(R.id.txtWaktu);
        id = findViewById(R.id.txNama);
        deskripsi = findViewById(R.id.txDeskripsi);

        bencana.setText(listBencana.getBencana());
        judul.setText(listBencana.getJudul());
        lokasi.setText(listBencana.getLokasi());
//        waktu.setText(listBencana.getWaktu());
        id.setText(listBencana.getNama());
        deskripsi.setText(listBencana.getDeskripsi());
    }
}
