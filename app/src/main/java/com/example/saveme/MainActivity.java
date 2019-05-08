package com.example.saveme;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    FloatingActionButton fabTambah;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: Started.");
        RecyclerView mListView = (RecyclerView) findViewById(R.id.reListBencana);
//        listBencana a = new listBencana("banjir", "dinoyo", "10:00", R.drawable.btn_plus, "");
//        listBencana b = new listBencana("banjir", "dinoyo", "10:00", R.drawable.btn_plus, "");
//        listBencana c = new listBencana("banjir", "dinoyo", "10:00", R.drawable.btn_plus, "");
//        listBencana d = new listBencana("banjir", "dinoyo", "10:00", R.drawable.btn_plus, "");

        ArrayList<listBencana> listBencanaArrayList = new ArrayList<>();
//        listBencanaArrayList.add(a);
//        listBencanaArrayList.add(b);
//        listBencanaArrayList.add(c);
//        listBencanaArrayList.add(d);
//        listBencanaAdapter adapter = new listBencanaAdapter(this, R.layout.layout_list, listBencanaArrayList);
//        mListView.setAdapter(adapter);

        fabTambah = findViewById(R.id.fabTambah);
        fabTambah.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(this, TambahBencana.class);
        startActivity(i);
    }
}
