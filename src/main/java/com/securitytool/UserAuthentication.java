package main.java.com.securitytool;


import java.util.HashMap;
import java.util.Map;

public class UserAuthentication {
    private Map<String, String> userStore;

    public UserAuthentication() {
        userStore = new HashMap<>();
    }

    public void registerUser(String username, String password) {
        String hashedPassword = hashPassword(password);
        userStore.put(username, hashedPassword);
    }

    public boolean authenticateUser(String username, String password) {
        String hashedPassword = userStore.get(username);
        return hashedPassword != null && hashedPassword.equals(hashPassword(password));
    }

    private String hashPassword(String password) {
        // Hashing logic
        return password; // Placeholder
    }
}

