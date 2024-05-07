import java.util.Map;
import java.util.HashMap;

public class RegisterUser {
    private Map<String, String> users;
    RegisterUser() {
        users = new HashMap<>();
    }

    public void register(String email, String name) {
        users.put(email, name);
        System.out.println("User registered successfully.");
    }

    public void displayRegisteredUsers() {
        System.out.println("Registered Users:");
        for (Map.Entry<String, String> entry : users.entrySet()) {
            System.out.println("Email: " + entry.getKey() + ", Name: " + entry.getValue());
        }
    }

    public boolean checkedRegisterUser(String email) {
        if (users.containsKey(email)) {
            return true;
        } else {
            return false;
        }
    }
}
