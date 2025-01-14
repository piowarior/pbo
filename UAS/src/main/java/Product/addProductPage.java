package main.java.Product;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import main.java.Product.Gudang;
import main.java.Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import main.java.DatabaseConnection;


public class addProductPage {

    private final Stage stage;

    public addProductPage(Stage stage) {
        this.stage = stage;
    }

    public void show() {
        // Form Content
        Label titleLabel = new Label("Add New Product");
        titleLabel.setFont(Font.font("Arial", 24));
        titleLabel.setStyle("-fx-text-fill: black;");

        // Label and TextField for each input field
        Label namaLabel = new Label("Nama Produk:");
        TextField namaField = new TextField();

        Label kategoriLabel = new Label("Kategori:");
        TextField kategoriField = new TextField();

        Label hargaLabel = new Label("Harga:");
        TextField hargaField = new TextField();

        Label deskripsiLabel = new Label("Deskripsi:");
        TextField deskripsiField = new TextField();

        Label seriLabel = new Label("Seri:");
        TextField seriField = new TextField();

        // ComboBox for Gudang
        Label gudangLabel = new Label("Pilih Gudang:");
        ComboBox<Gudang> gudangComboBox = new ComboBox<>();
        gudangComboBox.setItems(FXCollections.observableArrayList(Gudang.values()));
        gudangComboBox.setPromptText("Pilih Gudang");

        // Add fields to the form
        VBox form = new VBox(10);
        form.setAlignment(Pos.CENTER);
        form.setPadding(new Insets(20));
        form.getChildren().addAll(namaLabel, namaField, kategoriLabel, kategoriField, hargaLabel, hargaField, deskripsiLabel, deskripsiField, gudangLabel, gudangComboBox, seriLabel, seriField);

        // Button to save product
        Button saveButton = new Button("Simpan Produk");
        saveButton.setStyle("-fx-background-color: #2ecc71; -fx-text-fill: white;");
        saveButton.setOnAction(e -> {
            Gudang selectedGudang = gudangComboBox.getValue();
            if (selectedGudang != null) {
                saveProduct(
                    namaField.getText(),
                    kategoriField.getText(),
                    Double.parseDouble(hargaField.getText()),
                    deskripsiField.getText(),
                    selectedGudang.getIdGudang(),
                    seriField.getText()
                );
                System.out.println("Produk berhasil ditambahkan!");
            } else {
                System.out.println("Gudang belum dipilih!");
            }
        });

        // Button to go back to the main page
        Button backButton = new Button("Kembali ke Halaman Utama");
        backButton.setStyle("-fx-background-color: #3498db; -fx-text-fill: white;");
        backButton.setOnAction(e -> {
            Main mainPage = new Main();
            mainPage.start(stage); // Assuming 'Main' is the main page of your app
        });

        form.getChildren().addAll(saveButton, backButton);

        // Layout
        BorderPane layout = new BorderPane();
        layout.setCenter(form);

        // Scene for Add Product Page
        Scene addProductScene = new Scene(layout, 800, 600, Color.LIGHTGRAY);
        stage.setScene(addProductScene);
        stage.show();
    }

    private void saveProduct(String nama, String kategori, double harga, String deskripsi, int idGudang, String seri) {
        String sql = "INSERT INTO produk (nama_produk, kategori, harga, deskripsi, id_gudang, seri) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, nama);
            statement.setString(2, kategori);
            statement.setDouble(3, harga);
            statement.setString(4, deskripsi);
            statement.setInt(5, idGudang);
            statement.setString(6, seri);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Produk berhasil ditambahkan!");
            }
        } catch (SQLException e) {
            System.out.println("Gagal menambahkan produk: " + e.getMessage());
        }
    }
}