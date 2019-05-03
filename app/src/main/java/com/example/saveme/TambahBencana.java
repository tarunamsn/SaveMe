package com.example.saveme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class TambahBencana extends AppCompatActivity implements View.OnClickListener {
    Spinner spJenisBencana, spBencana;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_bencana);
        int i;
    }

    public void addItemsOnSpJenisBencana() {
        spJenisBencana = findViewById(R.id.spJenisBencana);
        List<String> list = new ArrayList<String>();
        list.add("Alam");
        list.add("Buatan");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spJenisBencana.setAdapter(dataAdapter);
    }

    public void addItemsOnSpBencana() {
        spBencana = findViewById(R.id.spBencana);
        List<String> list = new ArrayList<String>();
        if (spBencana.getSelectedItem() == "Alam") {
            list.add("Gempa Bumi");
            list.add("Tanah Longsor");
            list.add("Gunung Meletus");
            list.add("Angin Puting Beliung");
        } else if (spBencana.getSelectedItem() == "Buatan") {
            list.add("Alam");
            list.add("Buatan");
        }

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spBencana.setAdapter(dataAdapter);
    }

//    // get the selected dropdown list value
//    public void addListenerOnButton() {
//
//        spinner1 = (Spinner) findViewById(R.id.spinner1);
//        spinner2 = (Spinner) findViewById(R.id.spinner2);
//    @Override
    public void onClick(View v) {

    }
}
