package org.example.SolidPrinciples.SingleResponsibilityPrinciple.bad;

import java.io.FileWriter;
import java.io.IOException;

/**
 * This class demonstrates a violation of the Single Responsibility Principle (SRP).
 * In this example, the User class is responsible for both representing user data
 * and saving user data to a file, which are two separate responsibilities.
 *
 * SRP states that a class should have only one reason to change.
 * Here, if file handling changes, we would have to modify the User class,
 * which ideally should only be responsible for user-related logic.
 */
public class SingleResponsibility_Bad {
    public static void main(String[] args) {
        User user = new User("John Doe", "john.doe@example.com");
        user.saveToFile(); // User class is taking responsibility for file I/O - not good
    }
}

/**
 * Represents a user with name and email.
 *
 * BAD DESIGN: This class violates SRP by also managing persistence logic (file writing).
 */
class User {
    private String name;
    private String email;

    /**
     * Constructor to create a User object.
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

    /**
     * BAD PRACTICE:
     * This method saves user data to a file, which introduces a second responsibility
     * (file handling) into a class that should only deal with user data.
     * Changes in file-saving logic will force modification in the User class.
     */
    public void saveToFile() {
        try (FileWriter fileWriter = new FileWriter(name + ".txt")) {
            fileWriter.write("Name: " + name + "\n");
            fileWriter.write("Email: " + email + "\n");
            System.out.println("User data saved to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
