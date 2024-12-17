package pert8;

public class BangunDatar {
    float luas(){
        System.out.println("Menghitung luas Bangun Datar");
        return 0;
    }

    float keliling(){
        System.out.println("Menghitung kelliling bangubn datar");
        return 0;
    }
 
    public static void main(String[] args) {
        BangunDatar bangundatar = new BangunDatar();

        persegi persegi = new persegi();
        persegi.sisi = 2;

        lingkaran lingkaran = new lingkaran();
        lingkaran.r = 22;
        persegipanjang persegipanjang = new persegipanjang();
        persegipanjang.panjang = 8;
        persegipanjang.lebar = 4;


        segitiga mSegitiga = new segitiga();
        mSegitiga.alas = 12;
        mSegitiga.tinggi = 8;

        bangundatar.luas();
        bangundatar.keliling();

        persegi.luas();
        persegi.keliling();

        lingkaran.luas();
        lingkaran.keliling();

        persegipanjang.luas();
        persegipanjang.keliling();

        mSegitiga.luas();
        mSegitiga.keliling();

    }
}

