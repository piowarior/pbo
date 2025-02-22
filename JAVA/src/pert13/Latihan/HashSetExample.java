package pert13.Latihan;

import java.util.HashSet;

public class HashSetExample {
    public static void main(String[] args) {
        HashSet<String> cities = new HashSet<>();

        cities.add("Jakarta");
        cities.add("Bandung");
        cities.add("Surabaya");
        cities.add("Jakarta"); // Duplikasi tidak akan ditambahkan

        System.out.println("Cities: " + cities);

        if (cities.contains("Bandung")) {
            System.out.println("Bandung is in the set.");
        }

        cities.remove("Surabaya");
        System.out.println("After removing Surabaya: " + cities);
    }
}
