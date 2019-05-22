package com.example.saveme;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity implements View.OnClickListener{
    Button btnLogin, btnRegister;
    EditText etUsername, etPassword;
    CheckBox rememberCb;
    FirebaseFirestore db;
    SharedPreferences mPreferences;
    String sharedPrefFile = "com.example.android.saveme";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);

        etUsername = findViewById(R.id.etUsername);
        etPassword= findViewById(R.id.etPassword);
        rememberCb = findViewById(R.id.rememberCb);

        btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(this);

        FirebaseApp.initializeApp(this);

        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        if (mPreferences.getBoolean("checked", false)){
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.putExtra("nama",mPreferences.getString("nama",""));
            startActivity(intent);
        }
    }
    @Override
    public void onClick(View v) {
        if (v == btnLogin){
            db = FirebaseFirestore.getInstance();
            db.collection("user")
                    .whereEqualTo("username",etUsername.getText().toString())
//                    .whereEqualTo("password",etPassword.getText().toString())
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                String password="Un1qv3";
                                String nama = "Taruna";
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    Log.d("Success", document.getId() + " => " + document.getData());
                                    nama = document.getData().get("name").toString();
                                    password = document.getData().get("password").toString();
                                }
                                if (etPassword.getText().toString().equals(password)){

                                    Log.d("Nama",nama);

                                    SharedPreferences.Editor preferencesEditor = mPreferences.edit();

                                    preferencesEditor.putString("nama", nama);
                                    preferencesEditor.putBoolean("checked", rememberCb.isChecked());
                                    preferencesEditor.commit();

                                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                    intent.putExtra("nama",nama);
                                    startActivity(intent);
                                }
                                else {
                                    Toast.makeText(Login.this,"Login failure", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Log.w("Failure : ", "Error getting documents.", task.getException());
                            }
                        }
                    });
//            Intent intent = new Intent(this, MainActivity.class);
//            startActivity(intent);
        }else if (v == btnRegister){
            Intent intent = new Intent(this, Register.class);
            startActivity(intent);
        }
    }
}
