package pert3;
import java.util.Scanner;

public class no1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int angka;
        System.out.println("masukkan angka :");
        angka = input.nextInt();

        if (angka>0){
            System.out.print(angka + "ini bilangan positif");
        }
        else if (angka == 0){
            System.out.print(angka + "ini bilangan 0");
        }
        else if(angka < 0){
            System.out.print(angka + "ini bilangan negatif");
        }
        
        input.close();

    }
    
}
