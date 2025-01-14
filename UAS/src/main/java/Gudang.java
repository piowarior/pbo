package main.java;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.beans.property.*;

public class Gudang {

    private final IntegerProperty idGudang;
    private final StringProperty namaGudang;
    private final StringProperty lokasiGudang;
    private final IntegerProperty kapasitas;
    private final StringProperty tanggalDitambahkan;

    public Gudang(int idGudang, String namaGudang, String lokasiGudang, int kapasitas, String tanggalDitambahkan) {
        this.idGudang = new SimpleIntegerProperty(idGudang);
        this.namaGudang = new SimpleStringProperty(namaGudang);
        this.lokasiGudang = new SimpleStringProperty(lokasiGudang);
        this.kapasitas = new SimpleIntegerProperty(kapasitas);
        this.tanggalDitambahkan = new SimpleStringProperty(tanggalDitambahkan);
    }

    public int getIdGudang() {
        return idGudang.get();
    }

    public IntegerProperty idGudangProperty() {
        return idGudang;
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

    public int getKapasitas() {
        return kapasitas.get();
    }

    public IntegerProperty kapasitasProperty() {
        return kapasitas;
    }

    public String getTanggalDitambahkan() {
        return tanggalDitambahkan.get();
    }

    public StringProperty tanggalDitambahkanProperty() {
        return tanggalDitambahkan;
    }
}