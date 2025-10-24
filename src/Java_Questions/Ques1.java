package Java_Questions;

import java.util.Scanner;

/**
  Solution Java Question 1
  Write a function to convert a decimal number string into binary string. Includes error handling for invalid inputs.
  Time taken- 10-15 minutes
 */

public class Ques1 {

    public static String convertDecimalToBinary(String decimalString) {
        // Error handling: check for null or empty input
        if (decimalString == null || decimalString.trim().isEmpty()) {
            return "Error Input string is null or empty";
        }

        try {
            // Parse the string into an integer
            // if the string is not a valid integer , will throw NumberFormatException
            int decimalNumber = Integer.parseInt(decimalString);

            //  function to convert the integer to a binary string. handle 2's compliment also
            return Integer.toBinaryString(decimalNumber);

        } catch (NumberFormatException e) {
            // Error Handling: inputs not valid numbers
            return "Error: Input string '" + decimalString + "' is not a valid integer decimal number.";
        }
    }

    public static void main(String[] args) {
        System.out.println(" Java Question 1: Decimal String to Binary String ");

        String exampleInput = "123";
        System.out.println("Example Input: \"" + exampleInput + "\"");
        System.out.println("Example Output: " + convertDecimalToBinary(exampleInput));
        System.out.println("--------------------------------------------------");

        // Demonstrate with other test cases
        String[] testCases = {
                "0",
                "42",
                "-15", // test negative number (two's complement)
                "abc",
                "123.45", //  non-integer
                "",    //  empty string
                null   // null input
        };

        System.out.println("Running additional test cases");
        for (String testCase : testCases) {
            System.out.printf("Input: %-10s | Output: %s\n", "\"" + testCase + "\"", convertDecimalToBinary(testCase));
        }
        System.out.println("--------------------------------------------------");

        //  user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter a decimal number string (or 'q' to quit): ");
        String userInput = scanner.nextLine();

        while (!"q".equalsIgnoreCase(userInput)) {
            System.out.println("Binary Output: " + convertDecimalToBinary(userInput));
            System.out.print("\nEnter a decimal number string (or 'q' to quit): ");
            userInput = scanner.nextLine();
        }
    }
}
