package pert9.pegawai;

public class Main {
    public static void main(String[] args) {
        // Membuat sebuah object
        // "Pegawai" merupakan class, lalu "Pegawai" merupakan objek yang akan dibuat,
        // lalu "new Pegawai()" merupakan constructor.
        pegawai pegawai = new pegawai();
        manajer manajer = new manajer();
        kasir kasir = new kasir();
        koki koki = new koki();
        pelayan pelayan = new pelayan();
        satpam satpam = new satpam();

        // Memasukkan nilai variabel menggunakan objek.
        manajer.nama = "Sifa";
        manajer.id_pegawai = 1;
        manajer.gaji = "7 Juta";

        kasir.nama = "Aldi";
        kasir.id_pegawai = 2;
        kasir.gaji = "1,2 Juta";

        koki.nama = "Reza";
        koki.id_pegawai = 3;
        koki.gaji = "2 Juta";

        pelayan.nama = "Dean";
        pelayan.id_pegawai = 4;
        pelayan.gaji = "1,2 Juta";

        satpam.nama = "Aldi";
        satpam.id_pegawai = 2;
        satpam.gaji = "1 Juta";

        // Nilai tersebut akan dimasukkan ke dalam variabel yang ada pada superclass.
        // Memanggil fungsi pada superclass
        pegawai.menampilkan();
        // Memanggil nilai variabel pada superclass dan memasukkannya ke dalam fungsi yang ada pada class;
        manajer.menampilkan();
        manajer.tugas();

        kasir.menampilkan();
        kasir.tugas();

        koki.menampilkan();
        koki.tugas();

        pelayan.menampilkan();
        pelayan.tugas();

        satpam.menampilkan();
        satpam.tugas();
    }
}
