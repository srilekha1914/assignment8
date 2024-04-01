import java.util.*;

public class TestScoreAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> scores = new ArrayList<>();

        // Input the number of students
        System.out.println("Enter the number of students:");
        int numStudents = scanner.nextInt();

        // Input test scores
        System.out.println("Enter the test scores:");
        for (int i = 0; i < numStudents; i++) {
            scores.add(scanner.nextInt());
        }

        // Calculate average score
        double sum = 0;
        for (int score : scores) {
            sum += score;
        }
        double averageScore = sum / numStudents;

        // Calculate median score
        Collections.sort(scores);
        double median;
        if (numStudents % 2 == 0) {
            median = (scores.get(numStudents / 2 - 1) + scores.get(numStudents / 2)) / 2.0;
        } else {
            median = scores.get(numStudents / 2);
        }

        // Count scores above, at, and below the average
        int aboveAverageCount = 0;
        int atAverageCount = 0;
        int belowAverageCount = 0;
        for (int score : scores) {
            if (score > averageScore) {
                aboveAverageCount++;
            } else if (score == averageScore) {
                atAverageCount++;
            } else {
                belowAverageCount++;
            }
        }

        // Output results
        System.out.println("\nTest Score Analysis:");
        System.out.println("Average Score: " + averageScore);
        System.out.println("Median Score: " + median);
        System.out.println("Students Above Average: " + aboveAverageCount);
        System.out.println("Students At Average: " + atAverageCount);
        System.out.println("Students Below Average: " + belowAverageCount);
    }
}
```

