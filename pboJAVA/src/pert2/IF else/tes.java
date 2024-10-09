package sesi4;

import java.util.Scanner;

public class tes {
    public static void main(String[] args) {
        // Membuat Scanner untuk input dari pengguna
        Scanner input = new Scanner(System.in);
        
        // Menggunakan tipe data int dan double
        int pilihan;
        double hasil = 0;

        System.out.println("Pilih operasi yang diinginkan:");
        System.out.println("1. Penjumlahan");
        System.out.println("2. Pengurangan");
        System.out.println("3. Perkalian");
        System.out.println("4. Pembagian");
        
        // Menggunakan if untuk validasi input
        if (input.hasNextInt()) {
            pilihan = input.nextInt();
        } else {
            System.out.println("Input tidak valid. Harus angka.");
            return;
        }

        System.out.print("Masukkan angka pertama: ");
        double angka1 = input.nextDouble();
        System.out.print("Masukkan angka kedua: ");
        double angka2 = input.nextDouble();

        // Menggunakan switch untuk memilih operasi aritmatika
        switch (pilihan) {
            case 1:
                hasil = angka1 + angka2;
                break;
            case 2:
                hasil = angka1 - angka2;
                break;
            case 3:
                hasil = angka1 * angka2;
                break;
            case 4:
                if (angka2 != 0) {
                    hasil = angka1 / angka2;
                } else {
                    System.out.println("Error: Pembagian dengan nol!");
                    return;
                }
                break;
            default:
                System.out.println("Pilihan tidak valid.");
                return;
        }

        // Menampilkan hasil operasi
        System.out.println("Hasil: " + hasil);
        
        // Menggunakan for loop untuk menampilkan angka 1-5
        System.out.println("\nLoop for dari 1 sampai 5:");
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
        }

        // Menggunakan while loop untuk menghitung mundur dari 5
        int counter = 5;
        System.out.println("\nLoop while countdown dari 5:");
        while (counter > 0) {
            System.out.println(counter);
            counter--;
        }

        // Menggunakan do-while untuk memastikan loop dijalankan setidaknya sekali
        System.out.println("\nLoop do-while:");
        int angka = 10;
        do {
            System.out.println("Angka: " + angka);
            angka--;
        } while (angka > 5);
    }
}
