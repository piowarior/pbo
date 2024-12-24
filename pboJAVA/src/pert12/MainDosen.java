package pert12;

// Superclass Dosen
class Dosen {
    private String nik;
    private String nama;

    public Dosen(String nik, String nama) {
        this.nik = nik;
        this.nama = nama;
    }

    public void viewDosen() {
        System.out.println("NIK Dosen: " + nik);
        System.out.println("Nama Dosen: " + nama);
    }
}

// Subclass Rektor
class Rektor extends Dosen {
    private int tahunMasuk;

    public Rektor(String nik, String nama, int tahunMasuk) {
        super(nik, nama);
        this.tahunMasuk = tahunMasuk;
    }

    public int getTahunMasuk() {
        return tahunMasuk;
    }

    public void viewRektor() {
        viewDosen();
        System.out.println("Tahun Masuk Rektor: " + tahunMasuk);
    }
}

// Subclass Dekan
class Dekan extends Dosen {
    private String fakultas;

    public Dekan(String nik, String nama, String fakultas) {
        super(nik, nama);
        this.fakultas = fakultas;
    }

    public String getFakultas() {
        return fakultas;
    }

    public void viewDekan() {
        viewDosen();
        System.out.println("Fakultas: " + fakultas);
    }
}

// Main Class untuk Test
public class MainDosen {
    public static void main(String[] args) {
        Dosen dosen = new Dosen("123", "Budi");
        dosen.viewDosen();
        System.out.println();

        Rektor rektor = new Rektor("456", "Asep", 2020);
        rektor.viewRektor();
        System.out.println();

        Dekan dekan = new Dekan("789", "Siti", "Teknik");
        dekan.viewDekan();
    }
}
