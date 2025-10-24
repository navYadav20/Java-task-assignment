package Java_Questions;
import java.util.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Solves Java Question 3: Reads data from a MySQL database table 'test' with schema (Emp name, Emp age). Includes comprehensive error handling.

  NOTE: This program has prerequisites:
  1. A MySQL server must be running.
  2. A database  must exist.
  3. A table 'test' with the correct schema must exist.
  4. The MySQL JDBC Driver JAR must be added to the project dependencies.

 // IMPORTANT: you must add the MySQL JDBC driver .jar to your Run Configuration for this file

 time taken - 50-55 mins

 */
public class Ques3 {

    // database config
    // Change this DB_NAME if your database is named something else
    private static final String DB_NAME = "goldilocks_db";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/" + DB_NAME;

    // credentials as specified
    private static final String DB_USER = "root";
    private static final String DB_PASS = "root";


    // using backticks ` because the column names have spaces
    private static final String SQL_QUERY = "SELECT `Emp name`, `Emp age` FROM test";


    public void readDataFromDB() {
        System.out.println("Java Question 3: Read from DB ");
        System.out.println("Attempting to connect to database: " + DB_URL);

        // this is a try with resources block
        // it automatically closes the Connection, Statement, and ResultSet even if an error occurs, which is a key part of error handling.
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL_QUERY)) {

            System.out.println("Connection successful Retrieving data...");
            System.out.printf("%-20s | %-5s\n", "Employee Name", "Age");

            int recordCount = 0;
            // Loop through the results row by row
            while (rs.next()) {
                // Retrieve data by column name
                String empName = rs.getString("Emp name");
                int empAge = rs.getInt("Emp age");

                // Print the data
                System.out.printf("%-20s | %-5d\n", empName, empAge);
                recordCount++;
            }
            System.out.println("------------------------------------------");
            System.out.println("Successfully retrieved " + recordCount + " records.");

        } catch (SQLException e) {
            // Comprehensive Error Handling
            System.err.println("CRITICAL SQL ERROR: An error occurred while interacting with the database.");
            System.err.println("SQL State: " + e.getSQLState());
            System.err.println("Error Code: " + e.getErrorCode());
            System.err.println("Message: " + e.getMessage());
            System.err.println("\n--- Common Causes & Fixes ---");
            if (e.getErrorCode() == 1045) {
                System.err.println("-> Access denied. Check your USER ('root') and PASS ('root').");
            } else if (e.getErrorCode() == 1049) {
                System.err.println("-> Unknown database '" + DB_NAME + "'. Did you run the SQL setup script?");
            } else if (e.getErrorCode() == 1146) {
                System.err.println("-> Table 'test' doesn't exist. Did you run the SQL setup script?");
            } else if (e.getMessage().contains("Communications link failure")) {
                System.err.println("-> Cannot connect to MySQL. Is the server running on localhost:3306?");
            } else {
                e.printStackTrace();
            }
        } catch (Exception e) {
            // Catch any other unexpected errors
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Error handling for the driver itself
        try {
            // This line explicitly loads the driver.
            // Required by some older Java/JDBC versions, good practice to include.
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("CRITICAL DRIVER ERROR: MySQL JDBC Driver not found!");
            System.err.println("Please follow 'Part 2' instructions to add the .jar file to IntelliJ.");
            e.printStackTrace();
            return; // Exit if the driver is missing
        }

        Ques3 dbReader = new Ques3();
        dbReader.readDataFromDB();
    }
}
