package main.java;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.java.Product.DeleteProductPage;
import main.java.Product.EditProductPage;
import main.java.Product.addProductPage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        // Header
        HBox header = new HBox();
        header.setPadding(new Insets(10));
        header.setSpacing(20);
        header.setStyle("-fx-background-color:rgb(64, 92, 121); -fx-padding: 10px;");

        Label appName = new Label("MJD Stock");
        appName.setFont(Font.font("Verdana", 24));
        appName.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");

        HBox menuBar = new HBox(15);
        menuBar.setPadding(new Insets(0, 0, 0, 10));
        menuBar.setAlignment(Pos.CENTER_LEFT);
        Button aboutButton = new Button("About");
        Label contactLabel = new Label("Contact");
        Label servicesLabel = new Label("Services");
        Label helpLabel = new Label("Help");
        aboutButton.setFont(Font.font("Arial", 16));
        aboutButton.setStyle("-fx-background-color: transparent; -fx-text-fill: white;");
        aboutButton.setOnAction(e -> {
            AboutPage aboutPage = new AboutPage(stage);
            aboutPage.show();
        });
        contactLabel.setFont(Font.font("Arial", 16));
        contactLabel.setStyle("-fx-text-fill: white;");
        servicesLabel.setFont(Font.font("Arial", 16));
        servicesLabel.setStyle("-fx-text-fill: white;");
        helpLabel.setFont(Font.font("Arial", 16));
        helpLabel.setStyle("-fx-text-fill: white;");
        menuBar.getChildren().addAll(aboutButton, contactLabel, servicesLabel, helpLabel);

        Button loginButton = new Button("Login");
        loginButton.setFont(Font.font("Arial", 16));
        loginButton.setStyle("-fx-background-color: yellow; -fx-text-fill: black;");

        HBox rightBox = new HBox(20, menuBar, loginButton);
        rightBox.setAlignment(Pos.CENTER_RIGHT);
        HBox.setHgrow(rightBox, Priority.ALWAYS);

        header.getChildren().addAll(appName, rightBox);
        header.setAlignment(Pos.CENTER_LEFT);

        // Sidebar Menu
        VBox sidebar = new VBox(15);
        sidebar.setPadding(new Insets(20));
        sidebar.setStyle("-fx-background-color: #34495e; -fx-text-fill: white;");
        sidebar.setAlignment(Pos.TOP_CENTER);

        Button btnProfile = new Button("Profile");
        Button btnSettings = new Button("Pengaturan");
        Button btnLogout = new Button("Logout");

        for (Button button : new Button[]{btnProfile, btnSettings, btnLogout}) {
            button.setFont(Font.font("Arial", 16));
            button.setStyle("-fx-background-color: transparent; -fx-text-fill: white; -fx-alignment: center-left;");
            button.setMaxWidth(Double.MAX_VALUE);

            button.setOnMouseEntered(e -> button.setStyle("-fx-background-color: #1abc9c; -fx-text-fill: white; -fx-alignment: center-left;"));
            button.setOnMouseExited(e -> button.setStyle("-fx-background-color: transparent; -fx-text-fill: white; -fx-alignment: center-left;"));
        }

        sidebar.getChildren().addAll(btnProfile, btnSettings, btnLogout);

        // Main Content Area
        TabPane tabPane = new TabPane();

        // Tab for Home
        Tab homeTab = new Tab("Home");
        homeTab.setClosable(false);

        VBox homeContent = new VBox(20);
        homeContent.setAlignment(Pos.CENTER);
        homeContent.setPadding(new Insets(20));

        // Logo placeholder
        Label logo = new Label("\u26A1"); // Unicode character as a logo placeholder
        logo.setFont(Font.font("Verdana", 60));
        logo.setStyle("-fx-text-fill: #2ecc71;"); // Green color

        // Company name
        Label companyName = new Label("MJD Stock Management System");
        companyName.setFont(Font.font("Verdana", 28));
        companyName.setStyle("-fx-font-weight: bold; -fx-text-fill: #34495e;");

        // Description text
        Label description = new Label("MJD Stock Management System adalah solusi terbaik untuk pengelolaan produk dan gudang Anda.\nKami membantu Anda meningkatkan efisiensi dan transparansi dalam manajemen inventaris.");
        description.setFont(Font.font("Arial", 16));
        description.setStyle("-fx-text-fill: #7f8c8d;");
        description.setWrapText(true);
        description.setTextAlignment(TextAlignment.CENTER);

        // Features section
        VBox featuresBox = new VBox(10);
        featuresBox.setAlignment(Pos.CENTER);
        featuresBox.setPadding(new Insets(10));
        Label featuresTitle = new Label("Fitur Unggulan:");
        featuresTitle.setFont(Font.font("Arial", 18));
        featuresTitle.setStyle("-fx-font-weight: bold; -fx-text-fill: #34495e;");

        Label feature1 = new Label("✔ Pengelolaan produk yang mudah dan efisien.");
        feature1.setFont(Font.font("Arial", 14));
        feature1.setStyle("-fx-text-fill: #2ecc71;");

        Label feature2 = new Label("✔ Pemantauan stok secara real-time.");
        feature2.setFont(Font.font("Arial", 14));
        feature2.setStyle("-fx-text-fill: #2ecc71;");

        Label feature3 = new Label("✔ Analitik data gudang yang mendalam.");
        feature3.setFont(Font.font("Arial", 14));
        feature3.setStyle("-fx-text-fill: #2ecc71;");

        featuresBox.getChildren().addAll(featuresTitle, feature1, feature2, feature3);

        // Testimonials section
        VBox testimonialsBox = new VBox(10);
        testimonialsBox.setAlignment(Pos.CENTER);
        testimonialsBox.setPadding(new Insets(10));
        Label testimonialsTitle = new Label("Apa Kata Pengguna Kami:");
        testimonialsTitle.setFont(Font.font("Arial", 18));
        testimonialsTitle.setStyle("-fx-font-weight: bold; -fx-text-fill: #34495e;");

        Label testimonial1 = new Label("\"Sistem ini sangat membantu bisnis saya dalam mengelola stok produk.\" - John Doe");
        testimonial1.setFont(Font.font("Arial", 14));
        testimonial1.setStyle("-fx-text-fill: #7f8c8d;");

        Label testimonial2 = new Label("\"Analitik yang disediakan sangat berguna untuk pengambilan keputusan.\" - Jane Smith");
        testimonial2.setFont(Font.font("Arial", 14));
        testimonial2.setStyle("-fx-text-fill: #7f8c8d;");

        testimonialsBox.getChildren().addAll(testimonialsTitle, testimonial1, testimonial2);

        // Contact info
        Label contactInfo = new Label("Hubungi kami: support@mjdstock.com | +62 123 456 789");
        contactInfo.setFont(Font.font("Arial", 14));
        contactInfo.setStyle("-fx-text-fill: #95a5a6;");
        contactInfo.setTextAlignment(TextAlignment.CENTER);

        homeContent.getChildren().addAll(logo, companyName, description, featuresBox, testimonialsBox, contactInfo);
        homeTab.setContent(homeContent);


        // Tab for Produk
        Tab produkTab = new Tab("Produk");
        produkTab.setClosable(false);

        // Button Menu for Produk
        HBox produkMenu = new HBox(10);
        produkMenu.setAlignment(Pos.CENTER_LEFT);
        produkMenu.setPadding(new Insets(10));

        Button btnViewProduk = new Button("Melihat Produk");
        Button btnAddProduk = new Button("Menambahkan Produk");
        btnAddProduk.setOnAction(e -> {
            // Open AddProductPage when the button is clicked
            addProductPage addProductPage = new addProductPage(stage);
            addProductPage.show();
        });        

        Button btnEditProduk = new Button("Mengedit Produk");
        btnEditProduk.setOnAction(e -> {
        EditProductPage editProductPage = new EditProductPage(stage);
        editProductPage.show();
        });

        Button btnDeleteProduk = new Button("Menghapus Produk");
        btnDeleteProduk.setOnAction(e -> {
            // Open DeleteProductPage when the button is clicked
        DeleteProductPage deleteProductPage = new DeleteProductPage(stage);
        deleteProductPage.show();
       });

        // Styling for buttons
        btnViewProduk.setStyle("-fx-background-color: #2ecc71; -fx-text-fill: white;");
        btnAddProduk.setStyle("-fx-background-color: #3498db; -fx-text-fill: white;");
        btnEditProduk.setStyle("-fx-background-color: #f39c12; -fx-text-fill: white;");
        btnDeleteProduk.setStyle("-fx-background-color: #e74c3c; -fx-text-fill: white;"); // Red color for delete

        produkMenu.getChildren().addAll(btnViewProduk, btnAddProduk, btnEditProduk, btnDeleteProduk);

    
        // Table to display Produk data
        TableView<Produk> produkTable = new TableView<>();
        produkTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        // Columns for TableView
        TableColumn<Produk, String> namaColumn = new TableColumn<>("Nama Produk");
        namaColumn.setCellValueFactory(cellData -> cellData.getValue().namaProperty());

        TableColumn<Produk, String> kategoriColumn = new TableColumn<>("Kategori");
        kategoriColumn.setCellValueFactory(cellData -> cellData.getValue().kategoriProperty());

        TableColumn<Produk, Double> hargaColumn = new TableColumn<>("Harga");
        hargaColumn.setCellValueFactory(cellData -> cellData.getValue().hargaProperty().asObject());

        TableColumn<Produk, String> deskripsiColumn = new TableColumn<>("Deskripsi");
        deskripsiColumn.setCellValueFactory(cellData -> cellData.getValue().deskripsiProperty());

        TableColumn<Produk, String> gudangColumn = new TableColumn<>("Nama Gudang");
        gudangColumn.setCellValueFactory(cellData -> cellData.getValue().namaGudangProperty());

        TableColumn<Produk, String> lokasiGudangColumn = new TableColumn<>("Lokasi Gudang");
        lokasiGudangColumn.setCellValueFactory(cellData -> cellData.getValue().lokasiGudangProperty());

        TableColumn<Produk, String> seriColumn = new TableColumn<>("Seri");
        seriColumn.setCellValueFactory(cellData -> cellData.getValue().seriProperty());

        produkTable.getColumns().addAll(namaColumn, kategoriColumn, hargaColumn, deskripsiColumn, gudangColumn, lokasiGudangColumn, seriColumn);

        // Add products to TableView
        produkTable.setItems(getProdukFromDatabase());

        // Add produkMenu and TableView to the Tab content
        VBox produkContent = new VBox(20);
        produkContent.setAlignment(Pos.CENTER);
        produkContent.getChildren().addAll(produkMenu, produkTable);
        produkTab.setContent(produkContent);

       
        // Tab for Gudang
        // Tab Gudang dengan TableView untuk menampilkan data gudang
        Tab gudangTab = new Tab("Gudang");
        gudangTab.setClosable(false);

        // Membuat TableView untuk menampilkan data Gudang
        TableView<Gudang> gudangTable = new TableView<>();
        gudangTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        // Definisi Kolom
        TableColumn<Gudang, Integer> idColumn = new TableColumn<>("ID Gudang");
        idColumn.setCellValueFactory(cellData -> cellData.getValue().idGudangProperty().asObject());

        TableColumn<Gudang, String> namaColumn2 = new TableColumn<>("Nama Gudang");
        namaColumn2.setCellValueFactory(cellData -> cellData.getValue().namaGudangProperty());

        TableColumn<Gudang, String> lokasiColumn = new TableColumn<>("Lokasi Gudang");
        lokasiColumn.setCellValueFactory(cellData -> cellData.getValue().lokasiGudangProperty());

        TableColumn<Gudang, Integer> kapasitasColumn = new TableColumn<>("Kapasitas");
        kapasitasColumn.setCellValueFactory(cellData -> cellData.getValue().kapasitasProperty().asObject());

        TableColumn<Gudang, String> tanggalColumn = new TableColumn<>("Tanggal Ditambahkan");
        tanggalColumn.setCellValueFactory(cellData -> cellData.getValue().tanggalDitambahkanProperty());

        // Menambahkan kolom ke dalam tabel
        gudangTable.getColumns().addAll(idColumn, namaColumn2, lokasiColumn, kapasitasColumn, tanggalColumn);


        // Membungkus TableView ke dalam VBox
        VBox gudangContent = new VBox(20);
        gudangContent.setAlignment(Pos.CENTER);
        gudangContent.getChildren().addAll(gudangTable);
        gudangTab.setContent(gudangContent);


        // Menambahkan data dari database ke TableView
        gudangTable.setItems(getGudangFromDatabase());

        gudangTab.setContent(new VBox(gudangTable));

        // Tab for Analitik
        Tab analitikTab = new Tab("Analitik");
        analitikTab.setClosable(false);
        VBox analitikContent = new VBox(20);
        analitikContent.setAlignment(Pos.CENTER);
        Label analitikLabel = new Label("Analitik Data Gudang");
        analitikLabel.setFont(Font.font("Arial", 18));
        analitikContent.getChildren().add(analitikLabel);
        analitikTab.setContent(analitikContent);

        tabPane.getTabs().addAll(homeTab, produkTab,  gudangTab, analitikTab);

        // Footer
        Label footerLabel = new Label("Hak Cipta 2025 - MJD Stock Management System");
        footerLabel.setFont(Font.font("Arial", 12));
        footerLabel.setStyle("-fx-background-color: #2c3e50; -fx-text-fill: white; -fx-padding: 10px; -fx-alignment: center;");

        // Layout Main
        BorderPane layout = new BorderPane();
        layout.setTop(new VBox(header)); // Header + Secondary Navbar
        layout.setLeft(sidebar);
        layout.setCenter(tabPane);
        layout.setBottom(footerLabel);

        // Scene and Stage
        Scene scene = new Scene(layout, 1700, 800, Color.LIGHTGRAY);
        stage.setTitle("MJD Stock Management System");
        stage.setScene(scene);
        stage.show();
    }

    private ObservableList<Produk> getProdukFromDatabase() {
        ObservableList<Produk> produkList = FXCollections.observableArrayList();
        String sql = "SELECT p.nama_produk, p.kategori, p.harga, p.deskripsi, "
                   + "IFNULL(g.nama_gudang, 'Tidak Ditemukan') AS nama_gudang, "
                   + "IFNULL(g.lokasi_gudang, 'Tidak Ditemukan') AS lokasi_gudang, "
                   + "p.seri "
                   + "FROM produk p "
                   + "LEFT JOIN gudang g ON p.id_gudang = g.id_gudang"; // Menggunakan LEFT JOIN agar tetap mengambil produk meski tidak ada id_gudang
    
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
    
            while (resultSet.next()) {
                String namaProduk = resultSet.getString("nama_produk");
                String kategori = resultSet.getString("kategori");
                double harga = resultSet.getDouble("harga");
                String deskripsi = resultSet.getString("deskripsi");
                String namaGudang = resultSet.getString("nama_gudang");
                String lokasiGudang = resultSet.getString("lokasi_gudang");
                String seri = resultSet.getString("seri");
                produkList.add(new Produk(namaProduk, kategori, harga, deskripsi, namaGudang, lokasiGudang, seri));
            }
    
        } catch (SQLException e) {
            System.out.println("Gagal mengambil data produk: " + e.getMessage());
        }
    
        return produkList;
    }

    

private ObservableList<Gudang> getGudangFromDatabase() {
    ObservableList<Gudang> gudangList = FXCollections.observableArrayList();
    String sql = "SELECT * FROM gudang";

    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql);
         ResultSet resultSet = statement.executeQuery()) {

        while (resultSet.next()) {
            int idGudang = resultSet.getInt("id_gudang");
            String namaGudang = resultSet.getString("nama_gudang");
            String lokasiGudang = resultSet.getString("lokasi_gudang");
            int kapasitas = resultSet.getInt("kapasitas");
            String tanggalDitambahkan = resultSet.getString("tanggal_ditambahkan");

            gudangList.add(new Gudang(idGudang, namaGudang, lokasiGudang, kapasitas, tanggalDitambahkan));
        }

    } catch (SQLException e) {
        System.out.println("Gagal mengambil data gudang: " + e.getMessage());
    }

    return gudangList;
}

    


    public static void main(String[] args) {
        launch();
    }
}
