import java.util.*;

public class Main {
    private static List<Movie> movies = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        movies.add(new Movie("The Shawshank Redemption", List.of("Tim Robbins", "Morgan Freeman"), "Drama", "1994", 25.0));
        movies.add(new Movie("The Godfather", List.of("Marlon Brando", "Al Pacino"), "Crime", "1972", 6.0));
        movies.add(new Movie("The Dark Knight", List.of("Christian Bale", "Heath Ledger"), "Action", "2008", 185.0));
    

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Movie Listing App\n");

        while (true) {
            System.out.print("Enter 1 for registration and 0 to exit : ");

            String input = scanner.nextLine();

            if (input.equals("0")) {
                scanner.close(); 
                System.exit(0);
            }

            if (input.equals("1")){
                System.out.println("For registration ->");
                System.out.print("Enter your email: ");
                String email = scanner.nextLine();
                System.out.print("Enter your name : ");
                String name = scanner.nextLine();
                
                User user = new User(email, name);
                while (true) {
                    Home(scanner, user);
                }
            }
            else {
                System.out.println("Enter a valid option!!");
                ContinueOrExit(scanner);
            }
        }        
        
    }


    public static void ContinueOrExit(Scanner scanner){
        System.out.print("Enter 1 for continue and 0 to exit : ");

        String input = scanner.nextLine();
        if (input.equals("0")) {
            System.exit(0);
        }
        return;
    }

    public static void Home(Scanner scanner, User user){
        System.out.print("Enter 1 for searching movies, 2 for See movie details by Title, 3 for Favorite Movies List and 0 to exit: ");

        String input = scanner.nextLine();

        if (input.equals("0")) {
            System.exit(0);
        }

        if (input.equals("1")){
            searchMovies(scanner, user);
        }
        else if (input.equals("2")){
            displayMovieDetails(scanner);
        }
        else if(input.equals("3")){
            user.displayFavoriteMovies(scanner);
        }

        return;
    }

    public static void searchMovies(Scanner scanner, User user) {
        System.out.println("Search Movies:-> ");
        System.out.println("Enter search keyword (title, cast, or category): ");
        String keyword = scanner.nextLine().toLowerCase();

        List<Movie> matchingMovies = new ArrayList<>();
        for (Movie movie : movies) {
            if (movie.getTitle().toLowerCase().contains(keyword)
                    || movie.getCast().stream().anyMatch(actor -> actor.toLowerCase().contains(keyword))
                    || movie.getCategory().toLowerCase().contains(keyword)) {
                matchingMovies.add(movie);
            }
        }

        if (matchingMovies.isEmpty()) {
            System.out.println("No matching movies found.\n");
            return;
        } else {
            Collections.sort(matchingMovies, Comparator.comparing(Movie::getTitle));

            System.out.println("Matching Movies: ");
            for (int i = 0; i < matchingMovies.size(); i++) {
                System.out.println((i + 1) + ". " + matchingMovies.get(i).getTitle());
            }
            System.out.println();

            System.out.print("Enter the number of the movie to add to favorites (or 0 to skip): ");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice > 0 && choice <= matchingMovies.size()) {
                Movie selectedMovie = matchingMovies.get(choice - 1);
                selectedMovie.setFavorite(true);
                user.addFavoriteMovie(selectedMovie);
                System.out.println(selectedMovie.getTitle() + " added to favorites.");
            } else {
                System.out.println("Invalid choice.");
                return;
            }

            System.out.println();
            System.out.println("List of your favorite movies");
            user.displayFavoriteMovies(scanner);
            System.err.println();
        }
        return;
    }


    public static void displayMovieDetails(Scanner scanner) {
        System.out.print("Enter the title of the movie to see details: ");
            String title = scanner.nextLine();
            Movie selectedMovie = findMovieByTitle(title, movies);
            if (selectedMovie != null) {
                selectedMovie.displayDetails();
            } else {
                System.out.println("Movie not found.\n");
            }
    }

    public static Movie findMovieByTitle(String title, List<Movie> movies) {
        for (Movie movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                return movie;
            }
        }
        return null;
    }
    
}
