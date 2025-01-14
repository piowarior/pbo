package main.java.Product;

public enum Gudang {
    GUDANG_PUSAT_JAKARTA(1, "Gudang Pusat Jakarta"),
    GUDANG_BANDUNG_TIMUR(2, "Gudang Bandung Timur"),
    GUDANG_SURABAYA_SELATAN(3, "Gudang Surabaya Selatan");

    private final int idGudang;
    private final String namaGudang;

    Gudang(int idGudang, String namaGudang) {
        this.idGudang = idGudang;
        this.namaGudang = namaGudang;
    }

    public int getIdGudang() {
        return idGudang;
    }

    public String getNamaGudang() {
        return namaGudang;
    }

    @Override
    public String toString() {
        return namaGudang;
    }
}
