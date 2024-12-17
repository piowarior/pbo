package pert10.operasibilanganpolimorfisme;

// Kelas OperasiPenjumlahan
class OperasiPenjumlahan extends OperasiBilangan {
    @Override
    protected void set_C() {
        this.c = this.a + this.b;
    }
}

// Kelas OperasiPengurangan
class OperasiPengurangan extends OperasiBilangan {
    @Override
    protected void set_C() {
        this.c = this.a - this.b;
    }
}

// Kelas OperasiPerkalian
class OperasiPerkalian extends OperasiBilangan {
    @Override
    protected void set_C() {
        this.c = this.a * this.b;
    }
}

// Kelas OperasiPembagian
class OperasiPembagian extends OperasiBilangan {
    @Override
    protected void set_C() {
        if (this.b != 0) {
            this.c = this.a / this.b;
        } else {
            System.out.println("Error: Pembagian dengan nol!");
            this.c = Double.NaN;
        }
    }
}
