package com.kishore;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

    class UserAuthentication {
        private Map<String, String> userCredentials;  // Simulating storage of user credentials

        public UserAuthentication() {
            this.userCredentials = new HashMap<>();
        }

        public void registerUser(String username, String password) {
            userCredentials.put(username, password);
            System.out.println("Registration successful for user: " + username);
        }

        public boolean authenticateUser(String username, String password) {
            return userCredentials.containsKey(username) && userCredentials.get(username).equals(password);
        }
    }

    public class AuthenticationApp {
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserAuthentication userAuthenticator = new UserAuthentication();

        while (true) {
            System.out.println("1. Register\n2. Login\n3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String regUsername = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String regPassword = scanner.nextLine();
                    userAuthenticator.registerUser(regUsername, regPassword);
                    break;

                case 2:
                    System.out.print("Enter username: ");

                    String loginUsername = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String loginPassword = scanner.nextLine();

                    if (userAuthenticator.authenticateUser(loginUsername, loginPassword)) {
                        System.out.println("Login successful!");
                    } else {
                        System.out.println("Login failed. Invalid username or password.");
                    }
                    break;

                case 3:
                    System.out.println("Exiting the application. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
