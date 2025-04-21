package com.example.mylearningapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    public static final String EXTRA_USER_NAME = "USER_NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.second), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Ambil nama pengguna dari intent
        String userName = getIntent().getStringExtra(EXTRA_USER_NAME);

        // Tampilkan nama pengguna
        TextView textViewUserName = findViewById(R.id.textViewUserName);
        textViewUserName.setText("Halo, " + userName + "!");

        // Set listener tombol
        setOnClick(R.id.btnToThird, ThirdActivity.class, userName);
        setOnClick(R.id.btnToCalculator, CalcActivity.class, null);
        findViewById(R.id.btnBack).setOnClickListener(view -> finish());
    }

    private void setOnClick(int buttonId, Class<?> targetActivity, String name) {
        findViewById(buttonId).setOnClickListener(view -> {
            Intent intent = new Intent(SecondActivity.this, targetActivity);
            if (name != null) {
                intent.putExtra(EXTRA_USER_NAME, name);
            }
            startActivity(intent);
        });
    }
}
