package prak_sesi2;

import java.util.Scanner;

public class indexs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalHarga = 0;
        String pesanan;
        int pilihan;
        int saldo = 150000;

        boolean pembayaranBerhasil = false;

        String[] menu = {
            "Nasi Goreng - Rp 20.000",
            "Mie Goreng - Rp 15.000",
            "Ayam Bakar - Rp 25.000",
            "Jus Jeruk - Rp 10.000",
            "Teh Manis - Rp 5.000"
        };

        System.out.println("Selamat datang di Restoran Sederhana!");
        System.out.println("Saldo Anda saat ini: Rp " + saldo);
        System.out.println("Menu:");

        for (int i = 0; i < menu.length; i++) {
            System.out.println((i + 1) + ". " + menu[i]);
        }

        while (!pembayaranBerhasil) {
            totalHarga = 0;

            do {
                System.out.println("\nPilih menu dengan memasukkan nomor (1-5), atau 0 untuk selesai:");
                pilihan = scanner.nextInt();

                switch (pilihan) {
                    case 1:
                        totalHarga += 20000;
                        pesanan = "Nasi Goreng";
                        System.out.println(pesanan + " telah ditambahkan ke pesanan Anda.");
                        break;
                    case 2:
                        totalHarga += 15000;
                        pesanan = "Mie Goreng";
                        System.out.println(pesanan + " telah ditambahkan ke pesanan Anda.");
                        break;
                    case 3:
                        totalHarga += 25000;
                        pesanan = "Ayam Bakar";
                        System.out.println(pesanan + " telah ditambahkan ke pesanan Anda.");
                        break;
                    case 4:
                        totalHarga += 10000;
                        pesanan = "Jus Jeruk";
                        System.out.println(pesanan + " telah ditambahkan ke pesanan Anda.");
                        break;
                    case 5:
                        totalHarga += 5000;
                        pesanan = "Teh Manis";
                        System.out.println(pesanan + " telah ditambahkan ke pesanan Anda.");
                        break;
                    case 0:
                        System.out.println("Selesai memesan.");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                        break;
                }
            } while (pilihan != 0);

            if (totalHarga > 0) {
                System.out.println("\nTotal harga pesanan Anda: Rp " + totalHarga);
            } else {
                System.out.println("Anda tidak memesan apa pun.");
                continue;
            }

            System.out.print("Masukkan jumlah uang yang ingin Anda bayarkan: Rp ");
            int bayar = scanner.nextInt();

            if (bayar < totalHarga) {
                System.out.println("Uang Anda tidak cukup! Pembayaran gagal.");
                System.out.println("Silakan ulangi pemesanan.");
            } else {
                saldo -= totalHarga;
                System.out.println("Pembayaran berhasil! Sisa saldo Anda: Rp " + saldo);
                pembayaranBerhasil = true;
            }
        }

        scanner.close();
    }
}
