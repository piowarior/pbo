package pert10.LatihanSoal.Soal2;

public class OperasiPerkalian extends OperasiBilangan {
    @Override
    public void tampil() {
        setC(getA() * getB());
        System.out.println("Hasil Perkalian   : " + getC());
    }
}