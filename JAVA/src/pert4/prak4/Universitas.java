package pert4.prak4;

class Mahasiswa {
    String nama;
    String jurusan;
    double ipk;

    // Konstruktor
    public Mahasiswa(String nama, String jurusan, double ipk) {
        this.nama = nama;
        this.jurusan = jurusan;
        this.ipk = ipk;
    }

    // Metode untuk mengecek apakah mahasiswa mendapatkan beasiswa
    void cekBeasiswa() {
        if (ipk >= 3.5) {
            System.out.println(nama + " berhak mendapatkan beasiswa.");
        } else {
            System.out.println(nama + " tidak berhak mendapatkan beasiswa.");
        }
    }

    // Metode untuk mencetak informasi mahasiswa
    void cetakInformasi() {
        System.out.println("Nama: " + nama);
        System.out.println("Jurusan: " + jurusan);
        System.out.println("IPK: " + ipk);
    }
}

public class Universitas {
    public static void main(String[] args) {
        // Membuat objek Mahasiswa
        Mahasiswa mahasiswa1 = new Mahasiswa("Andi", "Teknik Informatika", 3.8);
        Mahasiswa mahasiswa2 = new Mahasiswa("Siti", "Manajemen", 3.2);

        // Mencetak informasi dan mengecek beasiswa
        mahasiswa1.cetakInformasi();
        mahasiswa1.cekBeasiswa();

        System.out.println(); 

        mahasiswa2.cetakInformasi();
        mahasiswa2.cekBeasiswa();
    }
}
