package Java_Questions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
  Question 10: Reads a CSV file with 3 columns and finds the count of records which have the same value in 'col3'.
  It will then print out the values that have "multiple occurrences" (count > 1).

 *  time taken - 30-35 mins
 */
public class Ques10 {

    public static void main(String[] args) {
        System.out.println(" Java Question 10: Find Multiple Occurrences in CSV ");

        //  Define the file path. (Assumes file is in project root)
        String filePath = "Ques10_input.csv";

        //  using a HashMap to store the counts.
        // Key: The value from col3 (e.g., "pending")
        // Value: The number of times it has appeared (e.g., 3)
        Map<String, Integer> valueCounts = new HashMap<>();

        String line = "";
        String headerLine = "";
        int lineCounter = 0;

        // Use try-with-resources to automatically close the reader
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            // read the first line to skip it from counting
            headerLine = br.readLine();
            if (headerLine == null) {
                System.err.println("File is empty: " + filePath);
                return;
            }
            lineCounter++; // Count header as line 1

            // loop through the rest of the file
            while ((line = br.readLine()) != null) {
                lineCounter++;

                // Error Handling: Empty Line
                if (line.trim().isEmpty()) {
                    System.out.println("[INFO] Skipping empty line at line " + lineCounter);
                    continue;
                }

                // split the line by comma
                String[] columns = line.split(",");

                //   Malformed line
                // vheck if the line has at least 3 columns
                if (columns.length < 3) {
                    System.err.println("[SKIPPING] Malformed line " + lineCounter +
                            " (expected 3+ columns): \"" + line + "\"");
                    continue;
                }

                // get the value from the 3rd column
                //  .trim() to remove any accidental whitespace
                String col3Value = columns[2].trim();

                // update the count in the HashMap
                // getOrDefault(key, 0) will get the current count, or 0 if it's the first time
                valueCounts.put(col3Value, valueCounts.getOrDefault(col3Value, 0) + 1);
            }

        } catch (FileNotFoundException e) {
            System.err.println("CRITICAL ERROR: File not found at path: " + filePath);
            return;
        } catch (IOException e) {
            System.err.println("CRITICAL ERROR: Could not read file: " + e.getMessage());
            return;
        }

        // print the results
        System.out.println("\n Full Occurrence Report (col3) ");
        if (valueCounts.isEmpty()) {
            System.out.println("No data records found (only a header).");
            return;
        }

        for (Map.Entry<String, Integer> entry : valueCounts.entrySet()) {
            System.out.println("Value: '" + entry.getKey() + "', Count: " + entry.getValue());
        }

        //  Print ONLY the multiple occurrences
        System.out.println("\n--- Multiple Occurrences (count > 1) ---");
        boolean foundMultiples = false;
        for (Map.Entry<String, Integer> entry : valueCounts.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("Value: '" + entry.getKey() + "' has " +
                        entry.getValue() + " occurrences.");
                foundMultiples = true;
            }
        }

        if (!foundMultiples) {
            System.out.println("No values were found with multiple occurrences.");
        }
    }
}
