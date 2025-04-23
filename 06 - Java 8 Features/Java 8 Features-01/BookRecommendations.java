import java.util.*;
import java.util.stream.*;

class Book {
    private String title;
    private String author;
    private String genre;
    private double rating;

    public Book(String title, String author, String genre, double rating) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.rating = rating;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getGenre() { return genre; }
    public double getRating() { return rating; }
}

class BookRecommendation {
    private String title;
    private double rating;

    public BookRecommendation(String title, double rating) {
        this.title = title;
        this.rating = rating;
    }

    public String getTitle() { return title; }
    public double getRating() { return rating; }

    public String toString() {
        return title + " - Rating: " + rating;
    }
}

public class BookRecommendations {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book("Dune", "Frank Herbert", "Science Fiction", 4.5),
                new Book("Neuromancer", "William Gibson", "Science Fiction", 4.2),
                new Book("Foundation", "Isaac Asimov", "Science Fiction", 4.3),
                new Book("Snow Crash", "Neal Stephenson", "Science Fiction", 3.9),
                new Book("Hyperion", "Dan Simmons", "Science Fiction", 4.6),
                new Book("The Martian", "Andy Weir", "Science Fiction", 4.4),
                new Book("Ready Player One", "Ernest Cline", "Science Fiction", 4.1),
                new Book("Ender's Game", "Orson Scott Card", "Science Fiction", 4.2),
                new Book("Brave New World", "Aldous Huxley", "Dystopian", 4.0),
                new Book("2001: A Space Odyssey", "Arthur C. Clarke", "Science Fiction", 4.3),
                new Book("Childhood's End", "Arthur C. Clarke", "Science Fiction", 4.1),
                new Book("The Time Machine", "H.G. Wells", "Science Fiction", 3.8)
        );

        List<BookRecommendation> top10Recommendations = books.stream()
                .filter(b -> b.getGenre().equalsIgnoreCase("Science Fiction") && b.getRating() > 4.0)
                .map(b -> new BookRecommendation(b.getTitle(), b.getRating()))
                .sorted(Comparator.comparingDouble(BookRecommendation::getRating).reversed())
                .limit(10)
                .collect(Collectors.toList());

        List<List<BookRecommendation>> pages = new ArrayList<>();
        int pageSize = 5;
        for (int i = 0; i < top10Recommendations.size(); i += pageSize) {
            pages.add(top10Recommendations.subList(i, Math.min(i + pageSize, top10Recommendations.size())));
        }

        for (int i = 0; i < pages.size(); i++) {
            System.out.println("Page " + (i + 1) + ":");
            pages.get(i).forEach(System.out::println);
            System.out.println();
        }
    }
}