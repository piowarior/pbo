package pert10.staticJava;

public final class MyMath {
    public static final double PI = 3.1416; // Atribut static

    public static double luasLingkaran(double radius) {  // Method static
        return PI * radius * radius;
    }

    public static double kelilingLingkaran(double radius) {  // Method static
        return 2 * PI * radius;
    }

    public static double sin(double derajat) {  // Method static
        return Math.sin(Math.toRadians(derajat));
    }

    public static double cos(double derajat) {  // Method static
        return Math.cos(Math.toRadians(derajat));
    }

    public static double tan(double derajat) {  // Method static
        return Math.tan(Math.toRadians(derajat));
    }

    public static double pangkat(double x, double y) {  // Method static
        return Math.pow(x, y);
    }
}

