import java.util.*;

class Project {
    String studentName;
    int completionTime;

    public Project(String studentName, int completionTime) {
        this.studentName = studentName;
        this.completionTime = completionTime;
    }
}

class StudentStats {
    String studentName;
    int onTimeCount;
    int lateCount;
    int earlyCount;
    int totalProjects;
    int totalCompletionTime;

    public StudentStats(String studentName) {
        this.studentName = studentName;
        this.onTimeCount = 0;
        this.lateCount = 0;
        this.earlyCount = 0;
        this.totalProjects = 0;
        this.totalCompletionTime = 0;
    }

    public void updateStats(int completionTime, boolean onTime) {
        totalProjects++;
        totalCompletionTime += completionTime;

        if (onTime)
            onTimeCount++;
        else if (completionTime > 0)
            lateCount++;
        else
            earlyCount++;
    }

    public double getAverageCompletionTime() {
        return totalProjects > 0 ? (double) totalCompletionTime / totalProjects : 0;
    }
}

public class ProjectTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Project> projects = new ArrayList<>();

        System.out.println("Enter the number of projects:");
        int numProjects = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        for (int i = 0; i < numProjects; i++) {
            System.out.println("Enter student name:");
            String studentName = scanner.nextLine();

            System.out.println("Enter completion time (in days):");
            int completionTime = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            projects.add(new Project(studentName, completionTime));
        }

        Map<String, StudentStats> studentStatsMap = new HashMap<>();

        for (Project project : projects) {
            StudentStats stats = studentStatsMap.getOrDefault(project.studentName, new StudentStats(project.studentName));
            boolean onTime = project.completionTime <= 0;
            stats.updateStats(project.completionTime, onTime);
            studentStatsMap.put(project.studentName, stats);
        }

        System.out.println("\nStudent Project Statistics:");
        for (StudentStats stats : studentStatsMap.values()) {
            System.out.println("Student: " + stats.studentName);
            System.out.println("On Time: " + stats.onTimeCount);
            System.out.println("Late: " + stats.lateCount);
            System.out.println("Early: " + stats.earlyCount);
            System.out.println("Average Completion Time: " + stats.getAverageCompletionTime() + " days\n");
        }
    }
}
