package pert7.Mahasiswa;




public class MhsTester {

    public static void main(String[] args) {
        Mahasiswa  mahasiswa1 = new Mahasiswa("Andi",21,"Teknik informatika");
    
        System.out.println("nama mahasiswa: " + mahasiswa1.nama);

        System.out.println("Usia Mahasiswa: " + mahasiswa1.usia);

        System.out.println("jurusan mahasiswa: " + mahasiswa1.getJurusan());


        mahasiswa1.setJurusan("Sistem informasi");
        System.out.println("Jurussan Mahsaiswa Setelah diubah: " + mahasiswa1.getJurusan());

        mahasiswa1.tampilkaninfo();
    }
    
    
}
