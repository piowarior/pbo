package sesi4;

import java.util.Scanner;

public class cekkelulusan {
    public static void main(String[] args) {
        //membuat variabel dan scanner
        int nilai;
        String nama;
        Scanner scan = new Scanner(System.in);
        //mengambil input
        System.out.print("Nama : "); nama = scan.nextLine();
        System.out.print("Nilai : "); nilai = scan.nextInt();
        //Cek apakah dia lulus atau tidak
        if (nilai >= 70) {
            System.out.println("Selamat " + nama + ", Anda Lulus");
        } else {
            System.out.println("Maaf " + nama + ", Anda Gagal");
        }
    }
}
