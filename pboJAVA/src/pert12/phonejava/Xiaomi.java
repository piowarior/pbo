package pert12.phonejava;

public class Xiaomi implements Phone {
    private int volume;
    private boolean isPowerOn;

    public Xiaomi() {
        this.volume = 50;
        this.isPowerOn = false;
    }

    @Override
    public void powerOn() {
        isPowerOn = true;
        System.out.println("Xiaomi menyala...");
    }

    @Override
    public void powerOff() {
        isPowerOn = false;
        System.out.println("Xiaomi mati...");
    }

    @Override
    public void volumeUp() {
        if (isPowerOn) {
            if (volume < MAX_VOLUME) {
                volume++;
            }
            System.out.println("Volume Xiaomi: " + volume);
        } else {
            System.out.println("Xiaomi mati, tidak bisa menaikkan volume.");
        }
    }

    @Override
    public void volumeDown() {
        if (isPowerOn) {
            if (volume > MIN_VOLUME) {
                volume--;
            }
            System.out.println("Volume Xiaomi: " + volume);
        } else {
            System.out.println("Xiaomi mati, tidak bisa menurunkan volume.");
        }
    }
}
