import java.util.*;

class User {
    private String email;
    private String name;
    private List<Movie> favoriteMovies;

    public User(String email, String name) {
        this.email = email;
        this.name = name;
        this.favoriteMovies = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<Movie> getFavoriteMovies() {
        return favoriteMovies;
    }

    public void addFavoriteMovie(Movie movie) {
        favoriteMovies.add(movie);
    }

    public void displayFavoriteMovies() {
        if (favoriteMovies.isEmpty()) {
            System.out.println("No favorite movies found for this user.");
        } else {
            System.out.println("Favorite Movies:");
            for (int i = 0; i < favoriteMovies.size(); i++) {
                System.out.println((i + 1) + ". " + favoriteMovies.get(i).getTitle());
            }
        }
    }
}

