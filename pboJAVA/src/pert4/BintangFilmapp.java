package pert4;

class BintangFilm{

    private String nama;
    private Boolean pria;

    BintangFilm(String nama, Boolean pria){
        this.nama = nama;
        this.pria = pria;
    }


    String perolehanNama(){
        return (nama);
    }

    String perolehanJenisKelamin(){
        if(pria) 
            return ("pria");
        else
            return ("wanita"); 
    }

}

public class BintangFilmapp {
    public static void main(String[] args) {
        BintangFilm siA = new BintangFilm("Budi", true);
        BintangFilm siB = new BintangFilm("hani", false);        
    
        System.out.println("siA => " + siA.perolehanNama() +", " + siA.perolehanJenisKelamin());
        System.out.println("siB => " + siB.perolehanNama() +", " + siB.perolehanJenisKelamin());
    }
}
