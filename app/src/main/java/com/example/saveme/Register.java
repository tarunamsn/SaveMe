package com.example.saveme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity implements View.OnClickListener {
    Button btnSubmit;
    EditText etDaftarNama, etDaftarUsername, etDaftarPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(this);

        etDaftarNama = findViewById(R.id.etDaftarNama);
        etDaftarUsername = findViewById(R.id.etDaftarUsername);
        etDaftarPass = findViewById(R.id.etDaftarPass);
        etDaftarNama.setOnClickListener(this);
        etDaftarUsername.setOnClickListener(this);
        etDaftarPass.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
