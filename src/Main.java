import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Movie Listing App\n");
        RegisterUser registerUser = new RegisterUser();
        
        boolean validOption = false;
        while (!validOption) {
            System.out.print("Enter 1 for registration, 2 for login and 0 to exit : ");

            String input = scanner.nextLine();

            if (input.equals("0")) {
                System.exit(0);
            }

            if (input.equals("1")){
                register(registerUser, scanner); 
                validOption = true;
            }
            else if (input.equals("2")) {
                login(registerUser, scanner); 
                validOption = true;
            } else {
                System.out.println("Enter a valid option!!");
                ContinueOrExit(scanner);
            }
        }        
        scanner.close(); 
    }

    public static void register(RegisterUser registerUser, Scanner scanner) {
        System.out.println("For registration ->");
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        System.out.print("Enter your name : ");
        String name = scanner.nextLine();

        registerUser.register(email, name); 
        registerUser.displayRegisteredUsers(); 
        login(registerUser, scanner); 
    }

    public static void login(RegisterUser registerUser, Scanner scanner) {
        System.out.println("For login ->");
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        if (registerUser.checkedRegisterUser(email)) {
            System.out.println("Login successful! Welcome back....");
        } else {
            System.out.println("Login failed. User not found. Please register first.");
            ContinueOrExit(scanner);
            register(registerUser, scanner);
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
}
