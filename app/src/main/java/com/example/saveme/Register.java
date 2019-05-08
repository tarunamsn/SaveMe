package com.example.saveme;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity implements View.OnClickListener {
    Button btnSubmit;
    EditText etDaftarNama, etDaftarUsername, etDaftarPass;
    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(this);

        etDaftarNama = findViewById(R.id.etDaftarNama);
        etDaftarUsername = findViewById(R.id.etDaftarUsername);
        etDaftarPass = findViewById(R.id.etDaftarPass);
    }

    @Override
    public void onClick(View v) {
        Map<String, Object> user = new HashMap<>();
        user.put("name", etDaftarNama.getText().toString());
        user.put("username", etDaftarUsername.getText().toString());
        user.put("password", etDaftarPass.getText().toString());
        db = FirebaseFirestore.getInstance();
        // Add a new document with a generated ID
        db.collection("user")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d("Success : ", "DocumentSnapshot added with ID: " + documentReference.getId());
                        Toast.makeText(Register.this,"Success", Toast.LENGTH_LONG).show();
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
