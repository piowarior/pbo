package pert10;

// Abstract class OperasiBilanganAbs
abstract class OperasiBilanganAbs {
    protected double a, b, c;

    protected abstract void set_A(double a);
    protected abstract void set_B(double b);
    protected abstract void set_C();

    protected abstract double get_A();
    protected abstract double get_B();
    protected abstract double get_C();

    protected abstract void tampil();
}

// Class OperasiPenjumlahan
class OperasiPenjumlahan extends OperasiBilanganAbs {
    @Override
    protected void set_A(double a) {
        this.a = a;
    }

    @Override
    protected void set_B(double b) {
        this.b = b;
    }

    @Override
    protected void set_C() {
        this.c = this.a + this.b;
    }

    @Override
    protected double get_A() {
        return this.a;
    }

    @Override
    protected double get_B() {
        return this.b;
    }

    @Override
    protected double get_C() {
        return this.c;
    }

    @Override
    protected void tampil() {
        System.out.println("Hasil Penjumlahan: " + this.c);
    }
}

// Class OperasiPengurangan
class OperasiPengurangan extends OperasiBilanganAbs {
    @Override
    protected void set_A(double a) {
        this.a = a;
    }

    @Override
    protected void set_B(double b) {
        this.b = b;
    }

    @Override
    protected void set_C() {
        this.c = this.a - this.b;
    }

    @Override
    protected double get_A() {
        return this.a;
    }

    @Override
    protected double get_B() {
        return this.b;
    }

    @Override
    protected double get_C() {
        return this.c;
    }

    @Override
    protected void tampil() {
        System.out.println("Hasil Pengurangan: " + this.c);
    }
}

// Class OperasiPerkalian
class OperasiPerkalian extends OperasiBilanganAbs {
    @Override
    protected void set_A(double a) {
        this.a = a;
    }

    @Override
    protected void set_B(double b) {
        this.b = b;
    }

    @Override
    protected void set_C() {
        this.c = this.a * this.b;
    }

    @Override
    protected double get_A() {
        return this.a;
    }

    @Override
    protected double get_B() {
        return this.b;
    }

    @Override
    protected double get_C() {
        return this.c;
    }

    @Override
    protected void tampil() {
        System.out.println("Hasil Perkalian: " + this.c);
    }
}

// Class OperasiPembagian
class OperasiPembagian extends OperasiBilanganAbs {
    @Override
    protected void set_A(double a) {
        this.a = a;
    }

    @Override
    protected void set_B(double b) {
        this.b = b;
    }

    @Override
    protected void set_C() {
        if (this.b != 0) {
            this.c = this.a / this.b;
        } else {
            System.out.println("Error: Pembagian dengan nol!");
            this.c = 0;
        }
    }

    @Override
    protected double get_A() {
        return this.a;
    }

    @Override
    protected double get_B() {
        return this.b;
    }

    @Override
    protected double get_C() {
        return this.c;
    }

    @Override
    protected void tampil() {
        System.out.println("Hasil Pembagian: " + this.c);
    }
}

// Final class OperasiBilanganAbsCetak
final class OperasiBilanganAbsCetak {
    public void cetakSemua(OperasiBilanganAbs[] OB, double a, double b) {
        for (OperasiBilanganAbs operasi : OB) {
            operasi.set_A(a);
            operasi.set_B(b);
            operasi.set_C();
            operasi.tampil();
        }
    }
}

// Main Class
public class OperasiBilanganAbstrak {
    public static void main(String[] args) {
        double A = 6.5;
        double B = 0.5;

        OperasiBilanganAbs[] operasiArray = {
            new OperasiPenjumlahan(),
            new OperasiPengurangan(),
            new OperasiPerkalian(),
            new OperasiPembagian()
        };

        OperasiBilanganAbsCetak cetak = new OperasiBilanganAbsCetak();
        cetak.cetakSemua(operasiArray, A, B);
    }
}
