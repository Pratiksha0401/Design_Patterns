package org.example.SolidPrinciples.SingleResponsibilityPrinciple.good;


import java.io.FileWriter;
import java.io.IOException;

/**
 * Demonstrates a good example of the Single Responsibility Principle (SRP).
 * The User class handles only user-related data.
 * The UserPersistence class handles the file-saving logic.
 */
public class SingleResponsibility_Good {
    public static void main(String[] args) {
        User user = new User("John Doe", "john.doe@example.com");
        UserPersistence persistence = new UserPersistence();
        persistence.saveToFile(user);
    }
}

/**
 * This class represents user data.
 *
 * It is only responsible for storing and providing user information.
 * It has no knowledge of how or where the data is saved.
 */
class User {
    private String name;
    private String email;

    /**
     * Constructor to initialize a user object.
     *
     * @param name  the name of the user
     * @param email the email address of the user
     */
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    /**
     * Gets the user's name.
     *
     * @return the name of the user
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the user's email.
     *
     * @return the email of the user
     */
    public String getEmail() {
        return email;
    }
}

/**
 * Handles persistence logic (e.g., saving user data to a file).
 *
 * This class is responsible only for saving user data to files, and
 * does not manage any user business logic.
 */
class UserPersistence {

    /**
     * Saves the given user’s information to a text file.
     *
     * @param user the user object whose data is to be saved
     */
    public void saveToFile(User user) {
        try (FileWriter fileWriter = new FileWriter(user.getName() + ".txt")) {
            fileWriter.write("Name: " + user.getName() + "\n");
            fileWriter.write("Email: " + user.getEmail() + "\n");
            System.out.println("User data saved to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

