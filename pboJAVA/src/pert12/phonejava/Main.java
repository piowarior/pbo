package pert12.phonejava;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Phone xiaomi = new Xiaomi();
        Phone iphone = new iPhone();
        Phone samsung = new Samsung();
        Phone oppo = new Oppo();

        PhoneUser user = null;

        System.out.println("Pilih Ponsel yang Ingin Digunakan:");
        System.out.println("1. Xiaomi");
        System.out.println("2. iPhone");
        System.out.println("3. Samsung");
        System.out.println("4. Oppo");
        System.out.print("Masukkan pilihan Anda: ");
        int phoneChoice = input.nextInt();

        switch (phoneChoice) {
            case 1:
                user = new PhoneUser(xiaomi);
                System.out.println("Menggunakan Xiaomi...");
                break;
            case 2:
                user = new PhoneUser(iphone);
                System.out.println("Menggunakan iPhone...");
                break;
            case 3:
                user = new PhoneUser(samsung);
                System.out.println("Menggunakan Samsung...");
                break;
            case 4:
                user = new PhoneUser(oppo);
                System.out.println("Menggunakan Oppo...");
                break;
            default:
                System.out.println("Pilihan tidak valid. Program berhenti.");
                System.exit(0);
        }

        int option;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Nyalakan Ponsel");
            System.out.println("2. Matikan Ponsel");
            System.out.println("3. Volume Naik");
            System.out.println("4. Volume Turun");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            option = input.nextInt();

            switch (option) {
                case 1:
                    user.turnOnThePhone();
                    break;
                case 2:
                    user.turnOffThePhone();
                    break;
                case 3:
                    user.makePhoneLouder();
                    break;
                case 4:
                    user.makePhoneSilent();
                    break;
                case 0:
                    System.out.println("Keluar...");
                    break;
                default:
                    System.out.println("Menu tidak valid!");
            }
        } while (option != 0);

        input.close();
    }
}
