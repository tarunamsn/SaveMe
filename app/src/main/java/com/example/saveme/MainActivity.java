package com.example.saveme;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
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
    ArrayList<Bencana> listBencanaArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: Started.");

        RecyclerView mListView = (RecyclerView) findViewById(R.id.reListBencana);
        listBencanaArray = new ArrayList<>();
        adapter = new listBencanaAdapter(listBencanaArray,this);
        mListView.setAdapter(adapter);
        mListView.setLayoutManager(new LinearLayoutManager(this));

        getData();

        fabTambah = findViewById(R.id.fabTambah);
        fabTambah.setOnClickListener(this);

        Intent intent = getIntent();
        nama = intent.getStringExtra("nama");
        Log.d("nama",nama);
    }

    final int TAMBAH_BENCANA =1;

    @Override
    public void onClick(View v) {
        Intent i = new Intent(this, TambahBencana.class);
        i.putExtra("nama",nama);
        Log.d("nama",nama);
        startActivityForResult(i,TAMBAH_BENCANA);
    }
    FirebaseFirestore db;
//    ArrayList<Bencana> listBencanaArray;
    void getData(){

        final ProgressDialog progressDialog;
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading ...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        db = FirebaseFirestore.getInstance();
        db.collection("laporan_bencana")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                String judul= document.getData().get("judul").toString();
                                String bencana= document.getData().get("bencana").toString();
                                String lokasi = document.getData().get("lokasi").toString();
                                String deskripsi = document.getData().get("deskripsi").toString();
                                String waktu =document.getData().get("waktu").toString();
                                String gambar=document.getData().get("imgUrl").toString();
                                String nama = document.getData().get("nama").toString();
                                Bencana a = new Bencana(judul, bencana, lokasi, waktu, deskripsi, gambar, nama);
                                listBencanaArray.add(a);
                                adapter.notifyDataSetChanged();
                            }
                            progressDialog.dismiss();
                        } else {
                            Log.w("Failure : ", "Error getting documents.", task.getException());
                        }
                    }
                });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TAMBAH_BENCANA){
            if (resultCode == RESULT_OK){
                Bencana b = data.getParcelableExtra("objek");
                listBencanaArray.add(b);
                adapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Do you want to Logout ?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        SharedPreferences.Editor editor = getSharedPreferences("com.example.android.saveme",MODE_PRIVATE).edit();
                        editor.clear();
                        editor.commit();

                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
