import java.util.Scanner;

class Student {
    String name;
    String regNo;
    int numSubjects;
    int[] marks;

    Student(String name, String regNo, int numSubjects) {
        this.name = name;
        this.regNo = regNo;
        this.numSubjects = numSubjects;
        this.marks = new int[numSubjects];
    }

    public void enterMarks(Scanner scanner) {
        System.out.println("Enter marks for " + numSubjects + " subjects : ");
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Subject " + (i + 1) + " marks : ");
            marks[i] = scanner.nextInt();
        }
    }

    public double calculateAverage() {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return (double) total / numSubjects;
    }

    public void printDetails() {
        System.out.println("\nStudent Details : ");
        System.out.println("-----------------");
        System.out.println("Name : " + name);
        System.out.println("Registration Number : " + regNo);
        System.out.println("Average Marks : " + calculateAverage());
    }
}

public class StudentDetails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student name : ");
        String name = scanner.nextLine();
        System.out.print("Enter registration number : ");
        String regNo = scanner.nextLine();
        System.out.print("Enter number of subjects : ");
        int numSubjects = scanner.nextInt();

        Student student = new Student(name, regNo, numSubjects);

        System.out.println();

        student.enterMarks(scanner);
        student.printDetails();

        scanner.close();
    }
}
