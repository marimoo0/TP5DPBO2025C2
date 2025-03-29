# TP 5 DPBO 2025

## -- Janji --

Saya Khana Yusdiana NIM 2100991 mengerjakan soal TP 5 dalam mata kuliah Desain dan Pemrograman Berorientasi Objek untuk keberkahanNya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin.

## -- Desain Program --

![1]()

Koneksi ke Database

Program ini menggunakan MySQL sebagai database untuk menyimpan data mahasiswa. Koneksi ke database dilakukan dengan menggunakan JDBC.

CRUD (Create, Read, Update, Delete):

- Create: Data mahasiswa dapat ditambahkan dengan memastikan bahwa NIM belum ada sebelumnya.
- Read: Data mahasiswa ditampilkan dalam tabel yang diperbarui setiap kali ada perubahan.
- Update: Data mahasiswa yang sudah ada dapat diubah setelah dipilih dari tabel.
- Delete: Data mahasiswa dapat dihapus setelah dipilih dari tabel.

Validasi Input

- Semua field wajib diisi sebelum menambahkan atau memperbarui data.
- Nilai harus berupa angka dalam rentang 0-100.
- NIM harus unik, tidak boleh ada duplikasi.

## -- Penjelasan Alur --

Koneksi ke Database:

- Program pertama-tama melakukan koneksi ke database db_mahasiswa_dpbo.
- Menampilkan Data Mahasiswa
- Saat aplikasi dijalankan, data dari database diambil dan ditampilkan dalam tabel.
- Menambahkan Data Mahasiswa
- Pengguna memasukkan data ke dalam field dan menekan tombol Add.
- Jika ada input kosong atau NIM sudah ada, akan muncul pesan error.
- Jika valid, data dimasukkan ke database dan tabel diperbarui.
- Memilih Data untuk Diedit atau Dihapus
- Pengguna dapat mengklik baris dalam tabel untuk mengisi form dengan data mahasiswa tersebut.
- Jika tombol Update ditekan, data diperbarui di database.
- Jika tombol Delete ditekan, data dihapus dari database.
- Mengosongkan Form
- Tombol Cancel digunakan untuk membersihkan form input.

## -- Dokumentasi saat Program di Jalankan --

### Add Data### Add Data

![1](https://github.com/marimoo0/TP5DPBO2025C2/blob/11c897dac33e1ff4eb08aaf3c031b5fd370a67f1/SS/Screenshot_1.png)

### Update Data

![1](https://github.com/marimoo0/TP5DPBO2025C2/blob/11c897dac33e1ff4eb08aaf3c031b5fd370a67f1/SS/Screenshot_2.png)

### Menghapus Data

![1](https://github.com/marimoo0/TP5DPBO2025C2/blob/11c897dac33e1ff4eb08aaf3c031b5fd370a67f1/SS/Screenshot_3.png)

### Duplikasi Data NIM

![1](https://github.com/marimoo0/TP5DPBO2025C2/blob/11c897dac33e1ff4eb08aaf3c031b5fd370a67f1/SS/Screenshot_4.png)

### Ada Data Kosong

![1](https://github.com/marimoo0/TP5DPBO2025C2/blob/11c897dac33e1ff4eb08aaf3c031b5fd370a67f1/SS/Screenshot_5.png)
