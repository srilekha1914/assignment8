import java.util.*;

class Movie {
    String category;
    double rating;

    public Movie(String category, double rating) {
        this.category = category;
        this.rating = rating;
    }
}

class CategoryStats {
    String category;
    int movieCount;
    double totalRating;

    public CategoryStats(String category) {
        this.category = category;
        this.movieCount = 0;
        this.totalRating = 0;
    }

    public void updateStats(double rating) {
        movieCount++;
        totalRating += rating;
    }

    public double getAverageRating() {
        return movieCount > 0 ? totalRating / movieCount : 0;
    }
}

public class MovieRatingsAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Movie> movies = new ArrayList<>();

        System.out.println("Enter the number of movies:");
        int numMovies = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        for (int i = 0; i < numMovies; i++) {
            System.out.println("Enter movie category (e.g., PG, PG-13, R):");
            String category = scanner.nextLine();

            System.out.println("Enter movie rating:");
            double rating = scanner.nextDouble();
            scanner.nextLine(); // Consume newline character

            movies.add(new Movie(category, rating));
        }

        Map<String, CategoryStats> categoryStatsMap = new HashMap<>();

        for (Movie movie : movies) {
            CategoryStats stats = categoryStatsMap.getOrDefault(movie.category, new CategoryStats(movie.category));
            stats.updateStats(movie.rating);
            categoryStatsMap.put(movie.category, stats);
        }

        System.out.println("\nMovie Category Ratings Statistics:");
        for (CategoryStats stats : categoryStatsMap.values()) {
            System.out.println("Category: " + stats.category);
            System.out.println("Number of Movies: " + stats.movieCount);
            System.out.println("Average Rating: " + stats.getAverageRating() + "\n");
        }
    }
}
```

