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
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.java.Product.DeleteProductPage;
import main.java.Product.EditProductPage;
import main.java.Product.addProductPage;

import main.java.Order.AddPesananPage;


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
        Label homeLabel = new Label("Welcome to the Dashboard!");
        homeLabel.setFont(Font.font("Arial", 18));
        homeContent.getChildren().add(homeLabel);
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

        // Tab for Pesanan/Pengiriman
        Tab pesananTab = new Tab("Pesanan/Pengiriman");
        pesananTab.setClosable(false);
        
        // Button Menu for Pesanan/Pengiriman
        HBox pesananMenu = new HBox(10);
        pesananMenu.setAlignment(Pos.CENTER_LEFT);
        pesananMenu.setPadding(new Insets(10));
        
        Button btnViewPesanan = new Button("Melihat Pesanan");
        Button btnAddPesanan = new Button("Menambahkan Pesanan");
        btnAddPesanan.setOnAction(e -> {
            // Open AddPesananPage when the button is clicked
            AddPesananPage addPesananPage = new AddPesananPage(stage);
            addPesananPage.show();
        });
        
        Button btnEditPesanan = new Button("Mengedit Pesanan");
        // btnEditPesanan.setOnAction(e -> {
        //     EditPesananPage editPesananPage = new EditPesananPage(stage);
        //     editPesananPage.show();
        // });
        
        Button btnDeletePesanan = new Button("Menghapus Pesanan");
        // btnDeletePesanan.setOnAction(e -> {
        //     // Open DeletePesananPage when the button is clicked
        //     DeletePesananPage deletePesananPage = new DeletePesananPage(stage);
        //     deletePesananPage.show();
        // });
        
        // Styling for buttons
        btnViewPesanan.setStyle("-fx-background-color: #2ecc71; -fx-text-fill: white;");
        btnAddPesanan.setStyle("-fx-background-color: #3498db; -fx-text-fill: white;");
        btnEditPesanan.setStyle("-fx-background-color: #f39c12; -fx-text-fill: white;");
        btnDeletePesanan.setStyle("-fx-background-color: #e74c3c; -fx-text-fill: white;"); // Red color for delete
        
        pesananMenu.getChildren().addAll(btnViewPesanan, btnAddPesanan, btnEditPesanan, btnDeletePesanan);
        
        // Table to display Pesanan data
        TableView<Pesanan> pesananTable = new TableView<>();
        pesananTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        // Columns for TableView
        TableColumn<Pesanan, String> namaProdukColumn = new TableColumn<>("Nama Produk");
        namaProdukColumn.setCellValueFactory(cellData -> cellData.getValue().namaProdukProperty());
        
        TableColumn<Pesanan, String> namaPelangganColumn = new TableColumn<>("Nama Pelanggan");
        namaPelangganColumn.setCellValueFactory(cellData -> cellData.getValue().namaPelangganProperty());
        
        TableColumn<Pesanan, String> alamatPengirimColumn = new TableColumn<>("Alamat Pengirim");
        alamatPengirimColumn.setCellValueFactory(cellData -> cellData.getValue().alamatPengirimProperty());
        
        TableColumn<Pesanan, String> seriProdukColumn = new TableColumn<>("Seri Produk");
        seriProdukColumn.setCellValueFactory(cellData -> cellData.getValue().seriProdukProperty());
        
        TableColumn<Pesanan, String> tanggalPesananColumn = new TableColumn<>("Tanggal Pesanan");
        tanggalPesananColumn.setCellValueFactory(cellData -> cellData.getValue().tanggalPesananProperty());
        
        TableColumn<Pesanan, String> statusPesananColumn = new TableColumn<>("Status Pesanan");
        statusPesananColumn.setCellValueFactory(cellData -> cellData.getValue().statusPesananProperty());
        
        TableColumn<Pesanan, Double> totalHargaColumn = new TableColumn<>("Total Harga");
        totalHargaColumn.setCellValueFactory(cellData -> cellData.getValue().totalHargaProperty().asObject());
        
        TableColumn<Pesanan, String> noTeleponColumn = new TableColumn<>("Nomor Telepon");
        noTeleponColumn.setCellValueFactory(cellData -> cellData.getValue().noTeleponProperty());
        
        pesananTable.getColumns().addAll(namaProdukColumn, namaPelangganColumn, alamatPengirimColumn, seriProdukColumn,
                                         tanggalPesananColumn, statusPesananColumn, totalHargaColumn, noTeleponColumn);
        
        // Add pesananMenu and TableView to the Tab content
        VBox pesananContent = new VBox(20);
        pesananContent.setAlignment(Pos.CENTER);
        pesananContent.getChildren().addAll(pesananMenu, pesananTable);
        pesananTab.setContent(pesananContent);
        
        // Load data into the table
        pesananTable.setItems(getPesananPengirimanFromDatabase());

        // Tab for Gudang
        Tab gudangTab = new Tab("Gudang");
        gudangTab.setClosable(false);
        VBox gudangContent = new VBox(20);
        gudangContent.setAlignment(Pos.CENTER);
        Label gudangLabel = new Label("Manajemen Gudang Perusahaan");
        gudangLabel.setFont(Font.font("Arial", 18));
        gudangContent.getChildren().add(gudangLabel);
        gudangTab.setContent(gudangContent);

        // Tab for Analitik
        Tab analitikTab = new Tab("Analitik");
        analitikTab.setClosable(false);
        VBox analitikContent = new VBox(20);
        analitikContent.setAlignment(Pos.CENTER);
        Label analitikLabel = new Label("Analitik Data Gudang");
        analitikLabel.setFont(Font.font("Arial", 18));
        analitikContent.getChildren().add(analitikLabel);
        analitikTab.setContent(analitikContent);

        tabPane.getTabs().addAll(homeTab, produkTab, pesananTab, gudangTab, analitikTab);

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

    private ObservableList<Pesanan> getPesananPengirimanFromDatabase() {
    ObservableList<Pesanan> pesananList = FXCollections.observableArrayList();
    String sql = "SELECT nama_produk, nama_pelanggan, alamat_pengirim, seri_produk, "
               + "tanggal_pesanan, status_pesanan, total_harga, no_telepon "
               + "FROM pesanan_pengiriman";
    
    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql);
         ResultSet resultSet = statement.executeQuery()) {
    
        while (resultSet.next()) {
            String namaProduk = resultSet.getString("nama_produk");
            String namaPelanggan = resultSet.getString("nama_pelanggan");
            String alamatPengirim = resultSet.getString("alamat_pengirim");
            String seriProduk = resultSet.getString("seri_produk");
            String tanggalPesanan = resultSet.getString("tanggal_pesanan");
            String statusPesanan = resultSet.getString("status_pesanan");
            double totalHarga = resultSet.getDouble("total_harga");
            String noTelepon = resultSet.getString("no_telepon");
    
            pesananList.add(new Pesanan(namaProduk, namaPelanggan, alamatPengirim, seriProduk, tanggalPesanan, statusPesanan, totalHarga, noTelepon));
        }
    
    } catch (SQLException e) {
        System.out.println("Gagal mengambil data pesanan: " + e.getMessage());
    }
    
    return pesananList;
}
    
    


    public static void main(String[] args) {
        launch();
    }
}
