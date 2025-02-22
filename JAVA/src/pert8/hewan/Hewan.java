package pert8.hewan;

public class Hewan {
    protected String suara;

        public Hewan(){
            this.suara="suara";
        }

        public void cetak(){
            System.out.println("hewan bersuara"+suara);

        }
    
}


class Mamalia extends Hewan {
    protected String berkembangbiak;

    public Mamalia(){
        this.berkembangbiak="beranak";
        
    }

    public void cetak(){
        System.out.println("mamalia berkembang buas"+berkembangbiak);

    }

    
} 

class Sapi extends Mamalia{
    private String nama;
    private String umur;

    public Sapi(){
        suara="hemohhhhh.......";
        berkembangbiak="beranak";
        this.nama="sopi";
        this.umur="1";
    }
    public void cetak(){
        System.out.println("========= Data Hewan Mamalia Sapi ===========");
        System.out.println("Suara              :"+suara);
        System.out.println("Berkembang biak:"+berkembangbiak);
        System.out.println("nama      :"+nama    );
        System.out.println("Umur      :"+umur+"tahun");
    }

}

class kambing extends Mamalia{
    private String nama;
    private String umur;

    public kambing(){
        suara="embek.......";
        berkembangbiak="beranak";
        this.nama="si ling";
        this.umur="2";
    }
    public void cetak(){
        System.out.println("========= Data Hewan Mamalia Kambing ===========");
        System.out.println("Suara              :"+suara);
        System.out.println("Berkembang biak:"+berkembangbiak);
        System.out.println("nama      :"+nama    );
        System.out.println("Umur      :"+umur+"tahun");
    }
}

class unggas extends Hewan{
    protected String berkembangbiak;

    public unggas(){
        this.berkembangbiak="bertelur";
        
    }

    public void cetak(){
        System.out.println("bertelur");

    }
    
}

class burung extends unggas{
    private String jenis;
    private String ciri;

    public burung(){
        suara="mbeker.......";
        berkembangbiak="bertelur";
        this.jenis="merpati";
        this.ciri="bulu putih";
    }
    public void cetak(){
        System.out.println("========= Data Hewan Unggas Burung ===========");
        System.out.println("Suara              :"+suara);
        System.out.println("Berkembang biak:"+berkembangbiak);
        System.out.println("nama      :"+jenis   );
        System.out.println("Umur      :"+ciri);
    }
}

class ayam extends unggas{
    private String jenis;
    private String ciri;

    public ayam(){
        suara="petok-petok.....";
        berkembangbiak="bertelur";
        this.jenis="ayam kampung";
        this.ciri="bulu bercorak putih hitam";
    }
    public void cetak(){
        System.out.println("========= Data Hewan Unggas Ayam ===========");
        System.out.println("Suara              :"+suara);
        System.out.println("Berkembang biak:"+berkembangbiak);
        System.out.println("nama      :"+jenis   );
        System.out.println("Umur      :"+ciri);
    }
}


class ikan extends Hewan{
    protected String napas;

    public ikan(){
        this.napas="insang";
        
    }

    public void cetak(){
        System.out.println("insang");

    }
    
}

class gurami extends ikan{
    private String ciri;
    private String berat;

    public gurami(){
        suara=".........";
        napas="insang";
        this.ciri="berwarna hitam";
        this.berat="2";
    }
    public void cetak(){
        System.out.println("========= Data Hewan ikan gurami ===========");
        System.out.println("Suara              :"+suara);
        System.out.println("Berkembang biak:"+napas);
        System.out.println("nama      :"+ciri);
        System.out.println("Umur      :"+berat+ "Kg");
    }
}

class lele extends ikan{
    private String ciri;
    private String berat;

    public lele(){
        suara=".........";
        napas="insang";
        this.ciri="berwarna hitam keputihan";
        this.berat="3";
    }
    public void cetak(){
        System.out.println("========= Data Hewan ikan lele ===========");
        System.out.println("Suara              :"+suara);
        System.out.println("Berkembang biak:"+napas);
        System.out.println("nama      :"+ciri);
        System.out.println("Umur      :"+berat+ "Kg");
    }
}

class pewarisan{
    public static void main(String[] args) {
        Sapi sp1 = new Sapi();
        sp1.cetak();
        System.out.println("");

        kambing kmb1 = new kambing();
        kmb1.cetak();
        System.out.println("");

        burung brg1 = new burung();
        brg1.cetak();
        System.out.println("");

        ayam aym1 = new ayam();
        aym1.cetak();
        System.out.println("");

        gurami grm1 = new gurami();
        grm1.cetak();
        System.out.println("");

        lele ll1 = new lele();
        ll1.cetak();
        System.out.println("");
                
    }
}
