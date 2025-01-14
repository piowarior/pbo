package main.java.Order;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import main.java.DatabaseConnection;

public class AddPesananPage {

    private Stage stage;

    public AddPesananPage(Stage stage) {
        this.stage = stage;
    }

    public void show() {
        // Layout for the page
        VBox layout = new VBox(20);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);

        // Title
        Label title = new Label("Tambah Pesanan");
        title.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        // Fields for pesanan
        TextField namaPelangganField = new TextField();
        namaPelangganField.setPromptText("Nama Pelanggan");

        TextField alamatPengirimField = new TextField();
        alamatPengirimField.setPromptText("Alamat Pengirim");

        TextField seriProdukField = new TextField();
        seriProdukField.setPromptText("Seri Produk (untuk otomatis nama produk)");

        TextField tanggalPesananField = new TextField();
        tanggalPesananField.setPromptText("Tanggal Pesanan (contoh: 2025-01-15)");

        TextField statusPesananField = new TextField();
        statusPesananField.setPromptText("Status Pesanan");

        TextField totalHargaField = new TextField();
        totalHargaField.setPromptText("Total Harga");

        TextField noTeleponField = new TextField();
        noTeleponField.setPromptText("Nomor Telepon");

        // Label untuk menampilkan nama produk otomatis
        Label namaProdukLabel = new Label("Nama Produk: ");
        
        Button submitButton = new Button("Tambah Pesanan");

        submitButton.setOnAction(e -> {
            // Mengambil data dari form
            String namaPelanggan = namaPelangganField.getText();
            String alamatPengirim = alamatPengirimField.getText();
            String seriProduk = seriProdukField.getText();
            String tanggalPesanan = tanggalPesananField.getText();
            String statusPesanan = statusPesananField.getText();
            double totalHarga = Double.parseDouble(totalHargaField.getText());
            String noTelepon = noTeleponField.getText();
            
            // Menambahkan pesanan ke dalam database
            addPesananToDatabase(namaPelanggan, alamatPengirim, seriProduk, tanggalPesanan, statusPesanan, totalHarga, noTelepon);

            // Menghapus produk berdasarkan seri
            deleteProductFromDatabase(seriProduk);

            // Menutup halaman
            stage.close();
        });

        // Menambahkan listener pada seriProdukField untuk mengisi nama produk otomatis
        seriProdukField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.isEmpty()) {
                // Ambil nama produk berdasarkan seri produk dari database
                String namaProduk = getNamaProdukBySeri(newValue);
                namaProdukLabel.setText("Nama Produk: " + namaProduk);
            }
        });

        layout.getChildren().addAll(title, namaPelangganField, alamatPengirimField, 
                                    seriProdukField, tanggalPesananField, statusPesananField, 
                                    totalHargaField, noTeleponField, namaProdukLabel, submitButton);

        Scene scene = new Scene(layout, 400, 400, Color.LIGHTGRAY);
        stage.setScene(scene);
        stage.setTitle("Tambah Pesanan");
        stage.show();
    }

    private void addPesananToDatabase(String namaPelanggan, String alamatPengirim, String seriProduk, 
                                  String tanggalPesanan, String statusPesanan, double totalHarga, 
                                  String noTelepon) {
    // Ambil ID produk berdasarkan seri
    int idProduk = getIdProdukBySeri(seriProduk);
    
    // Jika produk ditemukan (idProduk != 0), lanjutkan dengan menambah pesanan
    if (idProduk != 0) {
        // Menambahkan pesanan ke dalam database
        String sql = "INSERT INTO pesanan_pengiriman (id_produk, nama_pelanggan, alamat_pengirim, no_telepon, tanggal_pesanan, status_pesanan, total_harga, seri_produk, nama_produk) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            // Menyiapkan nilai untuk kolom-kolom dalam tabel pesanan_pengiriman
            statement.setInt(1, idProduk);  // ID Produk
            statement.setString(2, namaPelanggan);  // Nama Pelanggan
            statement.setString(3, alamatPengirim);  // Alamat Pengirim
            statement.setString(4, noTelepon);  // Nomor Telepon
            statement.setString(5, tanggalPesanan);  // Tanggal Pesanan
            statement.setString(6, statusPesanan);  // Status Pesanan
            statement.setDouble(7, totalHarga);  // Total Harga
            statement.setString(8, seriProduk);  // Seri Produk
            statement.setString(9, getNamaProdukBySeri(seriProduk));  // Nama Produk berdasarkan Seri

            statement.executeUpdate();

            // Mengambil generated key (id_pesanan) jika diperlukan untuk pengelolaan lebih lanjut
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int idPesanan = generatedKeys.getInt(1);
                // Setelah pesanan berhasil ditambahkan, Anda bisa menggunakan idPesanan untuk referensi lebih lanjut
            }

            // Menghapus produk dari database setelah dimasukkan ke pesanan_pengiriman
            deleteProductFromDatabase(seriProduk);

        } catch (SQLException e) {
            System.out.println("Error adding pesanan: " + e.getMessage());
        }
    } else {
        System.out.println("Produk dengan seri " + seriProduk + " tidak ditemukan.");
    }
}


    private int getIdProdukBySeri(String seriProduk) {
        String sql = "SELECT id_produk FROM produk WHERE seri = ?";
        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, seriProduk);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("id_produk");
            } else {
                return 0;  // Produk tidak ditemukan
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving product id: " + e.getMessage());
            return 0;
        }
    }


    private void deleteProductFromDatabase(String seriProduk) {
        String sql = "DELETE FROM produk WHERE seri = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, seriProduk);
            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error deleting product: " + e.getMessage());
        }
    }

    private String getNamaProdukBySeri(String seriProduk) {
        String sql = "SELECT nama_produk FROM produk WHERE seri = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, seriProduk);
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                return resultSet.getString("nama_produk");
            } else {
                return "Produk tidak ditemukan";
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving product name: " + e.getMessage());
            return "Error";
        }
    }
}
