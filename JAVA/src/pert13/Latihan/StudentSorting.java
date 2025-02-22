package pert13.Latihan;

import java.util.Map;
import java.util.TreeMap;

public class StudentSorting {
    public static void main(String[] args) {
        TreeMap<String, Integer> students = new TreeMap<>();

        students.put("Charlie", 90);
        students.put("Alice", 85);
        students.put("Bob", 95);

        // Menampilkan daftar siswa terurut berdasarkan nama (key)
        for (Map.Entry<String, Integer> entry : students.entrySet()) {
            System.out.println("Name: " + entry.getKey() + ", Score: " + entry.getValue());
        }
    }
}
