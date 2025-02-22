package pert4;

class Mobil {
    String aktifitas;
    String warna;
    int kecepatan;
    public Mobil (String aktifitas, String warna, int kecepatan){
        this.aktifitas = aktifitas;
        this.warna = warna;
        this.kecepatan = kecepatan;
    }

    void cekkecepatan() {
        if(kecepatan==0){
            aktifitas="parkir";
        }
        
    }
    void cetakAtribut(){
        System.out.println("aktifitas = "+aktifitas);
        System.out.println("warna = " +warna);
        System.out.println("Kecepatan = " +kecepatan);
    }
}

public class mobil {
    public static void main(String[] args) {
        Mobil mobilku = new Mobil("berjalan", "merah", 0);
        mobilku.kecepatan=0;
        mobilku.warna="merah";
        mobilku.cekkecepatan();
        mobilku.cetakAtribut();
    }
}
