package com.example.saveme;

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
    }
}
