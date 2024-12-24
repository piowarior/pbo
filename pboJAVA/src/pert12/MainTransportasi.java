package pert12;

// Interface Transportasi
interface Transportasi {
    int idz = 0; // Atribut default bersifat final dan static

    void tampil(); // Metode abstrak
    void setData(); // Metode abstrak
    int getID(); // Metode abstrak
}

// Superclass Gojek
class Gojek implements Transportasi {
    private int harga;
    private int id;

    public Gojek(int id, int harga) {
        this.id = id;
        this.harga = harga;
    }

    @Override
    public void tampil() {
        System.out.println("ID Gojek: " + id);
        System.out.println("Harga: " + harga);
    }

    @Override
    public void setData() {
        System.out.println("Data Gojek telah diatur.");
    }

    @Override
    public int getID() {
        return id;
    }
}

// Subclass Bayar
class Bayar extends Gojek {
    private int jarak;
    private int total;
    private String nama;

    public Bayar(int id, int harga, int jarak, String nama) {
        super(id, harga);
        this.jarak = jarak;
        this.nama = nama;
        this.total = hitungTotal();
    }

    public int hitungTotal() {
        return jarak * 2000; // Contoh perhitungan: biaya jarak per 2000
    }

    public void bayar() {
        System.out.println("Nama Pelanggan: " + nama);
        System.out.println("Jarak: " + jarak + " km");
        System.out.println("Total Bayar: " + total);
    }

    @Override
    public void tampil() {
        super.tampil();
        System.out.println("Nama: " + nama);
        System.out.println("Total Bayar: " + total);
    }
}

// Main Class untuk Test Program
public class MainTransportasi {
    public static void main(String[] args) {
        Gojek gojek = new Gojek(101, 15000);
        gojek.tampil();
        gojek.setData();
        System.out.println("ID Gojek: " + gojek.getID());
        System.out.println();

        Bayar bayar = new Bayar(102, 20000, 10, "Budi");
        bayar.tampil();
        bayar.bayar();
    }
}

