package pert12.phonejava;

public class Oppo implements Phone {
    private int volume;
    private boolean isPowerOn;

    public Oppo() {
        this.volume = 50;
        this.isPowerOn = false;
    }

    @Override
    public void powerOn() {
        isPowerOn = true;
        System.out.println("Oppo menyala...");
    }

    @Override
    public void powerOff() {
        isPowerOn = false;
        System.out.println("Oppo mati...");
    }

    @Override
    public void volumeUp() {
        if (isPowerOn) {
            if (volume < MAX_VOLUME) {
                volume++;
            }
            System.out.println("Volume Oppo: " + volume);
        } else {
            System.out.println("Oppo mati, tidak bisa menaikkan volume.");
        }
    }

    @Override
    public void volumeDown() {
        if (isPowerOn) {
            if (volume > MIN_VOLUME) {
                volume--;
            }
            System.out.println("Volume Oppo: " + volume);
        } else {
            System.out.println("Oppo mati, tidak bisa menurunkan volume.");
        }
    }
}

