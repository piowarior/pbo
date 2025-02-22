package pert10;

// Kelas dasar OperasiBilangan
class OperasiBilangan {
    protected double a, b, c;

    protected void set_A(double a) {
        this.a = a;
    }

    protected void set_B(double b) {
        this.b = b;
    }

    protected void set_C() {
        this.c = 0; // Default nilai, akan diimplementasikan oleh subclass
    }

    protected double get_A() {
        return this.a;
    }

    protected double get_B() {
        return this.b;
    }

    protected double get_C() {
        return this.c;
    }

    protected void tampil() {
        System.out.println("Hasil: " + this.c);
    }
}

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
