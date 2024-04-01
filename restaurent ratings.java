import java.util.*;

public class RestaurantRatingAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> ratings = new ArrayList<>();

        // Input the number of restaurants
        System.out.println("Enter the number of restaurants:");
        int numRestaurants = scanner.nextInt();

        // Input restaurant ratings
        System.out.println("Enter the restaurant ratings:");
        for (int i = 0; i < numRestaurants; i++) {
            ratings.add(scanner.nextInt());
        }

        // Define rating ranges
        int[] ratingRanges = {1, 5, 6, 10};

        // Initialize variables to store counts and sums for each range
        int[] ratingCounts = new int[2]; // 0-5 and 6-10
        int[] ratingSums = new int[2];   // Sums for each range

        // Iterate through ratings to calculate counts and sums
        for (int rating : ratings) {
            if (rating >= ratingRanges[0] && rating <= ratingRanges[1]) {
                ratingCounts[0]++;
                ratingSums[0] += rating;
            } else if (rating >= ratingRanges[2] && rating <= ratingRanges[3]) {
                ratingCounts[1]++;
                ratingSums[1] += rating;
            }
        }

        // Calculate averages for each range
        double[] ratingAverages = new double[2];
        for (int i = 0; i < 2; i++) {
            if (ratingCounts[i] != 0) {
                ratingAverages[i] = (double) ratingSums[i] / ratingCounts[i];
            }
        }

        // Output results
        System.out.println("\nRestaurant Rating Analysis:");
        System.out.println("Number of Restaurants Rated 1-5: " + ratingCounts[0]);
        System.out.println("Average Rating for 1-5: " + ratingAverages[0]);
        System.out.println("Number of Restaurants Rated 6-10: " + ratingCounts[1]);
        System.out.println("Average Rating for 6-10: " + ratingAverages[1]);
    }
}
