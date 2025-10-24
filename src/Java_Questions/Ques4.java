package Java_Questions;
import java.util.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;

/**
  Question 4: Calls a specific HTTP URL and prints the output. Includes comprehensive error handling for timeouts, connection failures, etc.

  time taken - 1hrs

 */
public class Ques4 {

    public static void callHttpUrl(String urlString) {
        System.out.println("Attempting to call URL: " + urlString);

        HttpURLConnection connection = null;

        try {
            //  create URL and open connection
            URL url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();

            //  set request method and timeouts
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000); // 5-second connection timeout
            connection.setReadTimeout(5000);    // 5-second read timeout

            //  get the HTTP response code
            int statusCode = connection.getResponseCode();
            System.out.println("HTTP Status Code: " + statusCode);

            // determine which stream to read from
            BufferedReader reader;
            if (statusCode >= 200 && statusCode <= 299) {
                // success read from the input stream
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            } else {
                // error read from the error stream
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            }

            // read the response body
            StringBuilder responseBody = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                responseBody.append(line);
                responseBody.append("\n"); // Add newline for readability
            }
            reader.close();

            System.out.println("Response Body:");
            if (responseBody.length() == 0) {
                System.out.println("[No Response Body]");
            } else {
                System.out.println(responseBody.toString().trim());
            }

        } catch (ConnectException e) {
            // rror handling  connection refused
            System.err.println("CRITICAL ERROR: Connection refused.");
            System.err.println("Message: " + e.getMessage());
            System.err.println("ASSUMPTION: This is expected. No server is running on " + urlString);
            System.err.println("This program will work once the server from Question 6 is running.");

        } catch (SocketTimeoutException e) {
            // error handling Timeout
            System.err.println("CRITICAL ERROR: The request timed out.");
            System.err.println("Message: " + e.getMessage());

        } catch (MalformedURLException e) {
            // error Handling: invalid URL
            System.err.println("CRITICAL ERROR: The URL is malformed (invalid).");
            System.err.println("Message: " + e.getMessage());

        } catch (IOException e) {
            //  Error Handling: General I/O problem
            System.err.println("CRITICAL ERROR: An I/O error occurred.");
            System.err.println("Message: " + e.getMessage());
            e.printStackTrace();

        } finally {
            // always disconnect to free up resources
            if (connection != null) {
                connection.disconnect();
                System.out.println("\nConnection closed.");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(" Java Question 4: HTTP URL Caller ");

        // Call the URL
        String pdfUrl = "http://127.0.0.1:8999/test?value=p";
        callHttpUrl(pdfUrl);

        // call a working URL to prove the code is correct
        //  call a public test API that returns the caller's IP address, this demonstrates a successful call.
        System.out.println("\n\n=== Demonstration of a SUCCESSFUL call ===");
        String workingTestUrl = "https://api.ipify.org";
        callHttpUrl(workingTestUrl);

        System.out.println("Program finished.");
    }
}
