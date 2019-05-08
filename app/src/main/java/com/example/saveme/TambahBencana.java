package com.example.saveme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TambahBencana extends AppCompatActivity {
    Button btTambahBencana;
    Spinner spBencana;
    EditText etJudul, etLokasi, etDeskripsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_bencana);
        etJudul = findViewById(R.id.etJudul);
        etLokasi = findViewById(R.id.etLokasi);
        etDeskripsi = findViewById(R.id.etDeskripsi);
        spBencana = (Spinner) findViewById(R.id.spBencana);

        btTambahBencana = (Button) findViewById(R.id.btTambahBencana);
        btTambahBencana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TambahBencana.this,
                        "Result : " +"\nBencana : "+ spBencana.getSelectedItem().toString(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
//    public void addItemsOnSpBencana() {
//        Spinner spBencana = findViewById(R.id.spBencana);
//        if (spJenisBencana.getSelectedItem() == "Alam") {
//            String[] bencanaAlam = getResources().getStringArray(R.array.bencana_alam_arrays);
//            ArrayAdapter<String> aaBencanaAlam = new ArrayAdapter<String>
//                    (this,R.layout.activity_tambah_bencana, bencanaAlam);
//            aaBencanaAlam.setDropDownViewResource(R.layout.activity_tambah_bencana);
//            spBencana.setAdapter(aaBencanaAlam);
//        } else if (spJenisBencana.getSelectedItem() == "Buatan") {
//            String[] bencanaBuatan = getResources().getStringArray(R.array.bencana_buatan_arrays);
//            ArrayAdapter<String> aaBencanaBuatan = new ArrayAdapter<String>
//                    (this,R.layout.activity_tambah_bencana,  bencanaBuatan);
//            aaBencanaBuatan.setDropDownViewResource(R.layout.activity_tambah_bencana);
//            spBencana.setAdapter(aaBencanaBuatan);
//        }
//    }

//    public void addItemsOnSpJenisBencana() {
//        Spinner spBencana = findViewById(R.id.spBencana);
//        String[] jenisBencana = getResources().getStringArray(R.array.bencana_alam_arrays);
//
//        ArrayAdapter<String> aaJenisBencana = new ArrayAdapter<String>(this,R.layout.activity_tambah_bencana,
//                jenisBencana);
//
//        aaJenisBencana.setDropDownViewResource(R.layout.activity_tambah_bencana);
//        spBencana.setAdapter(aaJenisBencana);
//    }
