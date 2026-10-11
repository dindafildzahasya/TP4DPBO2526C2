import javax.swing.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class PeopleMenu {
    private JPanel mainPanel;
    private JTextField idField;
    private JTextField namaField;
    private JTextField tahunLahirField;
    private JButton addButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton cancelButton;
    private JComboBox<String> kategoriComboBox;
    private JTextField emailField;
    private JTable peopleTable;
    private JSpinner jumlahBukuDipinjamSpinner;

    // ArrayList untuk menyipan objek person
    private ArrayList<Person> peopleList;

    public PeopleMenu() {
        peopleList = new ArrayList<>();

        // Menentukan kategori anggota perpustakaan
        kategoriComboBox.setModel(
                new DefaultComboBoxModel<>(
                        new String[]{"???", "Mahasiswa", "Dosen", "Umum"}
                )
        );

        // Mengatur jumlah buku minimum 0 dan maksimum 20
        jumlahBukuDipinjamSpinner.setModel(
                new SpinnerNumberModel(0, 0, 20, 1)
        );

        // Memasukkan data awal dan menampilkan tabel
        populateList();
        setTable();

        // Menghubungkan tombol dengan method CRUD
        addButton.addActionListener(e -> insertData());
        updateButton.addActionListener(e -> updateData());
        deleteButton.addActionListener(e -> deleteData());
        cancelButton.addActionListener(e -> clearForm());

        // Menampilkan data pada form ketika baris dipilih
        peopleTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                selectData();
            }
        });
    }

    // Method untuk mengisi daftar dengan 10 data awal
    public void populateList() {
        peopleList.add(new Person("AGT001", "Andi Pratama", 2005,
                "Mahasiswa", "andi@email.com", 2));

        peopleList.add(new Person("AGT002", "Budi Santoso", 2004,
                "Mahasiswa", "budi@email.com", 1));

        peopleList.add(new Person("AGT003", "Citra Lestari", 1985,
                "Dosen", "citra@email.com", 4));

        peopleList.add(new Person("AGT004", "Dewi Anggraini", 1990,
                "Dosen", "dewi@email.com", 3));

        peopleList.add(new Person("AGT005", "Eka Saputra", 2006,
                "Mahasiswa", "eka@email.com", 0));

        peopleList.add(new Person("AGT006", "Fajar Ramadhan", 2002,
                "Umum", "fajar@email.com", 5));

        peopleList.add(new Person("AGT007", "Gita Permata", 2001,
                "Umum", "gita@email.com", 2));

        peopleList.add(new Person("AGT008", "Hendra Wijaya", 2005,
                "Mahasiswa", "hendra@email.com", 1));

        peopleList.add(new Person("AGT009", "Intan Maharani", 1988,
                "Dosen", "intan@email.com", 6));

        peopleList.add(new Person("AGT010", "Joko Firmansyah", 2003,
                "Umum", "joko@email.com", 0));
    }

    // Method untuk menampilkan data ArrayList ke dalam JTable
    public void setTable() {
        String[] columnNames = {
                "ID", "Nama", "Tahun Lahir", "Kategori", "Email", " Jumlah Buku Dipinjam"
        };

        // Membuat model tabel dengan nama kolom dan nol baris awal
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        // Membaca setiap objek Person di dalam ArrayList
        for (Person person : peopleList) {
            Object[] rowData = {
                    person.getId(),
                    person.getNama(),
                    person.getTahunLahir(),
                    person.getKategori(),
                    person.getEmail(),
                    person.getJumlahBukuDipinjam()
            };
            // Menambahkan baris data
            model.addRow(rowData);
        }
        // Memasang model tabel
        peopleTable.setModel(model);
    }

    // Method untuk menambahkan data baru
    public void insertData() {
        String id = idField.getText().trim();
        String nama = namaField.getText().trim();
        String tahunLahirText = tahunLahirField.getText().trim();
        String kategori = (String) kategoriComboBox.getSelectedItem();
        String email = emailField.getText().trim();
        int jumlahBuku = (Integer) jumlahBukuDipinjamSpinner.getValue();

        if (id.isEmpty() || nama.isEmpty()
                || tahunLahirText.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(
                    mainPanel, "Semua data harus diisi!");
            return;
        }

        // Memeriksa apakah ID sudah digunakan
        for (Person person : peopleList) {
            if (person.getId().equalsIgnoreCase(id)) {
                JOptionPane.showMessageDialog(
                        mainPanel, "ID anggota sudah digunakan!");
                return;
            }
        }

        try {
            int tahunLahir = Integer.parseInt(tahunLahirText);

            Person person = new Person(
                    id, nama, tahunLahir, kategori, email, jumlahBuku);

            peopleList.add(person);
            setTable();
            clearForm();

            JOptionPane.showMessageDialog(
                    mainPanel, "Data anggota berhasil ditambahkan!");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                    mainPanel, "Tahun lahir harus berupa angka!");
        }
    }

    public void clearForm() {
        idField.setText("");
        namaField.setText("");
        tahunLahirField.setText("");
        emailField.setText("");

        kategoriComboBox.setSelectedIndex(0);
        jumlahBukuDipinjamSpinner.setValue(0);

        idField.setEditable(true);
        peopleTable.clearSelection();
    }

    // Method untuk mengambil data dari baris tabel yang dipilih
    public void selectData() {
        // Mengambil indeks baris yang sedang dipilih
        int row = peopleTable.getSelectedRow();

        // Memastikan ada baris yang dipilih
        if (row != -1) {
            idField.setText(peopleTable.getValueAt(row, 0).toString());
            namaField.setText(peopleTable.getValueAt(row, 1).toString());
            tahunLahirField.setText(peopleTable.getValueAt(row, 2).toString());
            kategoriComboBox.setSelectedItem(peopleTable.getValueAt(row, 3).toString());
            emailField.setText(peopleTable.getValueAt(row, 4).toString());
            jumlahBukuDipinjamSpinner.setValue(Integer.parseInt(peopleTable.getValueAt(row, 5).toString()));
            // Mencegah ID diubah ketika melakukan update
            idField.setEditable(false);
        }
    }

    // Method untuk memperbarui data karyawan yang dipilih
    public void updateData() {
        int row = peopleTable.getSelectedRow();

        // Memeriksa apakah pengguna sudah memilih data
        if (row == -1) {
            JOptionPane.showMessageDialog(mainPanel, "Pilih data yang ingin diubah!");
            return;
        }

        // Mengambil nilai terbaru dari form
        String nama = namaField.getText();
        String tahunLahirText = tahunLahirField.getText();
        String kategori = (String) kategoriComboBox.getSelectedItem();
        String email = emailField.getText();
        int jumlahBuku = (Integer) jumlahBukuDipinjamSpinner.getValue();

        // Memeriksa input yang wajib diisi
        if (nama.isEmpty() || tahunLahirText.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(mainPanel, "Semua data harus diisi!");
            return;
        }

        try {
            int tahunLahir = Integer.parseInt(tahunLahirText);

            // Mengambil objek person yang akan diperbarui
            Person person = peopleList.get(row);
            // Mengubah nilai atribut berdasarkan input terbaru
            person.setNama(nama);
            person.setTahunLahir(tahunLahir);
            person.setKategori(kategori);
            person.setEmail(email);
            person.setJumlahBukuDipinjam(jumlahBuku);

            setTable(); // Memperbarui tampilan tabel
            clearForm(); // Mengosongkan form setelah perubahan
            idField.setEditable(true); // Mengaktifkan kembali input ID

            // Menampilkan pesan berhasil
            JOptionPane.showMessageDialog(mainPanel, "Data anggota berhasil diperbarui!");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(mainPanel, "Tahun lahir harus berupa angka!");
        }
    }

    // Method untuk menghapus data karyawan
    public void deleteData() {
        int row = peopleTable.getSelectedRow();

        // Memeriksa apakah ada data yng dipilih
        if (row == -1) {
            JOptionPane.showMessageDialog(mainPanel, "Pilih data yang ingin dihapus!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Meminta konfirmasi sebelum menghapus data
        int confirm = JOptionPane.showConfirmDialog(
                mainPanel,
                "Apakah kamu yakin ingin menghapus data ini?",
                "Konfirmasi Hapus",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        // Menghapus data hanya jika pengguna memilih YES
        if (confirm == JOptionPane.YES_OPTION) {
            // Menghapus objek dari ArrayList berdasarkan indeks baris
            peopleList.remove(row);
            // Memperbarui tampilan tabel
            setTable();
            // Mengosongkan Form
            clearForm();
            // Mengaktifkan kembali input ID
            idField.setEditable(true);

            JOptionPane.showMessageDialog(mainPanel, "Data anggota berhasil dihapus!");
        }
    }

    // Method untuk menjalankan aplikasi
    public static void main(String[] args) {

        // Membuat jendela aplikasi dengan judul People Data
        JFrame frame = new JFrame("People Data");

        // Membuat objek PeopleMenu dan menginisialisasi komponen form
        PeopleMenu peopleMenu = new PeopleMenu();

        // Memasukkan panel utama ke dalam jendela aplikasi
        frame.setContentPane(peopleMenu.mainPanel);

        // Menentukan agar aplikasi berhenti ketika jendela ditutup
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Menyesuaikan ukuran jendela dengan komponen di dalamnya
        frame.pack();

        // Menempatkan jendela di tengah layar
        frame.setLocationRelativeTo(null);

        // Menampilkan jendela aplikasi
        frame.setVisible(true);
    }
}
