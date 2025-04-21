package com.example.mylearningapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.ViewCompat;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_third);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.third), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Menerima data dari SecondActivity
        String name = getIntent().getStringExtra("USER_NAME");

        // Menampilkan pesan
        TextView textViewProfile = findViewById(R.id.textViewProfile);
        textViewProfile.setText("Profil: " + name);

        // Tombol untuk kembali ke activity sebelumnya
        Button btnBack = findViewById(R.id.btnBackToSecond);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Tombol untuk kembali ke MainActivity
        Button btnHome = findViewById(R.id.btnBackToHome);
        // Tombol untuk kembali ke ForthActivity
        Button btnForth = findViewById(R.id.btnToForth);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Membuat Intent baru untuk MainActivity dengan flag khusus
                Intent intent = new Intent(ThirdActivity.this, MainActivity.class);
                // Menghapus semua activity di stack dan membuat MainActivity sebagai root baru
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish(); // Menutup activity saat ini
            }
        });

        btnForth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Membuat Intent baru untuk MainActivity dengan flag khusus
                Intent intent = new Intent(ThirdActivity.this, ForthActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
    }
}