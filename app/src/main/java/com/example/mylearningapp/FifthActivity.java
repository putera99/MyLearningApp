package com.example.mylearningapp;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class FifthActivity extends AppCompatActivity {

    private static final String TAG = "FifthActivity";
    private LocationManager locationManager;
    private LocationListener locationListener;
    private TextView latitudeTextView;
    private TextView longitudeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth); // Hubungkan dengan layout XML

        // Inisialisasi TextView
        latitudeTextView = findViewById(R.id.latitudeTextView);
        longitudeTextView = findViewById(R.id.longitudeTextView);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(@NonNull Location location) {
                double latitude = location.getLatitude();
                double longitude = location.getLongitude();
                Log.d(TAG, "Lokasi Diperbarui - Latitude: " + latitude + ", Longitude: " + longitude);
                updateTextView(latitude, longitude); // Perbarui TextView saat lokasi berubah
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {
                Log.d(TAG, "Status Provider Berubah: " + provider + " menjadi " + status);
            }

            @Override
            public void onProviderEnabled(@NonNull String provider) {
                Log.d(TAG, "Provider Aktif: " + provider);
            }

            @Override
            public void onProviderDisabled(@NonNull String provider) {
                Log.d(TAG, "Provider Nonaktif: " + provider);
            }
        };

        // Periksa izin lokasi sebelum meminta pembaruan atau mendapatkan lokasi terakhir
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED || ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            // Dapatkan lokasi terakhir yang diketahui saat aktivitas diluncurkan
            Location lastKnownLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if (lastKnownLocation != null) {
                double initialLatitude = lastKnownLocation.getLatitude();
                double initialLongitude = lastKnownLocation.getLongitude();
                Log.d(TAG, "Lokasi Awal - Latitude: " + initialLatitude + ", Longitude: " + initialLongitude);
                updateTextView(initialLatitude, initialLongitude); // Perbarui TextView dengan lokasi awal
            } else {
                Log.d(TAG, "Lokasi awal tidak tersedia.");
                latitudeTextView.setText("Latitude: Tidak Diketahui");
                longitudeTextView.setText("Longitude: Tidak Diketahui");
            }

            // Meminta pembaruan lokasi secara berkala
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
        } else {
            // TODO: Handle kasus jika izin belum diberikan. Anda mungkin perlu meminta izin di sini.
            Log.e(TAG, "Izin lokasi belum diberikan.");
            latitudeTextView.setText("Izin Ditolak");
            longitudeTextView.setText("Izin Ditolak");
            return;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Hentikan pembaruan lokasi saat aktivitas dihancurkan untuk menghemat baterai
        if (locationManager != null && locationListener != null) {
            locationManager.removeUpdates(locationListener);
        }
    }

    // Metode untuk memperbarui TextView
    private void updateTextView(double latitude, double longitude) {
        latitudeTextView.setText("Latitude: " + String.valueOf(latitude));
        longitudeTextView.setText("Longitude: " + String.valueOf(longitude));
    }
}