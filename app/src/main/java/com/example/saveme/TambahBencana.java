package com.example.saveme;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TambahBencana extends AppCompatActivity implements View.OnClickListener {
    Spinner spJenisBencana, spBencana;
    private StorageReference mStorageRef;
    ImageView imageView;
    Button btTambahBencana;
    EditText etJudul, etDeskripsi, etLokasi;
    TextView gambar;
    String nama;
    FirebaseFirestore db;
    public static final int PICK_IMAGE =1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_bencana);
        btTambahBencana = findViewById(R.id.btTambahBencana);
        btTambahBencana.setOnClickListener(this);
        spBencana=findViewById(R.id.spJenisBencana);
        gambar= findViewById(R.id.textView12);
//        gambar.setOnClickListener(this);
        etJudul = findViewById(R.id.etJudul);
        etDeskripsi = findViewById(R.id.etDeskripsi);
        etLokasi = findViewById(R.id.etLokasi);
        Intent intent = getIntent();
        nama = intent.getStringExtra("nama");
        imageView = findViewById(R.id.imageView5);
        imageView.setOnClickListener(this);
        mStorageRef = FirebaseStorage.getInstance().getReference();
    }

//    public void addItemsOnSpJenisBencana() {
//        spJenisBencana = findViewById(R.id.spJenisBencana);
//        List<String> list = new ArrayList<String>();
//        list.add("Alam");
//        list.add("Buatan");
//        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_spinner_item, list);
//        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spJenisBencana.setAdapter(dataAdapter);
//    }

//    public void addItemsOnSpBencana() {
//        spBencana = findViewById(R.id.spBencana);
//        List<String> list = new ArrayList<String>();
//        if (spBencana.getSelectedItem() == "Alam") {
//            list.add("Gempa Bumi");
//            list.add("Tanah Longsor");
//            list.add("Gunung Meletus");
//            list.add("Angin Puting Beliung");
//        } else if (spBencana.getSelectedItem() == "Buatan") {
//            list.add("Alam");
//            list.add("Buatan");
//        }
//
//        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_spinner_item, list);
//        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spBencana.setAdapter(dataAdapter);
//    }

//    // get the selected dropdown list value
//    public void addListenerOnButton() {
//
//        spinner1 = (Spinner) findViewById(R.id.spinner1);
//        spinner2 = (Spinner) findViewById(R.id.spinner2);
//    @Override
    String imgUrl;
    public void onClick(View v) {
        if (v==btTambahBencana){
            uploadImg();
        }else if (v==imageView){
            Intent getIntent = new Intent(Intent.ACTION_GET_CONTENT);
            getIntent.setType("image/*");

            Intent pickIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            pickIntent.setType("image/*");

            Intent chooserIntent = Intent.createChooser(getIntent,"Select Image");
            chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS,new Intent[]{pickIntent});

            startActivityForResult(chooserIntent,PICK_IMAGE);
        }
    }
    private Uri imageuri;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE){
            if (resultCode== RESULT_OK){
                Log.d("Uri",data.getData().toString());
                imageView.setImageURI(data.getData());
                imageuri = data.getData();
            }
        }
    }

    void uploadImg(){
        Uri file = imageuri;
        final StorageReference ref = mStorageRef.child(file.getLastPathSegment());
        UploadTask uploadTask  = ref.putFile(file);
        Task<Uri> urlTask = uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
            @Override
            public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                if (!task.isSuccessful()) {
                    throw task.getException();
                }

                // Continue with the task to get the download URL
//                etDeskripsi.setText(ref.getDownloadUrl().toString());
                return ref.getDownloadUrl();
            }
        }).addOnCompleteListener(new OnCompleteListener<Uri>() {
            @Override
            public void onComplete(@NonNull Task<Uri> task) {
                if (task.isSuccessful()) {
                    Uri downloadUri = task.getResult();
                    uploadData(downloadUri.toString());
                } else {
                    // Handle failures
                    // ...
                }
            }
        });
    }

    void uploadData(String url){
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Date date = new Date();
        Map<String, Object> user = new HashMap<>();
        user.put("judul", etJudul.getText().toString());
        user.put("deskripsi", etDeskripsi.getText().toString());
        user.put("lokasi", etLokasi.getText().toString());
        user.put("bencana",spBencana.getSelectedItem().toString());
        user.put("nama",nama);
        user.put("waktu",dateFormat.format(date));
        user.put("imgUrl",url);
        db = FirebaseFirestore.getInstance();
        // Add a new document with a generated ID
        db.collection("laporan_bencana")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d("Success : ", "DocumentSnapshot added with ID: " + documentReference.getId());
                        Toast.makeText(TambahBencana.this,"Success", Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("Failure : ", "Error adding document", e);
                    }
                });
    }
}
