package pert10.operasibilanganpolimorfisme;

// Kelas untuk mencetak semua operasi
class OperasiBilanganCetak {
    private void cetakSemua(OperasiBilangan[] OB, double a, double b) {
        for (OperasiBilangan operasi : OB) {
            operasi.set_A(a);
            operasi.set_B(b);
            operasi.set_C();
            operasi.tampil();
        }
    }

    public static void main(String[] args) {
        double a = 10.5;
        double b = 0.5;

        OperasiBilangan[] operasiArray = {
            new OperasiPenjumlahan(),
            new OperasiPengurangan(),
            new OperasiPerkalian(),
            new OperasiPembagian()
        };

        OperasiBilanganCetak operasiCetak = new OperasiBilanganCetak();
        operasiCetak.cetakSemua(operasiArray, a, b);
    }
}
