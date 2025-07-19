import java.util.ArrayList;
import java.util.Scanner;

// Class to store student data
class Student {
    private String name;
    private double grade;

    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }
}

// Main program
public class StudentGradeTracker {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String choice;

        System.out.println("===== Student Grade Tracker =====");

        // Input loop
        do {
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();

            double grade = -1;
            while (grade < 0 || grade > 100) {
                System.out.print("Enter grade (0-100): ");
                if (scanner.hasNextDouble()) {
                    grade = scanner.nextDouble();
                    if (grade < 0 || grade > 100) {
                        System.out.println("Grade must be between 0 and 100.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next(); // discard invalid input
                }
            }

            students.add(new Student(name, grade));
            scanner.nextLine(); // consume leftover newline

            System.out.print("Add another student? (yes/no): ");
            choice = scanner.nextLine().trim().toLowerCase();
        } while (choice.equals("yes"));

        // Process data
        if (students.isEmpty()) {
            System.out.println("No student data to display.");
        } else {
            double total = 0;
            double highest = students.get(0).getGrade();
            double lowest = students.get(0).getGrade();

            for (Student s : students) {
                double g = s.getGrade();
                total += g;
                if (g > highest) highest = g;
                if (g < lowest) lowest = g;
            }

            double average = total / students.size();

            // Display summary
            System.out.println("\n===== Summary Report =====");
            System.out.printf("Total students: %d%n", students.size());
            System.out.printf("Average grade: %.2f%n", average);
            System.out.printf("Highest grade: %.2f%n", highest);
            System.out.printf("Lowest grade: %.2f%n", lowest);

            System.out.println("\n--- Student List ---");
            for (Student s : students) {
                System.out.printf("%s: %.2f%n", s.getName(), s.getGrade());
            }
        }

        System.out.println("===== End of Program =====");
        scanner.close();
    }
}