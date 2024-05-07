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

    public void removeFavoriteMovie(Movie movie) {
        favoriteMovies.remove(movie);
    }

    public void displayFavoriteMovies(Scanner scanner) {
        if (favoriteMovies.isEmpty()) {
            System.out.println("No favorite movies found for this user.\n");
        } else {
            System.out.println("Favorite Movies:");
            for (int i = 0; i < favoriteMovies.size(); i++) {
                System.out.println((i + 1) + ". " + favoriteMovies.get(i).getTitle());
            }
    
            System.out.println("Enter the number of the movie to remove from favorites (or 0 to skip):");
    
            int removeChoice = Integer.parseInt(scanner.nextLine());
            if (removeChoice > 0 && removeChoice <= favoriteMovies.size()) {
                Movie movieToRemove = favoriteMovies.get(removeChoice - 1);
                movieToRemove.setFavorite(false);
                removeFavoriteMovie(movieToRemove);
                System.out.println(movieToRemove.getTitle() + " removed from favorites.");
            } else if (removeChoice != 0) {
                System.out.println("Invalid choice.");
                return;
            }
        }
    }

    public void displayDetailsAndFavorites(Scanner scanner) {
        System.out.println();
        System.out.println("User Details: ");
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        
        System.out.println();
        displayFavoriteMovies(scanner);
    }
    
}

