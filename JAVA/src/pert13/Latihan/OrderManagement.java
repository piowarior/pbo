package pert13.Latihan;

import java.util.LinkedHashMap;
import java.util.Map;

public class OrderManagement {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> orders = new LinkedHashMap<>();

        orders.put("Laptop", 2);
        orders.put("Smartphone", 5);
        orders.put("Headphones", 3);

        System.out.println("Order Details:");
        for (Map.Entry<String, Integer> entry : orders.entrySet()) {
            System.out.println("Product: " + entry.getKey() + ", Quantity: " + entry.getValue());
        }
    }
}
