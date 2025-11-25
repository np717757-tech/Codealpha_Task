import java.util.ArrayList;
import java.util.Scanner;

class CodeAlpha_StudentGradeTracker {

    // Method to calculate grade based on marks
    public static String calculateGrade(int marks) {
        if (marks >= 90) return "A";
        else if (marks >= 80) return "B";
        else if (marks >= 70) return "C";
        else if (marks >= 60) return "D";
        else if (marks >= 50) return "E";
        else return "F";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<String> studentNames = new ArrayList<>();
        ArrayList<Integer> studentMarks = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        // Input student data
        for (int i = 0; i < n; i++) {
            System.out.print("Enter name of student " + (i + 1) + ": ");
            studentNames.add(sc.nextLine());

            System.out.print("Enter marks of " + studentNames.get(i) + ": ");
            studentMarks.add(sc.nextInt());
            sc.nextLine();
        }

        // Calculations
        int sum = 0, highest = Integer.MIN_VALUE, lowest = Integer.MAX_VALUE;
        String highestStudent = "", lowestStudent = "";

        for (int i = 0; i < n; i++) {
            int marks = studentMarks.get(i);
            sum += marks;

            if (marks > highest) {
                highest = marks;
                highestStudent = studentNames.get(i);
            }

            if (marks < lowest) {
                lowest = marks;
                lowestStudent = studentNames.get(i);
            }
        }

        double average = (double) sum / n;

        // Summary report
        System.out.println("\n---------- Student Grade Report ----------");
        System.out.printf("%-20s %-10s %-10s\n", "Name", "Marks", "Grade");
        System.out.println("-----------------------------------------------");

        for (int i = 0; i < n; i++) {
            String grade = calculateGrade(studentMarks.get(i));
            System.out.printf("%-20s %-10d %-10s\n", studentNames.get(i), studentMarks.get(i), grade);
        }

        System.out.println("\n--------------- Summary -----------------");
        System.out.println("Class Average Score : " + average);
        System.out.println("Highest Score       : " + highest + " (" + highestStudent + ")");
        System.out.println("Lowest Score        : " + lowest + " (" + lowestStudent + ")");
        System.out.println("------------------------------------------");
    }
}
