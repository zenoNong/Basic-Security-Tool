package main.java.com.securitytool;


import java.util.Scanner;

public class SecurityToolInterface {
    private VulnerabilityScanner scanner;
    private EncryptionTool encryptionTool;
    private UserAuthentication auth;

    public SecurityToolInterface() throws Exception {
        scanner = new VulnerabilityScanner();
        encryptionTool = new EncryptionTool();
        auth = new UserAuthentication();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Scan for Vulnerabilities");
            System.out.println("2. Encrypt Data");
            System.out.println("3. Decrypt Data");
            System.out.println("4. Register User");
            System.out.println("5. Authenticate User");
            System.out.println("6. Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    scanForVulnerabilities();
                    break;
                case 2:
                    encryptData();
                    break;
                case 3:
                    decryptData();
                    break;
                case 4:
                    registerUser();
                    break;
                case 5:
                    authenticateUser();
                    break;
                case 6:
                    return;
            }
        }
    }

    private void scanForVulnerabilities() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter input to scan for vulnerabilities:");
        String input = scanner.nextLine();
        if (this.scanner.scanForSQLInjection(input)) {
            System.out.println("Vulnerability found!");
        } else {
            System.out.println("No vulnerabilities found.");
        }
    }

    private void encryptData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter data to encrypt:");
        String data = scanner.nextLine();
        try {
            String encryptedData = encryptionTool.encrypt(data);
            System.out.println("Encrypted Data: " + encryptedData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void decryptData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter data to decrypt:");
        String encryptedData = scanner.nextLine();
        try {
            String decryptedData = encryptionTool.decrypt(encryptedData);
            System.out.println("Decrypted Data: " + decryptedData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void registerUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username:");
        String username = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();
        auth.registerUser(username, password);
        System.out.println("User registered successfully.");
    }

    private void authenticateUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username:");
        String username = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();
        if (auth.authenticateUser(username, password)) {
            System.out.println("User authenticated successfully.");
        } else {
            System.out.println("Authentication failed.");
        }
    }
}

