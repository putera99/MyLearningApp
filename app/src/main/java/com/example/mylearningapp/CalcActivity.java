package com.example.mylearningapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class CalcActivity extends AppCompatActivity {

    private TextView teksHasil;
    private String angkaSekarang = "";
    private String operator = "";
    private double angkaPertama = 0;
    private boolean baruKlikOperator = false;
    private final DecimalFormat formatDesimal = new DecimalFormat("#.##########");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.calculator_activity);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.calculator), (v, insets) -> {
            Insets sistemBar = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(sistemBar.left, sistemBar.top, sistemBar.right, sistemBar.bottom);
            return insets;
        });

        teksHasil = findViewById(R.id.result_text);

        // Tombol angka
        aturTombolAngka(R.id.btn_0, "0");
        aturTombolAngka(R.id.btn_1, "1");
        aturTombolAngka(R.id.btn_2, "2");
        aturTombolAngka(R.id.btn_3, "3");
        aturTombolAngka(R.id.btn_4, "4");
        aturTombolAngka(R.id.btn_5, "5");
        aturTombolAngka(R.id.btn_6, "6");
        aturTombolAngka(R.id.btn_7, "7");
        aturTombolAngka(R.id.btn_8, "8");
        aturTombolAngka(R.id.btn_9, "9");
        aturTombolAngka(R.id.btn_dot, ".");

        // Tombol operator
        aturTombolOperator(R.id.btn_add, "+");
        aturTombolOperator(R.id.btn_subtract, "-");
        aturTombolOperator(R.id.btn_multiply, "×");
        aturTombolOperator(R.id.btn_divide, "÷");

        // Tombol sama dengan
        Button tombolSamaDengan = findViewById(R.id.btn_equals);
        tombolSamaDengan.setOnClickListener(v -> hitungHasil());

        // Tombol bersih
        Button tombolHapus = findViewById(R.id.btn_clear);
        tombolHapus.setOnClickListener(v -> reset());

        // Tombol kembali
        Button tombolKembali = findViewById(R.id.btn_back);
        tombolKembali.setOnClickListener(v -> finish());
    }

    private void aturTombolAngka(int idTombol, final String angka) {
        Button tombol = findViewById(idTombol);
        tombol.setOnClickListener(v -> {
            if (baruKlikOperator) {
                angkaSekarang = "";
                baruKlikOperator = false;
            }

            if (angka.equals(".") && angkaSekarang.contains(".")) {
                return; // hindari titik ganda
            }

            angkaSekarang += angka;
            teksHasil.setText(angkaSekarang);
        });
    }

    private void aturTombolOperator(int idTombol, final String simbol) {
        Button tombol = findViewById(idTombol);
        tombol.setOnClickListener(v -> {
            if (!angkaSekarang.isEmpty()) {
                try {
                    if (!operator.isEmpty()) {
                        hitungHasil();
                    }

                    angkaPertama = Double.parseDouble(angkaSekarang);
                    operator = simbol;
                    baruKlikOperator = true;
                    teksHasil.setText(formatAngka(angkaPertama) + " " + operator);
                } catch (NumberFormatException e) {
                    teksHasil.setText("Input salah");
                }
            } else if (teksHasil.getText().toString().contains(" ")) {
                // ganti operator
                String teksSekarang = teksHasil.getText().toString();
                String baru = teksSekarang.substring(0, teksSekarang.lastIndexOf(" ") + 1) + simbol;
                operator = simbol;
                teksHasil.setText(baru);
            }
        });
    }

    private void hitungHasil() {
        if (!angkaSekarang.isEmpty() && !operator.isEmpty()) {
            try {
                double angkaKedua = Double.parseDouble(angkaSekarang);
                double hasil = 0;

                switch (operator) {
                    case "+":
                        hasil = angkaPertama + angkaKedua;
                        break;
                    case "-":
                        hasil = angkaPertama - angkaKedua;
                        break;
                    case "×":
                        hasil = angkaPertama * angkaKedua;
                        break;
                    case "÷":
                        if (angkaKedua != 0) {
                            hasil = angkaPertama / angkaKedua;
                        } else {
                            teksHasil.setText("Error");
                            return;
                        }
                        break;
                }

                angkaSekarang = formatAngka(hasil);
                teksHasil.setText(angkaSekarang);
                operator = "";

            } catch (NumberFormatException e) {
                teksHasil.setText("Input salah");
            }
        }
    }

    private void reset() {
        angkaSekarang = "";
        angkaPertama = 0;
        operator = "";
        baruKlikOperator = false;
        teksHasil.setText("0");
    }

    private String formatAngka(double angka) {
        if (angka == (long) angka) {
            return String.format("%d", (long) angka);
        } else {
            return formatDesimal.format(angka);
        }
    }
}
