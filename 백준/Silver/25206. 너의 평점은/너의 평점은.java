import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double totalScore = 0.0;
        double totalCredit = 0.0;

        for (int i = 0; i < 20; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            String grade = parts[2];
            double credit = Double.parseDouble(parts[1]);

            if (grade.equals("P")) {
                continue;
            }

            totalCredit += credit;
            totalScore += credit * getGradePoint(grade);
        }

        scanner.close();

        double average = totalScore / totalCredit;
        System.out.printf("%.6f\n", average);
    }

    private static double getGradePoint(String grade) {
        switch (grade) {
            case "A+": return 4.5;
            case "A0": return 4.0;
            case "B+": return 3.5;
            case "B0": return 3.0;
            case "C+": return 2.5;
            case "C0": return 2.0;
            case "D+": return 1.5;
            case "D0": return 1.0;
            case "F": return 0.0;
            default: return 0.0;
        }
    }
}
