package pert7.Mahasiswa;

class Mahasiswa {
    public String nama;
    protected int usia;
    private String jurusan;

    public Mahasiswa(String nama, int usia, String jurusan) {
        this.nama = nama;
        this.usia = usia;
        this.jurusan = jurusan;
    }
    
    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusanBaru){
        this.jurusan = jurusanBaru;
    }

    public void tampilkaninfo(){
        System.out.println("nama: "+ nama);
        System.out.println("usia: "+ usia);
        System.out.println("jurusan: "+ jurusan);
    }
    
}
