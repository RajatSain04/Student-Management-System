import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    String rollNo;
    String course;

    Student(String name, String rollNo, String course) {
        this.name = name;
        this.rollNo = rollNo;
        this.course = course;
    }

    void display() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name   : " + name);
        System.out.println("Course : " + course);
        System.out.println("-----------------------");
    }
}

public class StudentManagementSystem {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by Roll No");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewAllStudents();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 4);
    }

    static void addStudent() {
        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter roll number: ");
        String roll = sc.nextLine();

        System.out.print("Enter course: ");
        String course = sc.nextLine();

        Student s = new Student(name, roll, course);
        students.add(s);
        System.out.println("✅ Student added successfully!");
    }

    static void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("⚠️ No student records found.");
        } else {
            for (Student s : students) {
                s.display();
            }
        }
    }

    static void searchStudent() {
        System.out.print("Enter roll number to search: ");
        String roll = sc.nextLine();

        boolean found = false;

        for (Student s : students) {
            if (s.rollNo.equalsIgnoreCase(roll)) {
                s.display();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("❌ Student with Roll No " + roll + " not found.");
        }
    }
}
