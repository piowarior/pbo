package pert1;

import java.util.Scanner;

public class Aritmatika {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean lanjut = true;

        while (lanjut) {
            System.out.print("Masukkan angka pertama: ");
            double angka1 = input.nextDouble();

            System.out.print("Masukkan angka kedua: ");
            double angka2 = input.nextDouble();

            System.out.println("\nPilih operasi yang ingin dilakukan (+, -, *, /): ");
            String operasi = input.next();

            double hasil = 0;
            boolean valid = true;

            switch (operasi) {
                case "+":
                    hasil = angka1 + angka2;
                    System.out.println("Hasil Penjumlahan: " + hasil);
                    break;
                case "-":
                    hasil = angka1 - angka2;
                    System.out.println("Hasil Pengurangan: " + hasil);
                    break;
                case "*":
                    hasil = angka1 * angka2;
                    System.out.println("Hasil Perkalian: " + hasil);
                    break;
                case "/":
                    if (angka2 != 0) {
                        hasil = angka1 / angka2;
                        System.out.println("Hasil Pembagian: " + hasil);
                    } else {
                        System.out.println("Error: Pembagian dengan nol tidak diperbolehkan.");
                        valid = false;
                    }
                    break;
                default:
                    System.out.println("Operasi tidak valid.");
                    valid = false;
            }

            System.out.print("\nApakah ingin melakukan perhitungan lagi? (y/n): ");
            String pilihan = input.next();

            if (!pilihan.equalsIgnoreCase("y")) {
                lanjut = false;
                System.out.println("Terima kasih telah menggunakan kalkulator!");
            }
        }

        input.close();


    }
}
