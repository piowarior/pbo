package main.java.Product;


import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import main.java.DatabaseConnection;
import main.java.Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteProductPage {

    private Stage stage;

    public DeleteProductPage(Stage stage) {
        this.stage = stage;
    }

    public void show() {
        // Create UI components
        VBox form = new VBox(20);
        form.setAlignment(Pos.CENTER);
        form.setStyle("-fx-padding: 20px;");

        // Add background image (using path relative to src/main/java/Product/foto)
        String imagePath = "file:src/main/java/Product/foto/background%20gudang2.jpg";  // URL-encoded space
        form.setStyle("-fx-background-image: url('" + imagePath + "'); -fx-background-size: cover; -fx-background-position: center center;");

        Label instructionLabel = new Label("Hapus produk berdasarkan nomor seri");
        instructionLabel.setStyle("-fx-font-size: 20px; "
                          + "-fx-font-family: 'Arial'; "
                          + "-fx-font-weight: bold; "
                          + "-fx-text-fill: rgb(241, 217, 217); "
                          + "-fx-effect: dropshadow(three-pass-box, black, 5, 0, 1, 1);");

                          TextField txtSeri = new TextField();
                          txtSeri.setPromptText("Masukkan nomor seri produk untuk dihapus");
                          txtSeri.setStyle("-fx-font-size: 16px; -fx-padding: 10px; -fx-background-radius: 5px;");
                          txtSeri.setPrefWidth(300);  // Menentukan lebar preferensi (300px)
                          txtSeri.setMaxWidth(300);   // Menentukan lebar maksimum
                          

        // Delete Product Button
        Button deleteButton = new Button("Hapus Produk");
        deleteButton.setStyle("-fx-background-color: #e74c3c; -fx-text-fill: white; -fx-font-size: 16px; -fx-padding: 10px; -fx-background-radius: 25px;");
        deleteButton.setOnAction(e -> {
            String seri = txtSeri.getText();
            if (seri.isEmpty()) {
                showAlert("Error", "Harap masukkan nomor seri produk.");
            } else {
                deleteProductBySeri(seri);
            }
        });

        // Back Button
        Button backButton = new Button("Kembali ke Halaman Utama");
        backButton.setStyle("-fx-background-color: #3498db; -fx-text-fill: white; -fx-font-size: 16px; -fx-padding: 10px; -fx-background-radius: 25px;");
        backButton.setOnAction(e -> {
            Main mainPage = new Main();
            mainPage.start(stage); // Navigate back to the main page
        });

        // Button hover effects
        deleteButton.setOnMouseEntered(e -> deleteButton.setStyle("-fx-background-color: #c0392b; -fx-text-fill: white; -fx-font-size: 16px; -fx-padding: 10px; -fx-background-radius: 25px;"));
        deleteButton.setOnMouseExited(e -> deleteButton.setStyle("-fx-background-color: #e74c3c; -fx-text-fill: white; -fx-font-size: 16px; -fx-padding: 10px; -fx-background-radius: 25px;"));

        backButton.setOnMouseEntered(e -> backButton.setStyle("-fx-background-color: #2980b9; -fx-text-fill: white; -fx-font-size: 16px; -fx-padding: 10px; -fx-background-radius: 25px;"));
        backButton.setOnMouseExited(e -> backButton.setStyle("-fx-background-color: #3498db; -fx-text-fill: white; -fx-font-size: 16px; -fx-padding: 10px; -fx-background-radius: 25px;"));

        form.getChildren().addAll(instructionLabel, txtSeri, deleteButton, backButton);

        // Layout
        BorderPane layout = new BorderPane();
        layout.setCenter(form);

        // Scene for Delete Product Page with updated background
        Scene deleteProductScene = new Scene(layout, 1700, 800, Color.LIGHTGRAY);
        stage.setTitle("Hapus Produk");
        stage.setScene(deleteProductScene);
        stage.show();
    }

    private void deleteProductBySeri(String seri) {
        String sql = "DELETE FROM produk WHERE seri = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, seri);
            int rowsAffected = statement.executeUpdate();
            
            if (rowsAffected > 0) {
                showAlert("Sukses", "Produk berhasil dihapus.");
            } else {
                showAlert("Error", "Tidak ada produk ditemukan dengan nomor seri yang diberikan.");
            }
        } catch (SQLException e) {
            showAlert("Error", "Terjadi kesalahan saat menghapus produk: " + e.getMessage());
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}