# MyLearningApp

Aplikasi Android sederhana untuk belajar navigasi antar Activity dengan memanfaatkan Intent dan pertukaran data antar Activity.

## Deskripsi

MyLearningApp adalah aplikasi sederhana untuk MK Mobile Programming IF22H dalam pengembangan aplikasi Android.

Aplikasi ini memiliki tiga Activity:

1. **MainActivity**: Activity utama dengan form login sederhana
2. **SecondActivity**: Menampilkan data pengguna yang diterima dari MainActivity
3. **ThirdActivity**: Menampilkan profil pengguna dengan navigasi ke Activity lainnya

Aplikasi ini cocok untuk pemula yang ingin belajar tentang:
- Implementasi multiple Activity
- Perpindahan antar Activity menggunakan Intent
- Mengirim dan menerima data antar Activity
- Manajemen navigasi kembali (back navigation)

## Fitur

- Form login sederhana
- Navigasi antar tiga Activity berbeda
- Pertukaran data antar Activity menggunakan Intent
- Navigasi kembali ke Activity sebelumnya
- Navigasi langsung ke Activity utama (home)

## Screenshot

*Screenshot aplikasi akan ditampilkan di sini*

## Persyaratan

- Android Studio Electric Eel (2022.1.1) atau lebih baru
- SDK minimum: API 24 (Android 7.0 Nougat)
- SDK target: API 33 (Android 13)
- Gradle 7.5+
- JDK 11

## Cara Instalasi

### Metode 1: Clone Repository

1. Clone repository ini ke komputer Anda:
```bash
git clone https://github.com/putera99/MyLearningApp.git
```

2. Buka Android Studio, pilih "Open an Existing Project" dan arahkan ke folder repository yang baru saja di-clone.

3. Tunggu proses sinkronisasi Gradle selesai.

4. Jalankan aplikasi dengan menekan tombol 'Run' atau dengan kombinasi tombol Shift+F10.

### Metode 2: Download APK

1. Unduh file APK terbaru dari halaman [Releases](https://github.com/putera99/MyLearningApp/releases).

2. Pada perangkat Android, aktifkan "Instalasi dari sumber yang tidak dikenal" di pengaturan keamanan.

3. Buka file APK yang telah diunduh untuk menginstal aplikasi.

## Penggunaan

1. Pada MainActivity, masukkan nama Anda di kolom input.
2. Tekan tombol "Login" untuk melanjutkan ke SecondActivity.
3. Pada SecondActivity, Anda akan melihat pesan sambutan dengan nama yang dimasukkan.
4. Tekan tombol "Pergi ke Activity Ketiga" untuk melanjutkan ke ThirdActivity.
5. Pada ThirdActivity, Anda dapat memilih untuk kembali ke SecondActivity atau langsung ke MainActivity (Beranda).

## Struktur Proyek

```
com.example.mylearningapp/
├── MainActivity.java
├── SecondActivity.java
├── ThirdActivity.java
└── res/
├── layout/
│ ├── activity_main.xml
│ ├── activity_second.xml
│ └── activity_third.xml
└── ...
```

## Kontribusi

Kontribusi sangat diterima! Jika Anda ingin berkontribusi:

1. Fork repository ini
2. Buat branch fitur baru (`git checkout -b feature/amazing-feature`)
3. Commit perubahan Anda (`git commit -m 'Add some amazing feature'`)
4. Push ke branch (`git push origin feature/amazing-feature`)
5. Buat Pull Request

## Kontak

Nama - [putera.harri@gmail.com](mailto:putera.harri@gmail.com)

Link Proyek: [https://github.com/putera99/MyLearningApp](https://github.com/putera99/MyLearningApp)