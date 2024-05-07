import java.util.*;

public class Main {
    private static List<Movie> movies = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        movies.add(new Movie("The Shawshank Redemption", List.of("Tim Robbins", "Morgan Freeman"), "Drama", "1994", 25.0));
        movies.add(new Movie("The Godfather", List.of("Marlon Brando", "Al Pacino"), "Crime", "1972", 6.0));
        movies.add(new Movie("The Dark Knight", List.of("Christian Bale", "Heath Ledger"), "Action", "2008", 185.0));
    

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Movie Listing App\n");
        RegisterUser registerUser = new RegisterUser();

        while (true) {
            System.out.print("Enter 1 for registration, 2 for login and 0 to exit : ");

            String input = scanner.nextLine();

            if (input.equals("0")) {
                scanner.close(); 
                System.exit(0);
            }

            if (input.equals("1")){
                register(registerUser, scanner); 
            }
            else if (input.equals("2")) {
                login(registerUser, scanner); 
            } else {
                System.out.println("Enter a valid option!!");
                ContinueOrExit(scanner);
            }
        }        
        
    }

    public static void register(RegisterUser registerUser, Scanner scanner) {
        System.out.println("For registration ->");
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        System.out.print("Enter your name : ");
        String name = scanner.nextLine();

        registerUser.register(email, name); 
        registerUser.displayRegisteredUsers(); 
        System.out.println();
        login(registerUser, scanner); 
        return;
    }

    public static void login(RegisterUser registerUser, Scanner scanner) {
        System.out.println("For login ->");
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        if (registerUser.checkedRegisterUser(email)) {
            System.out.println("Login successful! Welcome back....\n");
            while (true) {
                Home(scanner);
            }

        } else {
            System.out.println("Login failed. User not found. Please register first.\n");
            ContinueOrExit(scanner);
            
        }
        return;
    }

    public static void ContinueOrExit(Scanner scanner){
        System.out.print("Enter 1 for continue and 0 to exit : ");

        String input = scanner.nextLine();
        if (input.equals("0")) {
            System.exit(0);
        }
        return;
    }

    public static void Home(Scanner scanner){
        System.out.print("Enter 1 for searching movies, 0 to exit: ");

        String input = scanner.nextLine();

        if (input.equals("0")) {
            System.exit(0);
        }

        if (input.equals("1")){
            searchMovies(scanner);
        }

        return;
    }

    public static void searchMovies(Scanner scanner) {
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
        } else {
            Collections.sort(matchingMovies, Comparator.comparing(Movie::getTitle));

            System.out.println("Matching Movies: ");
            for (Movie movie : matchingMovies) {
                System.out.println("Title: " + movie.getTitle());
            }
            System.out.println();
        }
        return;
    }


}
