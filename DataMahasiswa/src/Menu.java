import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Menu extends JFrame {
    private JTable mahasiswaTable;
    private JTextField nimField, namaField, nilaiField;
    private JComboBox<String> jenisKelaminComboBox;
    private JButton addUpdateButton, deleteButton, cancelButton;
    private JLabel titleLabel;
    private JPanel MainPanel;
    private Connection conn;
    private int selectedIndex = -1;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Menu window = new Menu();
            window.setSize(480, 560);
            window.setLocationRelativeTo(null);
            window.setContentPane(window.MainPanel);
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setVisible(true);
        });
    }

    public Menu() {
        connectDatabase();
        mahasiswaTable = new JTable();
        nimField = new JTextField(15);
        namaField = new JTextField(15);
        nilaiField = new JTextField(5);
        jenisKelaminComboBox = new JComboBox<>(new String[]{"Laki-Laki", "Perempuan"});
        addUpdateButton = new JButton("Add");
        deleteButton = new JButton("Delete");
        cancelButton = new JButton("Cancel");
        titleLabel = new JLabel("Data Mahasiswa");

        MainPanel = new JPanel(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane(mahasiswaTable);
        MainPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel formPanel = new JPanel(new GridLayout(5, 2, 5, 5));
        formPanel.add(new JLabel("NIM"));
        formPanel.add(nimField);
        formPanel.add(new JLabel("Nama"));
        formPanel.add(namaField);
        formPanel.add(new JLabel("Jenis Kelamin"));
        formPanel.add(jenisKelaminComboBox);
        formPanel.add(new JLabel("Nilai"));
        formPanel.add(nilaiField);
        formPanel.add(addUpdateButton);
        formPanel.add(cancelButton);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(deleteButton);
        deleteButton.setVisible(false);

        MainPanel.add(formPanel, BorderLayout.NORTH);
        MainPanel.add(buttonPanel, BorderLayout.SOUTH);

        loadData();
        mahasiswaTable.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                selectedIndex = mahasiswaTable.getSelectedRow();
                if (selectedIndex >= 0) {
                    nimField.setText(mahasiswaTable.getValueAt(selectedIndex, 1).toString());
                    namaField.setText(mahasiswaTable.getValueAt(selectedIndex, 2).toString());
                    jenisKelaminComboBox.setSelectedItem(mahasiswaTable.getValueAt(selectedIndex, 3).toString());
                    nilaiField.setText(mahasiswaTable.getValueAt(selectedIndex, 4).toString());
                    addUpdateButton.setText("Update");
                    deleteButton.setVisible(true);
                }
            }
        });

        addUpdateButton.addActionListener(e -> {
            if (selectedIndex == -1) {
                insertData();
            } else {
                updateData();
            }
        });
        deleteButton.addActionListener(e -> deleteData());
        cancelButton.addActionListener(e -> clearForm());
    }

    private void connectDatabase() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_mahasiswa_dpbo", "root", "");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Koneksi database gagal!");
            e.printStackTrace();
        }
    }

    private void loadData() {
        try {
            DefaultTableModel model = new DefaultTableModel(new String[]{"No", "NIM", "Nama", "Jenis Kelamin", "Nilai"}, 0);
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM mahasiswa");
            ResultSet rs = stmt.executeQuery();
            int no = 1;
            while (rs.next()) {
                model.addRow(new Object[]{no++, rs.getString("nim"), rs.getString("nama"), rs.getString("jenis_kelamin"), rs.getInt("nilai")});
            }
            mahasiswaTable.setModel(model);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void insertData() {
        String nim = nimField.getText();
        String nama = namaField.getText();
        String jenisKelamin = (String) jenisKelaminComboBox.getSelectedItem();
        String nilaiText = nilaiField.getText();

        if (nim.isEmpty() || nama.isEmpty() || nilaiText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Semua field harus diisi!");
            return;
        }

        try {
            int nilai = Integer.parseInt(nilaiText);
            PreparedStatement checkStmt = conn.prepareStatement("SELECT * FROM mahasiswa WHERE nim = ?");
            checkStmt.setString(1, nim);
            ResultSet rs = checkStmt.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "NIM sudah terdaftar!");
                return;
            }
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO mahasiswa (nim, nama, jenis_kelamin, nilai) VALUES (?, ?, ?, ?)");
            stmt.setString(1, nim);
            stmt.setString(2, nama);
            stmt.setString(3, jenisKelamin);
            stmt.setInt(4, nilai);
            stmt.executeUpdate();
            loadData();
            clearForm();
            JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Nilai harus berupa angka!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateData() {
        try {
            PreparedStatement stmt = conn.prepareStatement("UPDATE mahasiswa SET nama = ?, jenis_kelamin = ?, nilai = ? WHERE nim = ?");
            stmt.setString(1, namaField.getText());
            stmt.setString(2, (String) jenisKelaminComboBox.getSelectedItem());
            stmt.setInt(3, Integer.parseInt(nilaiField.getText()));
            stmt.setString(4, nimField.getText());
            stmt.executeUpdate();
            loadData();
            clearForm();
            JOptionPane.showMessageDialog(null, "Data berhasil diubah!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void deleteData() {
        try {
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM mahasiswa WHERE nim = ?");
            stmt.setString(1, nimField.getText());
            stmt.executeUpdate();
            loadData();
            clearForm();
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void clearForm() {
        nimField.setText("");
        namaField.setText("");
        jenisKelaminComboBox.setSelectedIndex(0);
        nilaiField.setText("");
        addUpdateButton.setText("Add");
        deleteButton.setVisible(false);
        selectedIndex = -1;
    }

}
