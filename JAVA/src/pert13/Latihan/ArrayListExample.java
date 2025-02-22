package pert13.Latihan;
import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<String> fruits = new ArrayList<>();

        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");

        System.out.println("Fruits: " + fruits);

        fruits.remove("Banana");
        System.out.println("After removing Banana: " + fruits);

        for (String fruit : fruits) {
            System.out.println("Fruit: " + fruit);
        }
    }
}
