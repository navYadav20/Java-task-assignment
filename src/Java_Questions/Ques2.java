package Java_Questions;
import java.util.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 Solves Java Question 2:
 Reads a CSV file with three numeric columns, calculates the sum of each row, and writes the original data plus the sum to an output file.
 Includes comprehensive error handling as required by the assignment.

 time taken - 30mins

 */
public class Ques2 {

    public static void processCsvFile(String inputFilePath, String outputFilePath) {
        System.out.println("Starting CSV processing");
        System.out.println("Input file: " + inputFilePath);
        System.out.println("Output file: " + outputFilePath);

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             PrintWriter writer = new PrintWriter(new FileWriter(outputFilePath))) {

            String line;
            boolean isFirstLine = true; // To handle a potential header row

            // Read the input file line by line
            while ((line = reader.readLine()) != null) {
                // Error Handling: Skip empty lines
                if (line.trim().isEmpty()) {
                    continue;
                }

                String outputLine;
                try {
                    // Split the line by comma
                    String[] columns = line.split(",");

                    // Error Handling Check for the correct number of columns
                    if (columns.length != 3) {
                        // Create a specific error message for this line
                        throw new Exception("Malformed line (expected 3 columns, found " + columns.length + ")");
                    }


                    // handle both integers & decimals
                    double col1 = Double.parseDouble(columns[0].trim());
                    double col2 = Double.parseDouble(columns[1].trim());
                    double col3 = Double.parseDouble(columns[2].trim());

                    // if parsing succeeds, calculate the sum
                    double sum = col1 + col2 + col3;

                    // build the output line
                    outputLine = line + "," + sum;

                } catch (NumberFormatException e) {
                    //  catches non-numeric values

                    // if the first line fails, it's a header.
                    if (isFirstLine) {
                        outputLine = line + ",sum"; // Add the "sum" header
                        System.out.println("Header row detected and written to output: " + outputLine);
                    } else {
                        //  data line with bad data
                        outputLine = line + ",Error:Contains_Non-Numeric_Data";
                        System.err.println("Skipping line (non-numeric data): " + line);
                    }
                } catch (Exception e) {
                    //  catches other errors, wrong column count
                    outputLine = line + ",Error:" + e.getMessage().replace(",", ";"); // Avoid extra commas
                    System.err.println("Skipping line (malformed): " + line + " | Reason: " + e.getMessage());
                }

                // write the  line to the output file
                writer.println(outputLine);

                // after the first line, set this to false
                isFirstLine = false;
            }

            System.out.println("Successfully processed CSV file.");

        } catch (FileNotFoundException e) {
            //  input file doesn't exist
            System.err.println("CRITICAL ERROR: Input file not found at " + inputFilePath);
            e.printStackTrace();
        } catch (IOException e) {
            // Error Handling: General read/write problems
            System.err.println("CRITICAL ERROR: Could not read or write file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(" Java Question 2: CSV Summation ");

        // csv are in the project root directory.
        String inputFile = "input.csv";
        String outputFile = "output.csv";

        // call the processing function
        processCsvFile(inputFile, outputFile);

        System.out.println("Check the 'output.csv' file in your project's root folder.");
    }
}
