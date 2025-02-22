package pert13.Latihan;

import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList<String> animals = new LinkedList<>();

        animals.add("Cat");
        animals.add("Dog");
        animals.add("Elephant");

        animals.addFirst("Lion");
        animals.addLast("Tiger");

        System.out.println("Animals: " + animals);

        animals.removeFirst();
        animals.removeLast();
        System.out.println("After removing first and last elements: " + animals);
    }
}
