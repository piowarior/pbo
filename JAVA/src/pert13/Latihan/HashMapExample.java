package pert13.Latihan;

import java.util.HashMap;

public class HashMapExample {
    public static void main(String[] args) {
        HashMap<Integer, String> students = new HashMap<>();

        students.put(1, "Alice");
        students.put(2, "Bob");
        students.put(3, "Charlie");

        System.out.println("Students: " + students);

        String student = students.get(2);
        System.out.println("Student with ID 2: " + student);

        students.remove(3);
        System.out.println("After removing student with ID 3: " + students);
    }
}
