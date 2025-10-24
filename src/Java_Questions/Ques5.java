package Java_Questions;

import java.util.HashMap;
import java.util.Scanner;
import java.util.*;

/**
  Question 5: Write a program to store the value in Hashmap (key, store) and then search those given value from the hashmap and print it.
  a. Name is key and age is value so store some sample values like
    i. (Ram, 36), (shyam,60)

 time taken  15-20 mins

 */
public class Ques5 {

    public static void searchAndPrintAge(HashMap<String, Integer> ageMap, String name) {
        System.out.println("\nSearching for name: '" + name + "'...");

        // rrror handling  check for null or empty input
        if (name == null || name.trim().isEmpty()) {
            System.err.println("SEARCH FAILED: Name cannot be null or empty.");
            return;
        }

        //sSearch the hashmap using the .get() method
        Integer age = ageMap.get(name);

        if (age != null) {
            System.out.println("SUCCESS: Found! " + name + " is " + age + " years old.");
        } else {
            // failure Key was not found
            System.out.println("NOT FOUND: No entry exists for '" + name + "'.");

        }
    }


    public static void main(String[] args) {
        System.out.println("Java Question 5: HashMap Store and Search ");

        // create the HashMap
        HashMap<String, Integer> userAgeMap = new HashMap<>();

        // store the sample values as requested in ques
        userAgeMap.put("Ram", 36);
        userAgeMap.put("Shyam", 60);
        userAgeMap.put("Alice", 25);
        userAgeMap.put("Bob", 42);

        // print the complete map
        System.out.println("Data stored successfully in HashMap:");
        System.out.println(userAgeMap);

        // read user input
        //    using try with resources to automatically close the scanner.
        try (Scanner scanner = new Scanner(System.in)) {

            // Create an interactive loop to search
            while (true) {
                System.out.println("\nEnter a name to search for (or type 'exit' to quit):");
                String inputName = scanner.nextLine();

                //  check for the exit condition
                if (inputName.equalsIgnoreCase("exit") || inputName.equalsIgnoreCase("quit")) {
                    System.out.println("Exiting search...");
                    break;
                }

                // call the search function with the users input
                searchAndPrintAge(userAgeMap, inputName);
            }

        } catch (Exception e) {
            System.err.println("An unexpected error occurred with the input scanner.");
            e.printStackTrace();
        }

        System.out.println("Program finished.");
    }
}

