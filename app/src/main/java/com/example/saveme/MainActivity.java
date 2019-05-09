package com.example.saveme;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.ArrayAdapter;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    FloatingActionButton fabTambah;
    private static final String TAG = "MainActivity";
    String nama;
    listBencanaAdapter adapter;
    ArrayList<listBencana> listBencanaArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: Started.");
        RecyclerView mListView = (RecyclerView) findViewById(R.id.reListBencana);
//        listBencana a = new listBencana("banjir", "dinoyo", "10:00", "", "","","");
//        listBencana b = new listBencana("banjir", "dinoyo", "10:00", R.drawable.btn_plus, "");
//        listBencana c = new listBencana("banjir", "dinoyo", "10:00", R.drawable.btn_plus, "");
//        listBencana d = new listBencana("banjir", "dinoyo", "10:00", R.drawable.btn_plus, "");

        listBencanaArrayList = new ArrayList<>();
//        listBencanaArrayList.add(a);
//        listBencanaArrayList.add(b);
//        listBencanaArrayList.add(c);
//        listBencanaArrayList.add(d);
        adapter = new listBencanaAdapter(listBencanaArrayList,this);
        mListView.setAdapter(adapter);
        mListView.setLayoutManager(new LinearLayoutManager(this));
        getData();
        fabTambah = findViewById(R.id.fabTambah);
        fabTambah.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(this, TambahBencana.class);
        i.putExtra("nama",nama);
        startActivity(i);
    }
    FirebaseFirestore db;
//    ArrayList<listBencana> listBencanaArrayList;
    void getData(){
        db = FirebaseFirestore.getInstance();
        db.collection("laporan_bencana")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("Success", document.getId() + " => " + document.getData());
                                String judul= document.getData().get("judul").toString();
                                String bencana= document.getData().get("bencana").toString();
                                String lokasi = document.getData().get("lokasi").toString();
                                String deskripsi = document.getData().get("lokasi").toString();
                                String waktu =document.getData().get("waktu").toString();
                                String gambar=document.getData().get("imgUrl").toString();
                                String nama=document.getData().get("nama").toString();
                                listBencana a = new listBencana(judul, bencana, lokasi, deskripsi, waktu, gambar, nama);
                                listBencanaArrayList.add(a);
                                adapter.notifyDataSetChanged();
                            }
                        } else {
                            Log.w("Failure : ", "Error getting documents.", task.getException());
                        }
                    }
                });
    }
}
