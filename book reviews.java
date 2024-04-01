import java.util.*;

class BookReview {
    int rating;

    public BookReview(int rating) {
        this.rating = rating;
    }
}

class ReviewStats {
    int totalBooks;
    int[] ratingRangeCounts;
    int positiveCount;
    int neutralCount;
    int negativeCount;

    public ReviewStats() {
        this.totalBooks = 0;
        this.ratingRangeCounts = new int[2]; // Assuming 2 rating ranges: 1-5 stars and 6-10 stars
        this.positiveCount = 0;
        this.neutralCount = 0;
        this.negativeCount = 0;
    }

    public void updateStats(int rating) {
        totalBooks++;

        if (rating >= 1 && rating <= 5) {
            ratingRangeCounts[0]++;
        } else if (rating >= 6 && rating <= 10) {
            ratingRangeCounts[1]++;
        }

        if (rating >= 7 && rating <= 10) {
            positiveCount++;
        } else if (rating >= 4 && rating <= 6) {
            neutralCount++;
        } else if (rating >= 1 && rating <= 3) {
            negativeCount++;
        }
    }
}

public class BookReviewAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<BookReview> reviews = new ArrayList<>();

        System.out.println("Enter the number of book reviews:");
        int numReviews = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        for (int i = 0; i < numReviews; i++) {
            System.out.println("Enter book rating:");
            int rating = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            reviews.add(new BookReview(rating));
        }

        ReviewStats stats = new ReviewStats();

        for (BookReview review : reviews) {
            stats.updateStats(review.rating);
        }

        System.out.println("\nBook Review Statistics:");
        System.out.println("Total Books Reviewed: " + stats.totalBooks);
        System.out.println("Books Reviewed in 1-5 Stars Range: " + stats.ratingRangeCounts[0]);
        System.out.println("Books Reviewed in 6-10 Stars Range: " + stats.ratingRangeCounts[1]);
        System.out.println("Positive Reviews Count: " + stats.positiveCount);
        System.out.println("Neutral Reviews Count: " + stats.neutralCount);
        System.out.println("Negative Reviews Count: " + stats.negativeCount);
    }
}
```
