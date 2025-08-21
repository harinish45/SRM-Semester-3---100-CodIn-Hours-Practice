import java.util.Random;
import java.util.Scanner;

public class StudentScorecard {

    // a. Generate random PCM scores for students
    public static int[][] generateScores(int n) {
        Random rand = new Random();
        int[][] scores = new int[n][3]; // 3 subjects: Physics, Chemistry, Math
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                scores[i][j] = rand.nextInt(41) + 60; // 60-100 (two-digit scores)
            }
        }
        return scores;
    }

    // b. Calculate total, average, percentage
    public static double[][] calculateResults(int[][] scores) {
        double[][] results = new double[scores.length][3]; // total, avg, percentage
        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double avg = total / 3.0;
            double perc = (total / 300.0) * 100;
            results[i][0] = total;
            results[i][1] = Math.round(avg * 100.0) / 100.0; // round to 2 decimal
            results[i][2] = Math.round(perc * 100.0) / 100.0;
        }
        return results;
    }

    // c. Calculate grades based on percentage
    public static String[] calculateGrades(double[][] results) {
        String[] grades = new String[results.length];
        for (int i = 0; i < results.length; i++) {
            double perc = results[i][2];
            if (perc >= 80) grades[i] = "A";
            else if (perc >= 70) grades[i] = "B";
            else if (perc >= 60) grades[i] = "C";
            else if (perc >= 50) grades[i] = "D";
            else if (perc >= 40) grades[i] = "E";
            else grades[i] = "R";
        }
        return grades;
    }

    // d. Display scorecard
    public static void displayScorecard(int[][] scores, double[][] results, String[] grades) {
        System.out.println("Roll\tPhysics\tChemistry\tMath\tTotal\tAverage\t\t%age\tGrade");
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%d\t%d\t%d\t\t%d\t%.0f\t%.2f\t\t%.2f\t%s\n",
                    (i + 1), scores[i][0], scores[i][1], scores[i][2],
                    results[i][0], results[i][1], results[i][2], grades[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[][] scores = generateScores(n);
        double[][] results = calculateResults(scores);
        String[] grades = calculateGrades(results);

        displayScorecard(scores, results, grades);
    }
}
