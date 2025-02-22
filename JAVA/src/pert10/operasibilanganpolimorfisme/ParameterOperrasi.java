package pert10.operasibilanganpolimorfisme;

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