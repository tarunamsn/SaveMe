package com.example.saveme;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.ArrayAdapter;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    FloatingActionButton fabTambah;
    RecyclerView.Adapter adapter;
    RecyclerView mListView;
    ArrayList<listBencana> listBencanaArrayList;
    /*private static final String TAG = "MainActivity";*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Log.d(TAG, "onCreate: Started.");*/
        mListView = (RecyclerView) findViewById(R.id.reListBencana);
        mListView.setHasFixedSize(true);
        mListView.setLayoutManager(new LinearLayoutManager(this));

        listBencanaArrayList = new ArrayList<>();
        listBencanaArrayList.add(new listBencana("banjir", "dinoyo", "10:00", R.drawable.common_full_open_on_phone, "1"));
        listBencanaArrayList.add(new listBencana("banjir", "dinoyo", "10:00", R.drawable.common_full_open_on_phone, "1"));
        listBencanaArrayList.add(new listBencana("banjir", "dinoyo", "10:00", R.drawable.common_full_open_on_phone, "1"));
        listBencanaArrayList.add(new listBencana("banjir", "dinoyo", "10:00", R.drawable.common_full_open_on_phone, "1"));
        adapter = new listBencanaAdapter(listBencanaArrayList, this);
        mListView.setAdapter(adapter);

        fabTambah = findViewById(R.id.fabTambah);
        fabTambah.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(this, TambahBencana.class);
        startActivity(i);
    }
}
