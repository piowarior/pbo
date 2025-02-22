package pert9.pegawai;

public class satpam extends pegawai {
    @Override
    public void menampilkan()
    {
        System.err.println("Nama : "+nama);
        System.out.println("Id Pegawai :"+id_pegawai);
        System.out.println("Gaji : "+gaji);
    }

    public void tugas(){
        System.out.println("Tugas : Menjaga keamanan didalam dan diluar franchise");
        System.out.println("-----------------------------------------------------");
    }
    
} 
