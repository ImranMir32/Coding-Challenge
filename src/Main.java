import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Movie Listing App\n");
        boolean validOption = false;
        while (!validOption) {
            System.out.print("Enter 1 for registration, 2 for login and 0 to exit : ");

            String input = scanner.nextLine();

            if (input.equals("0")) {
                System.exit(0);
            }

            if (input.equals("1")){
                register(scanner);
                validOption = true;
            }
            else {
                System.out.println("Enter a valid option!!");
            }
        }        
        scanner.close(); 
    }

    public static void register(Scanner scanner) {
        RegisterUser registerUser = new RegisterUser();

        System.out.println("For registration ->");
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        System.out.print("Enter your name : ");
        String name = scanner.nextLine();

        registerUser.register(email, name); 
        registerUser.displayRegisteredUsers();
       
    }
}
