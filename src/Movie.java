import java.util.*;

class Movie {
    private String title;
    private List<String> cast;
    private String category;
    private String releaseDate;
    private double budget;
    private boolean isFavorite;

    public Movie(String title, List<String> cast, String category, String releaseDate, double budget) {
        this.title = title;
        this.cast = cast;
        this.category = category;
        this.releaseDate = releaseDate;
        this.budget = budget;
        this.isFavorite = false;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getCast() {
        return cast;
    }

    public String getCategory() {
        return category;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public double getBudget() {
        return budget;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public void displayDetails() {
        System.out.println("Movie Title: " + title);
        System.out.println("Cast: " + cast);
        System.out.println("Category: " + category);
        System.out.println("Release Date: " + releaseDate);
        System.out.println("Budget: $" + budget + " million");
        System.out.println("Favorite: " + (isFavorite ? "Yes" : "No"));
    }
}