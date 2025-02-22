package pert11;

// Kelas abstrak Kendaraan
abstract class Kendaraan {
    protected final String nama;  // Atribut final agar tidak bisa diubah

    public Kendaraan(String nama) {
        this.nama = nama;  // Menetapkan nilai nama kendaraan saat objek dibuat
    }

    public abstract double hitungHargaSewa(int hari);  // Metode abstrak untuk menghitung harga sewa

    public String getNama() {
        return nama;  // Mengembalikan nama kendaraan
    }
}

// Interface Asuransi
interface Asuransi {
    double hitungBiayaAsuransi(int hari);  // Metode untuk menghitung biaya asuransi
}

// Kelas Mobil yang meng-extend Kendaraan dan mengimplementasikan Asuransi
class Mobil extends Kendaraan implements Asuransi {
    private final String jenisBahanBakar;  // Atribut final agar tidak bisa diubah
    private static final double HARGA_SEWA_PER_HARI = 500000;  // Final untuk harga sewa
    private static final double BIAYA_ASURANSI_PER_HARI = 50000;  // Final untuk biaya asuransi

    public Mobil(String nama, String jenisBahanBakar) {
        super(nama);  // Memanggil konstruktor kelas induk (Kendaraan) untuk menetapkan nama
        this.jenisBahanBakar = jenisBahanBakar;  // Menetapkan jenis bahan bakar mobil
    }

    @Override
    public double hitungHargaSewa(int hari) {
        return hari * HARGA_SEWA_PER_HARI;  // Menghitung harga sewa mobil per hari
    }

    @Override
    public double hitungBiayaAsuransi(int hari) {
        return hari * BIAYA_ASURANSI_PER_HARI;  // Menghitung biaya asuransi mobil per hari
    }

    @Override
    public String toString() {
        return "Mobil{nama='" + nama + "', jenisBahanBakar='" + jenisBahanBakar + "'}";  // Format output kendaraan
    }
}

// Kelas Motor yang meng-extend Kendaraan dan mengimplementasikan Asuransi
class Motor extends Kendaraan implements Asuransi {
    private final int kapasitasMesin;  // Atribut final agar tidak bisa diubah
    private static final double HARGA_SEWA_PER_HARI = 200000;  // Final untuk harga sewa
    private static final double BIAYA_ASURANSI_PER_HARI = 20000;  // Final untuk biaya asuransi

    public Motor(String nama, int kapasitasMesin) {
        super(nama);  // Memanggil konstruktor kelas induk (Kendaraan) untuk menetapkan nama
        this.kapasitasMesin = kapasitasMesin;  // Menetapkan kapasitas mesin motor
    }

    @Override
    public double hitungHargaSewa(int hari) {
        return hari * HARGA_SEWA_PER_HARI;  // Menghitung harga sewa motor per hari
    }

    @Override
    public double hitungBiayaAsuransi(int hari) {
        return hari * BIAYA_ASURANSI_PER_HARI;  // Menghitung biaya asuransi motor per hari
    }

    @Override
    public String toString() {
        return "Motor{nama='" + nama + "', kapasitasMesin=" + kapasitasMesin + "cc}";  // Format output kendaraan
    }
}

// Kelas Utama
public class TugasAbstrackInterfaceFinal {
    public static void main(String[] args) {
        // Membuat objek Mobil dan Motor
        Mobil mobil = new Mobil("Toyota Avanza", "Bensin");
        Motor motor = new Motor("Honda Vario", 150);

        // Menghitung total biaya sewa
        int lamaSewa = 3; // Lama penyewaan 3 hari

        double hargaSewaMobil = mobil.hitungHargaSewa(lamaSewa);  // Menghitung harga sewa mobil
        double biayaAsuransiMobil = mobil.hitungBiayaAsuransi(lamaSewa);  // Menghitung biaya asuransi mobil
        double totalBiayaMobil = hargaSewaMobil + biayaAsuransiMobil;  // Total biaya sewa mobil (termasuk asuransi)

        double hargaSewaMotor = motor.hitungHargaSewa(lamaSewa);  // Menghitung harga sewa motor
        double biayaAsuransiMotor = motor.hitungBiayaAsuransi(lamaSewa);  // Menghitung biaya asuransi motor
        double totalBiayaMotor = hargaSewaMotor + biayaAsuransiMotor;  // Total biaya sewa motor (termasuk asuransi)

        // Output hasil
        System.out.println(mobil);  // Menampilkan informasi tentang mobil
        System.out.println("Total Biaya Sewa Mobil: Rp" + totalBiayaMobil);  // Menampilkan total biaya sewa mobil

        System.out.println(motor);  // Menampilkan informasi tentang motor
        System.out.println("Total Biaya Sewa Motor: Rp" + totalBiayaMotor);  // Menampilkan total biaya sewa motor
    }
}
