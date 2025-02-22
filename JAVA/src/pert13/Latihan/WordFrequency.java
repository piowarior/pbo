package pert13.Latihan;

import java.util.HashMap;
import java.util.Map;

public class WordFrequency {
    public static void main(String[] args) {
        String text = "Java is powerful and Java is easy to learn and powerful";

        // Memisahkan kata berdasarkan spasi
        String[] words = text.split(" ");

        // Menggunakan HashMap untuk menyimpan frekuensi kata
        HashMap<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            word = word.toLowerCase(); // Mengabaikan huruf kapital
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Menampilkan hasil
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println("Word: " + entry.getKey() + ", Count: " + entry.getValue());
        }
    }
}
