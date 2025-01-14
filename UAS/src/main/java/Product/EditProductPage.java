package main.java.Product;

import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import main.java.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.java.Main;

public class EditProductPage {

    private Stage stage;

    public EditProductPage(Stage stage) {
        this.stage = stage;
    }

    public void show() {
        // Create UI components
        VBox form = new VBox(15);
        form.setAlignment(Pos.CENTER);
        form.setStyle("-fx-padding: 20px;");

        Label instructionLabel = new Label("Edit produk berdasarkan nomor seri");
        instructionLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        TextField txtSeri = new TextField();
        txtSeri.setPromptText("Masukkan nomor seri produk untuk diedit");
        txtSeri.setPrefWidth(300);  // Menentukan lebar preferensi (300px)
        txtSeri.setMaxWidth(300);   // Menentukan lebar maksimum

        // Text fields for product details
        TextField txtNama = new TextField();
        txtNama.setPromptText("Nama Produk");
        txtNama.setPrefWidth(300);  // Menentukan lebar preferensi (300px)
        txtNama.setMaxWidth(300);   // Menentukan lebar maksimum


        TextField txtKategori = new TextField();
        txtKategori.setPromptText("Kategori Produk");
        txtKategori.setPrefWidth(300);  // Menentukan lebar preferensi (300px)
        txtKategori.setMaxWidth(300);   // Menentukan lebar maksimum


        TextField txtHarga = new TextField();
        txtHarga.setPromptText("Harga Produk");
        txtHarga.setPrefWidth(300);  // Menentukan lebar preferensi (300px)
        txtHarga.setMaxWidth(300);   // Menentukan lebar maksimum


        TextField txtDeskripsi = new TextField();
        txtDeskripsi.setPromptText("Deskripsi Produk");
        txtDeskripsi.setPrefWidth(300);  // Menentukan lebar preferensi (300px)
        txtDeskripsi.setMaxWidth(300);   // Menentukan lebar maksimum
        txtDeskripsi.setPrefHeight(100);
        txtDeskripsi.setMaxHeight(100);

        // ComboBox for Gudang (Warehouse)
        Label gudangLabel = new Label("Pilih Gudang:");
        ComboBox<Gudang> gudangComboBox = new ComboBox<>();
        gudangComboBox.setItems(FXCollections.observableArrayList(Gudang.values()));
        gudangComboBox.setPromptText("Pilih Gudang");
        gudangComboBox.setPrefWidth(250);

        // Button to load the product data
        Button loadButton = new Button("Load Produk");
        loadButton.setStyle("-fx-background-color: #1abc9c; -fx-text-fill: white; -fx-cursor: hand;");
        loadButton.setOnMouseEntered(e -> loadButton.setStyle("-fx-background-color: #16a085; -fx-text-fill: white;"));
        loadButton.setOnMouseExited(e -> loadButton.setStyle("-fx-background-color: #1abc9c; -fx-text-fill: white;"));
        loadButton.setOnAction(e -> {
            String seri = txtSeri.getText();
            if (seri.isEmpty()) {
                showAlert("Error", "Harap masukkan nomor seri produk.");
            } else {
                loadProductData(seri, txtNama, txtKategori, txtHarga, txtDeskripsi, gudangComboBox);
            }
        });

        // Button to save changes
        Button saveButton = new Button("Simpan Perubahan");
        saveButton.setStyle("-fx-background-color: #3498db; -fx-text-fill: white; -fx-cursor: hand;");
        saveButton.setOnMouseEntered(e -> saveButton.setStyle("-fx-background-color: #2980b9; -fx-text-fill: white;"));
        saveButton.setOnMouseExited(e -> saveButton.setStyle("-fx-background-color: #3498db; -fx-text-fill: white;"));
        saveButton.setOnAction(e -> {
            String seri = txtSeri.getText();
            String nama = txtNama.getText();
            String kategori = txtKategori.getText();
            String hargaStr = txtHarga.getText();
            String deskripsi = txtDeskripsi.getText();
            Gudang selectedGudang = gudangComboBox.getValue();

            if (seri.isEmpty() || nama.isEmpty() || kategori.isEmpty() || hargaStr.isEmpty() || deskripsi.isEmpty() || selectedGudang == null) {
                showAlert("Error", "Harap lengkapi semua informasi.");
            } else {
                try {
                    double harga = Double.parseDouble(hargaStr);
                    updateProduct(seri, nama, kategori, harga, deskripsi, selectedGudang);
                } catch (NumberFormatException ex) {
                    showAlert("Error", "Harga harus berupa angka.");
                }
            }
        });

        // Button to go back to the main page
        Button backButton = new Button("Kembali ke Halaman Utama");
        backButton.setStyle("-fx-background-color: #e74c3c; -fx-text-fill: white; -fx-cursor: hand;");
        backButton.setOnMouseEntered(e -> backButton.setStyle("-fx-background-color: #c0392b; -fx-text-fill: white;"));
        backButton.setOnMouseExited(e -> backButton.setStyle("-fx-background-color: #e74c3c; -fx-text-fill: white;"));
        backButton.setOnAction(e -> {
            Main mainPage = new Main();
            mainPage.start(stage); // Assuming 'Main' is the main page of your app
        });

        form.getChildren().addAll(instructionLabel, txtSeri, loadButton, txtNama, txtKategori, txtHarga, txtDeskripsi, gudangLabel, gudangComboBox, saveButton, backButton);

        // Layout
        BorderPane layout = new BorderPane();
        layout.setCenter(form);

        // Scene for Edit Product Page with new size
        Scene scene = new Scene(layout, 1700, 800, Color.LIGHTGRAY);
        stage.setTitle("MJD Stock Management System");
        stage.setScene(scene);
        stage.show();
    }

    private void loadProductData(String seri, TextField txtNama, TextField txtKategori, TextField txtHarga, TextField txtDeskripsi, ComboBox<Gudang> gudangComboBox) {
        String sql = "SELECT * FROM produk WHERE seri = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, seri);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                txtNama.setText(resultSet.getString("nama_produk"));
                txtKategori.setText(resultSet.getString("kategori"));
                txtHarga.setText(String.valueOf(resultSet.getDouble("harga")));
                txtDeskripsi.setText(resultSet.getString("deskripsi"));
                int gudangId = resultSet.getInt("id_gudang");
                for (Gudang gudang : Gudang.values()) {
                    if (gudang.getIdGudang() == gudangId) {
                        gudangComboBox.setValue(gudang);
                        break;
                    }
                }
            } else {
                showAlert("Error", "Produk dengan nomor seri tersebut tidak ditemukan.");
            }

        } catch (SQLException e) {
            showAlert("Error", "Terjadi kesalahan saat memuat data produk: " + e.getMessage());
        }
    }

    private void updateProduct(String seri, String nama, String kategori, double harga, String deskripsi, Gudang selectedGudang) {
        String sql = "UPDATE produk SET nama_produk = ?, kategori = ?, harga = ?, deskripsi = ?, id_gudang = ? WHERE seri = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nama);
            statement.setString(2, kategori);
            statement.setDouble(3, harga);
            statement.setString(4, deskripsi);
            statement.setInt(5, selectedGudang.getIdGudang());
            statement.setString(6, seri);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                showAlert("Sukses", "Produk berhasil diperbarui.");
            } else {
                showAlert("Error", "Tidak ada produk ditemukan dengan nomor seri yang diberikan.");
            }

        } catch (SQLException e) {
            showAlert("Error", "Terjadi kesalahan saat memperbarui produk: " + e.getMessage());
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
