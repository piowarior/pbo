package pert12;

// Interface untuk perilaku umum
interface Behavior {
    void move();
    void makeSound();
}

// Final Class untuk konstanta umum
final class Constants {
    public static final String SUARA_AYAM = "Kukuruyuk!";
    public static final String SUARA_MERPATI = "Kukur...";
}

// Abstract Class Animal
abstract class Animal {
    protected String nama;
    protected String sifat;
    protected int ukuran;

    // Constructor
    public Animal(String nama, String sifat, int ukuran) {
        this.nama = nama;
        this.sifat = sifat;
        this.ukuran = ukuran;
    }

    // Getter dan Setter
    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setUkuran(int ukuran) {
        this.ukuran = ukuran;
    }

    public int getUkuran() {
        return ukuran;
    }

    public void setSifat(String sifat) {
        this.sifat = sifat;
    }

    public String getSifat() {
        return sifat;
    }
}

// Subclass Mamalia
class Mamalia extends Animal implements Behavior {
    private String jenisMamalia;
    private boolean bisaJalan;
    private int jumlahKaki;

    // Constructor
    public Mamalia(String nama, String sifat, int ukuran, String jenisMamalia, boolean bisaJalan, int jumlahKaki) {
        super(nama, sifat, ukuran);
        this.jenisMamalia = jenisMamalia;
        this.bisaJalan = bisaJalan;
        this.jumlahKaki = jumlahKaki;
    }

    // Getter dan Setter
    public void setJenisMamalia(String jenisMamalia) {
        this.jenisMamalia = jenisMamalia;
    }

    public String getJenisMamalia() {
        return jenisMamalia;
    }

    public void setBisaJalan(boolean bisaJalan) {
        this.bisaJalan = bisaJalan;
    }

    public boolean getBisaJalan() {
        return bisaJalan;
    }

    // Implementasi Interface Behavior
    @Override
    public void move() {
        if (bisaJalan) {
            System.out.println(nama + " berjalan dengan " + jumlahKaki + " kaki.");
        } else {
            System.out.println(nama + " tidak bisa berjalan.");
        }
    }

    @Override
    public void makeSound() {
        System.out.println(nama + " membuat suara khas mamalia.");
    }
}

// Subclass Aves
class Aves extends Animal implements Behavior {
    private String jenisAves;
    private boolean bisaTerbang;

    // Constructor
    public Aves(String nama, String sifat, int ukuran, String jenisAves, boolean bisaTerbang) {
        super(nama, sifat, ukuran);
        this.jenisAves = jenisAves;
        this.bisaTerbang = bisaTerbang;
    }

    // Getter dan Setter
    public void setJenisAves(String jenisAves) {
        this.jenisAves = jenisAves;
    }

    public String getJenisAves() {
        return jenisAves;
    }

    public void setBisaTerbang(boolean bisaTerbang) {
        this.bisaTerbang = bisaTerbang;
    }

    public boolean getBisaTerbang() {
        return bisaTerbang;
    }

    // Implementasi Interface Behavior
    @Override
    public void move() {
        if (bisaTerbang) {
            System.out.println(nama + " sedang terbang.");
        } else {
            System.out.println(nama + " tidak bisa terbang.");
        }
    }

    @Override
    public void makeSound() {
        System.out.println(nama + " membuat suara khas burung.");
    }
}

// Subclass Ayam
class Ayam extends Aves {
    private String jenisAyam;
    private boolean bisaDiadu;

    // Constructor
    public Ayam(String nama, String sifat, int ukuran, boolean bisaTerbang, String jenisAyam, boolean bisaDiadu) {
        super(nama, sifat, ukuran, "Ayam", bisaTerbang);
        this.jenisAyam = jenisAyam;
        this.bisaDiadu = bisaDiadu;
    }

    // Getter dan Setter
    public void setJenisAyam(String jenisAyam) {
        this.jenisAyam = jenisAyam;
    }

    public String getJenisAyam() {
        return jenisAyam;
    }

    public void setBisaDiadu(boolean bisaDiadu) {
        this.bisaDiadu = bisaDiadu;
    }

    public boolean getBisaDiadu() {
        return bisaDiadu;
    }

    @Override
    public void makeSound() {
        System.out.println(nama + " bersuara: " + Constants.SUARA_AYAM);
    }
}

// Subclass Merpati
class Merpati extends Aves {
    // Constructor
    public Merpati(String nama, String sifat, int ukuran, boolean bisaTerbang) {
        super(nama, sifat, ukuran, "Merpati", bisaTerbang);
    }

    @Override
    public void makeSound() {
        System.out.println(nama + " bersuara: " + Constants.SUARA_MERPATI);
    }
}

// Kelas Main untuk Menjalankan Program
public class animalcetak {
    public static void main(String[] args) {
        // Objek Mamalia
        Mamalia sapi = new Mamalia("Sapi", "Jinak", 300, "Herbivora", true, 4);
        sapi.move();
        sapi.makeSound();

        // Objek Ayam
        Ayam ayamJago = new Ayam("Ayam Jago", "Petarung", 5, false, "Jago", true);
        ayamJago.move();
        ayamJago.makeSound();

        // Objek Merpati
        Merpati merpatiPos = new Merpati("Merpati Pos", "Pengirim Pesan", 3, true);
        merpatiPos.move();
        merpatiPos.makeSound();
    }
}
