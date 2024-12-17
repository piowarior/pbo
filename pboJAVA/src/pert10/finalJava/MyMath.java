package pert10.finalJava;

public final class MyMath {  // Class final, tidak bisa di-extend
    public final double PI = 3.1416;  // Atribut final, tidak bisa diubah

    public final double luasLingkaran(double radius) {  // Method final
        return PI * radius * radius;
    }

    public final double kelilingLingkaran(double radius) {  // Method final
        return 2 * PI * radius;
    }

    public final double sin(double derajat) {  // Method final
        return Math.sin(Math.toRadians(derajat));
    }

    public final double cos(double derajat) {  // Method final
        return Math.cos(Math.toRadians(derajat));
    }

    public final double tan(double derajat) {  // Method final
        return Math.tan(Math.toRadians(derajat));
    }

    public final double pangkat(double x, double y) {  // Method final
        return Math.pow(x, y);
    }
}
