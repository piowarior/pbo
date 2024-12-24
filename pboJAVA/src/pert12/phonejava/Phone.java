package pert12.phonejava;

public interface Phone {
    int MAX_VOLUME = 100;  // Konstanta untuk volume maksimum
    int MIN_VOLUME = 0;    // Konstanta untuk volume minimum

    void powerOn();    // Metode abstrak menyalakan ponsel
    void powerOff();   // Metode abstrak mematikan ponsel
    void volumeUp();   // Metode abstrak menaikkan volume
    void volumeDown(); // Metode abstrak menurunkan volume
}
