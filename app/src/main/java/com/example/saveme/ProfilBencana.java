package com.example.saveme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfilBencana extends AppCompatActivity {
    ImageView ImageView;
    TextView judul, lokasi, waktu, id, bencana;
    int imageView3;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Intent intent = getIntent();
        Bencana Bencana = intent.getParcelableExtra("objek");
        judul = findViewById(R.id.txJudul);
        bencana = findViewById(R.id.txBencana);
        lokasi = findViewById(R.id.txLokasi);
        waktu = findViewById(R.id.txWaktu);
        id = findViewById(R.id.txNama);

        judul.setText(Bencana.getJudul());
        bencana.setText(Bencana.getBencana());
        lokasi.setText(Bencana.getLokasi());
        waktu.setText(Bencana.getWaktu());
        id.setText(Bencana.getNama());
    }
}
