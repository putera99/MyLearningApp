package com.example.mylearningapp;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class SensorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sensor_activity);

        TextView sensorListTextView = findViewById(R.id.sensorListTextView);
        SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);

        StringBuilder sensorInfo = new StringBuilder();
        sensorInfo.append("Daftar Sensor yang Tersedia:\n\n");

        if (sensorList.isEmpty()) {
            sensorInfo.append("Tidak ada sensor yang ditemukan di perangkat ini.\n");
        } else {
            for (int i = 0; i < sensorList.size(); i++) {
                Sensor sensor = sensorList.get(i);
                sensorInfo.append("No: ").append(i + 1).append("\n");
                sensorInfo.append("Nama: ").append(sensor.getName()).append("\n");
                sensorInfo.append("Vendor: ").append(sensor.getVendor()).append("\n");
                sensorInfo.append("Tipe: ").append(getSensorTypeName(sensor.getType())).append("\n");
                sensorInfo.append("Versi: ").append(sensor.getVersion()).append("\n\n");
            }
        }

        sensorListTextView.setText(sensorInfo.toString());
    }

    private String getSensorTypeName(int sensorType) {
        switch (sensorType) {
            case Sensor.TYPE_ACCELEROMETER:
                return "Accelerometer";
            case Sensor.TYPE_AMBIENT_TEMPERATURE:
                return "Ambient Temperature";
            case Sensor.TYPE_GRAVITY:
                return "Gravity";
            case Sensor.TYPE_GYROSCOPE:
                return "Gyroscope";
            case Sensor.TYPE_LIGHT:
                return "Light";
            case Sensor.TYPE_LINEAR_ACCELERATION:
                return "Linear Acceleration";
            case Sensor.TYPE_MAGNETIC_FIELD:
                return "Magnetic Field";
            case Sensor.TYPE_PRESSURE:
                return "Pressure";
            case Sensor.TYPE_PROXIMITY:
                return "Proximity";
            case Sensor.TYPE_RELATIVE_HUMIDITY:
                return "Relative Humidity";
            case Sensor.TYPE_ROTATION_VECTOR:
                return "Rotation Vector";
            default:
                return "Unknown Sensor Type (" + sensorType + ")";
        }
    }
}