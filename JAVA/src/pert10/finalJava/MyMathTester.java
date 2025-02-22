package pert10.finalJava;

public class MyMathTester {
    public static void main(String[] args) {
        MyMath m = new MyMath();  // Membuat objek MyMath

        System.out.println("PI : " + m.PI);  // Mengakses atribut PI
        // m.PI = 25.0;  // Error: Tidak bisa mengubah nilai PI karena final

        System.out.println("Luas Lingkaran : " + m.luasLingkaran(10));  // Menghitung luas lingkaran
        System.out.println("Keliling Lingkaran : " + m.kelilingLingkaran(10));  // Menghitung keliling lingkaran
        System.out.println("Sin(30) : " + m.sin(30));  // Menghitung sin(30)
        System.out.println("Cos(30) : " + m.cos(30));  // Menghitung cos(30)
        System.out.println("Tan(30) : " + m.tan(30));  // Menghitung tan(30)
        System.out.println("2^8 : " + m.pangkat(2, 8));  // Menghitung 2^8
    }
}
