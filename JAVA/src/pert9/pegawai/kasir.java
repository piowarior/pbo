package pert9.pegawai;

public class kasir extends pegawai {
    @Override
    public void menampilkan()
    {
        System.err.println("Nama : "+nama);
        System.out.println("Id Pegawai :"+id_pegawai);
        System.out.println("Gaji : "+gaji);
    }

    public void tugas(){
        System.out.println("Tugas : Melakukan transaksi dengan pembeli");
        System.out.println("----------------------------------------------");
    }
}
