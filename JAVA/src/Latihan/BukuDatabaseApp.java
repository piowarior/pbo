package Latihan;

import java.sql.*;
import java.util.Scanner;

public class BukuDatabaseApp {

    // Konfigurasi koneksi database
    private static final String URL = "jdbc:mysql://localhost:3306/game";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Koneksi ke database berhasil!");

            Scanner scanner = new Scanner(System.in);
            int pilihan;

            do {
                System.out.println("\n=== Menu ===");
                System.out.println("1. Tambah Buku");
                System.out.println("2. Lihat Buku");
                System.out.println("3. Update Buku");
                System.out.println("4. Hapus Buku");
                System.out.println("5. Keluar");
                System.out.print("Pilih: ");
                pilihan = scanner.nextInt();
                scanner.nextLine(); // Konsumsi newline

                switch (pilihan) {
                    case 1 -> tambahBuku(conn, scanner);
                    case 2 -> lihatBuku(conn);
                    case 3 -> updateBuku(conn, scanner);
                    case 4 -> hapusBuku(conn, scanner);
                    case 5 -> System.out.println("Keluar program...");
                    default -> System.out.println("Pilihan tidak valid!");
                }
            } while (pilihan != 5);

        } catch (SQLException e) {
            System.err.println("Koneksi ke database gagal: " + e.getMessage());
        }
    }

    private static void tambahBuku(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Masukkan judul buku: ");
        String judul = scanner.nextLine();
        System.out.print("Masukkan penulis: ");
        String penulis = scanner.nextLine();

        String sql = "INSERT INTO buku (judul, penulis) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, judul);
            stmt.setString(2, penulis);
            stmt.executeUpdate();
            System.out.println("Buku berhasil ditambahkan!");
        }
    }

    private static void lihatBuku(Connection conn) throws SQLException {
        String sql = "SELECT * FROM buku";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("\nDaftar Buku:");
            while (rs.next()) {
                System.out.printf("ID: %d, Judul: %s, Penulis: %s%n",
                        rs.getInt("id"), rs.getString("judul"), rs.getString("penulis"));
            }
        }
    }

    private static void updateBuku(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Masukkan ID buku yang ingin diupdate: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Konsumsi newline

        System.out.print("Masukkan judul baru: ");
        String judul = scanner.nextLine();
        System.out.print("Masukkan penulis baru: ");
        String penulis = scanner.nextLine();

        String sql = "UPDATE buku SET judul = ?, penulis = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, judul);
            stmt.setString(2, penulis);
            stmt.setInt(3, id);
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Buku berhasil diupdate!");
            } else {
                System.out.println("ID buku tidak ditemukan.");
            }
        }
    }

    private static void hapusBuku(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Masukkan ID buku yang ingin dihapus: ");
        int id = scanner.nextInt();

        String sql = "DELETE FROM buku WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Buku berhasil dihapus!");
            } else {
                System.out.println("ID buku tidak ditemukan.");
            }
        }
    }
}
