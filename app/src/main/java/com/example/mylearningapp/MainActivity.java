package com.example.mylearningapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText editTextName = findViewById(R.id.editTextName);
        TextView textViewWelcome = findViewById(R.id.textViewWelcome);
        Button button = findViewById(R.id.login_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();

                if (!name.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Login berhasil untuk: " + name, Toast.LENGTH_SHORT).show();

                    textViewWelcome.setText("Selamat datang, " + name);

                    // Pindah ke SecondActivity dengan membawa data nama
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("USER_NAME", name);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Silakan masukkan nama Anda", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}