package pert10.polymorphdinamis;

public class Segitiga extends Bentuk {

    @Override
    protected void gambar() {
        System.out.println("subclass -> Menggambar Segitiga");
    }

    @Override
    protected void hapus() {
        System.out.println("subclass -> Menghapus Gambar Segitiga");
    }
    
}