package main.java;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.DoubleProperty;

public class Pesanan {

    private final StringProperty namaProduk;
    private final StringProperty namaPelanggan;
    private final StringProperty alamatPengirim;
    private final StringProperty seriProduk;
    private final StringProperty tanggalPesanan;
    private final StringProperty statusPesanan;
    private final DoubleProperty totalHarga;
    private final StringProperty noTelepon;

    public Pesanan(String namaProduk, String namaPelanggan, String alamatPengirim, 
                   String seriProduk, String tanggalPesanan, String statusPesanan, 
                   double totalHarga, String noTelepon) {
        this.namaProduk = new SimpleStringProperty(namaProduk);
        this.namaPelanggan = new SimpleStringProperty(namaPelanggan);
        this.alamatPengirim = new SimpleStringProperty(alamatPengirim);
        this.seriProduk = new SimpleStringProperty(seriProduk);
        this.tanggalPesanan = new SimpleStringProperty(tanggalPesanan);
        this.statusPesanan = new SimpleStringProperty(statusPesanan);
        this.totalHarga = new SimpleDoubleProperty(totalHarga);
        this.noTelepon = new SimpleStringProperty(noTelepon);
    }

    public String getNamaProduk() {
        return namaProduk.get();
    }

    public StringProperty namaProdukProperty() {
        return namaProduk;
    }

    public String getNamaPelanggan() {
        return namaPelanggan.get();
    }

    public StringProperty namaPelangganProperty() {
        return namaPelanggan;
    }

    public String getAlamatPengirim() {
        return alamatPengirim.get();
    }

    public StringProperty alamatPengirimProperty() {
        return alamatPengirim;
    }

    public String getSeriProduk() {
        return seriProduk.get();
    }

    public StringProperty seriProdukProperty() {
        return seriProduk;
    }

    public String getTanggalPesanan() {
        return tanggalPesanan.get();
    }

    public StringProperty tanggalPesananProperty() {
        return tanggalPesanan;
    }

    public String getStatusPesanan() {
        return statusPesanan.get();
    }

    public StringProperty statusPesananProperty() {
        return statusPesanan;
    }

    public double getTotalHarga() {
        return totalHarga.get();
    }

    public DoubleProperty totalHargaProperty() {
        return totalHarga;
    }

    public String getNoTelepon() {
        return noTelepon.get();
    }

    public StringProperty noTeleponProperty() {
        return noTelepon;
    }
}
