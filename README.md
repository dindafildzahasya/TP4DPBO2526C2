# People Data – Data Anggota Perpustakaan


## Janji

Saya Adinda Fildzah Hasya dengan NIM 2501218 mengerjakan Tugas Praktikum 4 dalam mata kuliah Desain dan Pemrograman Berorientasi Objek untuk keberkahanNya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin.

## 1. Deskripsi Program

People Data merupakan aplikasi berbasis Java Swing yang digunakan untuk mengelola data anggota perpustakaan. Aplikasi ini dirancang dengan antarmuka grafis (*Graphical User Interface* atau GUI) agar pengguna dapat mengelola data anggota dengan mudah.

Aplikasi ini menerapkan konsep CRUD (*Create, Read, Update, Delete*), yaitu menambahkan, menampilkan, memperbarui, dan menghapus data anggota perpustakaan.

Informasi anggota yang dikelola dalam aplikasi ini meliputi ID, nama, tahun lahir, kategori anggota, email, dan jumlah buku yang sedang dipinjam.

## 2. Desain dan Fungsi Program

### 2.1 Desain Antarmuka

Antarmuka aplikasi terdiri dari beberapa komponen input, tombol operasi, dan tabel untuk menampilkan data anggota perpustakaan.

Komponen yang digunakan dalam aplikasi adalah sebagai berikut:

| Komponen | Fungsi |
|---|---|
| ID | Memasukkan identitas unik anggota perpustakaan. |
| Nama | Memasukkan nama anggota perpustakaan. |
| Tahun Lahir | Memasukkan tahun lahir anggota. |
| Kategori | Memilih kategori anggota, yaitu Mahasiswa, Dosen, atau Umum. |
| Email | Memasukkan alamat email anggota. |
| Jumlah Buku Dipinjam | Menentukan jumlah buku yang sedang dipinjam menggunakan komponen `JSpinner`. |
| Add | Menambahkan data anggota baru ke dalam daftar. |
| Cancel | Mengosongkan form input. |
| Update | Memperbarui data anggota yang dipilih. |
| Delete | Menghapus data anggota setelah pengguna memberikan konfirmasi. |
| JTable | Menampilkan data anggota perpustakaan dalam bentuk tabel. |
| JScrollPane | Memungkinkan pengguna menggulir tabel ketika data melebihi area yang terlihat. |

### 2.2 Struktur Program

Program terdiri dari tiga file utama, yaitu:

1. **Person.java**

   Berfungsi sebagai representasi data anggota perpustakaan. Kelas ini menyimpan atribut anggota, yaitu ID, nama, tahun lahir, kategori, email, dan jumlah buku yang dipinjam. Kelas ini juga menyediakan constructor, getter, dan setter untuk mengakses serta memperbarui atribut tersebut.

2. **PeopleMenu.java**

   Berfungsi sebagai pengatur jalannya aplikasi. File ini menangani interaksi pengguna dengan antarmuka, menampilkan data pada tabel, serta menjalankan operasi CRUD.

3. **PeopleMenu.form**

   Berfungsi untuk menyimpan desain antarmuka grafis aplikasi yang dibuat menggunakan IntelliJ GUI Designer.

### 2.3 Fungsi Utama Program

Aplikasi People Data memiliki empat fungsi utama berdasarkan konsep CRUD.

**a. Create (Add)**

Fungsi Create digunakan untuk menambahkan data anggota perpustakaan baru. Pengguna mengisi informasi anggota melalui form, kemudian menekan tombol Add. Data yang valid akan ditambahkan ke daftar dan ditampilkan pada tabel.

**b. Read (Menampilkan Data)**

Fungsi Read digunakan untuk menampilkan data anggota perpustakaan pada tabel. Data awal ditampilkan ketika aplikasi dijalankan, sedangkan data yang berhasil ditambahkan atau diperbarui juga ditampilkan pada tabel.

**c. Update**

Fungsi Update digunakan untuk memperbarui informasi anggota yang sudah tersimpan. Pengguna memilih baris data pada tabel, mengubah informasi yang diperlukan melalui form, kemudian menekan tombol Update.

**d. Delete**

Fungsi Delete digunakan untuk menghapus data anggota perpustakaan. Sebelum penghapusan dilakukan, aplikasi menampilkan dialog konfirmasi agar pengguna dapat memastikan kembali tindakan yang akan dilakukan.

## 3. Penjelasan Alur Program

Alur kerja aplikasi People Data adalah sebagai berikut:

1. Program dijalankan melalui method `main()` pada kelas `PeopleMenu`.
2. Aplikasi menampilkan antarmuka Data Anggota Perpustakaan beserta data awal pada tabel.
3. Pengguna dapat melihat data anggota yang tersedia melalui tabel.
4. Untuk menambahkan anggota baru, pengguna mengisi form dan menekan tombol Add. Program memproses input, menambahkan data yang valid, kemudian memperbarui tampilan tabel.
5. Untuk memperbarui data, pengguna memilih salah satu baris tabel. Data anggota yang dipilih akan ditampilkan pada form. Pengguna mengubah informasi yang diperlukan dan menekan tombol Update.
6. Untuk menghapus data, pengguna memilih baris anggota yang ingin dihapus, kemudian menekan tombol Delete.
7. Aplikasi menampilkan dialog konfirmasi penghapusan. Jika pengguna menyetujui, data akan dihapus dari daftar dan tabel diperbarui.
8. Tombol Cancel digunakan untuk mengosongkan form dan mempersiapkan input berikutnya.

Dengan alur tersebut, pengguna dapat mengelola data anggota perpustakaan melalui antarmuka grafis yang disediakan.

## 4. Dokumentasi Program

Bagian ini mendokumentasikan penggunaan aplikasi melalui screenshot saat program dijalankan. Dokumentasi difokuskan pada operasi Create, Update, dan Delete, sedangkan fungsi Read ditunjukkan melalui tabel yang terlihat pada screenshot operasi lainnya.

### 4.1 Operasi Create (Add)


<img width="800" height="450" alt="Add" src="https://github.com/user-attachments/assets/d5917eb4-bf9b-4590-aab4-7c4a317a54a0" />


### 4.2 Operasi Update


<img width="800" height="450" alt="Update" src="https://github.com/user-attachments/assets/5335790b-9259-43be-8909-9414d6920fee" />



### 4.3 Operasi Delete


<img width="800" height="450" alt="Delete" src="https://github.com/user-attachments/assets/11af114a-3290-4af7-a018-a3faf2d9f9f6" />


### 4.4 Error


<img width="800" height="450" alt="Error" src="https://github.com/user-attachments/assets/7f718885-56f8-4749-a503-c325c4d58e76" />

