package main.java;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.DoubleProperty;

public class Produk {

    private final StringProperty nama;
    private final StringProperty kategori;
    private final DoubleProperty harga;
    private final StringProperty deskripsi;
    private final StringProperty namaGudang;
    private final StringProperty lokasiGudang;
    private final StringProperty seri;

    public Produk(String nama, String kategori, double harga, String deskripsi, String namaGudang, String lokasiGudang, String seri) {
        this.nama = new SimpleStringProperty(nama);
        this.kategori = new SimpleStringProperty(kategori);
        this.harga = new SimpleDoubleProperty(harga);
        this.deskripsi = new SimpleStringProperty(deskripsi);
        this.namaGudang = new SimpleStringProperty(namaGudang);
        this.lokasiGudang = new SimpleStringProperty(lokasiGudang);
        this.seri = new SimpleStringProperty(seri);
    }

    public String getNama() {
        return nama.get();
    }

    public StringProperty namaProperty() {
        return nama;
    }

    public String getKategori() {
        return kategori.get();
    }

    public StringProperty kategoriProperty() {
        return kategori;
    }

    public double getHarga() {
        return harga.get();
    }

    public DoubleProperty hargaProperty() {
        return harga;
    }

    public String getDeskripsi() {
        return deskripsi.get();
    }

    public StringProperty deskripsiProperty() {
        return deskripsi;
    }

    public String getNamaGudang() {
        return namaGudang.get();
    }

    public StringProperty namaGudangProperty() {
        return namaGudang;
    }

    public String getLokasiGudang() {
        return lokasiGudang.get();
    }

    public StringProperty lokasiGudangProperty() {
        return lokasiGudang;
    }

    public String getSeri() {
        return seri.get();
    }

    public StringProperty seriProperty() {
        return seri;
    }
}
