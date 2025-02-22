package pert13.Latihan;
import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private String nim;

    public Student(String name, String nim) {
        this.name = name;
        this.nim = nim;
    }

    public String getName() {
        return name;
    }

    public String getNim() {
        return nim;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", NIM: " + nim;
    }
}

public class StudentManagement {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Remove Student by NIM");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student NIM: ");
                    String nim = scanner.nextLine();
                    students.add(new Student(name, nim));
                    System.out.println("Student added successfully!");
                    break;
                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No students available.");
                    } else {
                        System.out.println("List of Students:");
                        for (Student student : students) {
                            System.out.println(student);
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter NIM to remove: ");
                    String nimToRemove = scanner.nextLine();
                    boolean removed = false;
                    for (int i = 0; i < students.size(); i++) {
                        if (students.get(i).getNim().equals(nimToRemove)) {
                            students.remove(i);
                            removed = true;
                            System.out.println("Student removed successfully!");
                            break;
                        }
                    }
                    if (!removed) {
                        System.out.println("Student with NIM " + nimToRemove + " not found.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
