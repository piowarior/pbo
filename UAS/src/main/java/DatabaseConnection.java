package main.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // Gantilah dengan kredensial database Anda
    private static final String URL = "jdbc:mysql://localhost:3306/manajemen_gudang";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // Method untuk membuat koneksi ke database
    public static Connection getConnection() {
        Connection connection = null;
        try {
            // Memuat driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Membuat koneksi
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Koneksi ke database berhasil!");

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Koneksi ke database gagal: " + e.getMessage());
        }
        return connection;
    }

    // Menutup koneksi
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Koneksi ditutup.");
            } catch (SQLException e) {
                System.out.println("Gagal menutup koneksi: " + e.getMessage());
            }
        }
    }

    
}
