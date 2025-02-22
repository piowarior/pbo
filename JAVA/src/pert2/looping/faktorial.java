package pert2.looping;

import java.util.Scanner;

public class faktorial {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan sebuah angka: ");
        int angka = input.nextInt();

        int faktorial = 1;
        int i = angka;

        // Looping untuk menghitung faktorial
        while (angka > 0) {
            faktorial *= angka; // Kalikan nilai dengan nilai saat ini
            angka--; // Kurangi dengan satu
        }

        System.out.println("Faktorial dari " + i + " adalah " + faktorial);
        input.close();
    }
}
