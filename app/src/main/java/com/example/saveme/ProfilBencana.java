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
    TextView judul, lokasi, waktu, id;
    int imageView3;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Intent intent = getIntent();
        listBencana listBencana = intent.getParcelableExtra("objek");
        judul = findViewById(R.id.txJudul);
        lokasi = findViewById(R.id.txLokasi);
        waktu = findViewById(R.id.txtWaktu);
        id = findViewById(R.id.txNama);

        judul.setText(listBencana.getJudul());
        lokasi.setText(listBencana.getLokasi());
//        waktu.setText(listBencana.getWaktu());
        id.setText(listBencana.getNama());
    }
}
