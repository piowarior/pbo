package pert13.Latihan;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Buku {
    private String judul;
    private String penulis;
    private String isbn;

    public Buku(String judul, String penulis, String isbn) {
        this.judul = judul;
        this.penulis = penulis;
        this.isbn = isbn;
    }

    public String getJudul() { return judul; }
    public String getPenulis() { return penulis; }
    public String getIsbn() { return isbn; }

    @Override
    public String toString() {
        return "Judul: " + judul + ", Penulis: " + penulis + ", ISBN: " + isbn;
    }
}

public class ManajemenPerpustakaan {
    public static void main(String[] args) {
        ArrayList<Buku> perpustakaan = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\nMenu Perpustakaan:");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Tampilkan Semua Buku");
            System.out.println("3. Cari Buku Berdasarkan Judul");
            System.out.println("4. Hapus Buku Berdasarkan ISBN");
            System.out.println("5. Urutkan Buku Berdasarkan Judul");
            System.out.println("6. Keluar");
            System.out.print("Masukkan pilihan Anda: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan judul buku: ");
                    String judul = scanner.nextLine();
                    System.out.print("Masukkan nama penulis: ");
                    String penulis = scanner.nextLine();
                    System.out.print("Masukkan ISBN: ");
                    String isbn = scanner.nextLine();
                    perpustakaan.add(new Buku(judul, penulis, isbn));
                    System.out.println("Buku berhasil ditambahkan!");
                    break;

                case 2:
                    if (perpustakaan.isEmpty()) {
                        System.out.println("Tidak ada buku yang tersedia.");
                    } else {
                        for (Buku buku : perpustakaan) {
                            System.out.println(buku);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Masukkan judul untuk mencari: ");
                    String cariJudul = scanner.nextLine().toLowerCase();
                    boolean ditemukan = false;
                    for (Buku buku : perpustakaan) {
                        if (buku.getJudul().toLowerCase().contains(cariJudul)) {
                            System.out.println(buku);
                            ditemukan = true;
                        }
                    }
                    if (!ditemukan) {
                        System.out.println("Tidak ada buku yang ditemukan.");
                    }
                    break;

                case 4:
                    System.out.print("Masukkan ISBN untuk dihapus: ");
                    String isbnHapus = scanner.nextLine();
                    boolean dihapus = perpustakaan.removeIf(buku -> buku.getIsbn().equals(isbnHapus));
                    if (dihapus) {
                        System.out.println("Buku berhasil dihapus!");
                    } else {
                        System.out.println("Buku tidak ditemukan.");
                    }
                    break;

                case 5:
                    Collections.sort(perpustakaan, Comparator.comparing(Buku::getJudul));
                    System.out.println("Buku telah diurutkan berdasarkan judul.");
                    break;

                case 6:
                    System.out.println("Keluar dari program.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid! Silakan coba lagi.");
            }
        } while (pilihan != 6);

        scanner.close();
    }
}
