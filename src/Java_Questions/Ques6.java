package Java_Questions;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.util.*;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Question 6: Creates an HTTP server that, when called, fetches and returns data from the database as configured in Question 3.
   This server is designed to be called by the client from Ques4.java.

  IMPORTANT:  you must add the MySQL JDBC driver .jar to your Run Configuration for this file (Ques6.java)

    time taken 50 mins
 */
public class Ques6 {

    // DB Configuration (same as Ques3)
    private static final String DB_URL = "jdbc:mysql://localhost:3306/goldilocks_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";
    private static final String DB_QUERY = "SELECT `Emp name`, `Emp age` FROM test";

    public static void main(String[] args) throws IOException {
        int port = 8999;

        //  create the server on port 8999
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);

        //  create a context / endpoint for /test
        // all requests to http://127.0.0.1:8999/test will be handled by 'TestHandler'
        server.createContext("/test", new TestHandler());

        //  use the default thread executor
        server.setExecutor(null);

        //  Start the server
        server.start();

        System.out.println(" Java Question 6: HTTP Server ");
        System.out.println("Server started on port " + port + ".");
        System.out.println("Listening for requests at: http://127.0.0.1:8999/test");
        System.out.println("Press Ctrl+C to stop the server.");


    }

    /**
     * This inner class handles all incoming requests to the /test context.
     */
    static class TestHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange exchange) throws IOException {

            // Handle the "received value
            String receivedValue = "";
            URI requestedUri = exchange.getRequestURI();
            String query = requestedUri.getQuery();

            // Simple parser for "value=..."
            if (query != null && query.startsWith("value=")) {
                receivedValue = query.substring("value=".length());
            }

            // print the received value to the SERVER console
            System.out.println("\n[Server Log] Received request for: " + requestedUri);
            System.out.println("[Server Log] 'value' parameter received: '" + receivedValue + "'");


            //  fetch data from the database
            String responseBody;
            int statusCode = 200; // 200 OK

            try {
                // This helper function does the DB work
                responseBody = fetchEmployeeDataFromDB();

            } catch (Exception e) {
                // Error handling: If DB connection fails, send a 500 error
                e.printStackTrace();
                statusCode = 500; // Internal Server Error
                responseBody = "500 Internal Server Error: Could not connect to database.\n" + e.getMessage();
                System.err.println("[Server Log] CRITICAL: DB connection failed: " + e.getMessage());
            }

            // Send the response back to the client
            exchange.sendResponseHeaders(statusCode, responseBody.getBytes().length);

            // Get the response output stream and write the data
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(responseBody.getBytes());
            }

            System.out.println("[Server Log] Sent " + statusCode + " response to client.");
        }
    }

    private static String fetchEmployeeDataFromDB() throws ClassNotFoundException, SQLException {
        // This 'StringBuilder' will build our response string
        StringBuilder sb = new StringBuilder();
        sb.append(" Data from 'test' table in 'goldilocks_db' -\n");
        sb.append("--------------------------------------------------\n");

        //  Ensure the JDBC driver is loaded
        Class.forName("com.mysql.cj.jdbc.Driver");

        //  Use try-with-resources to automatically close connections
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(DB_QUERY)) {

            int recordCount = 0;

            //  Loop through the results
            while (rs.next()) {
                // Retrieve by column name
                String empName = rs.getString("Emp name");
                int empAge = rs.getInt("Emp age");

                // Append to our string
                sb.append("Employee Name: ");
                sb.append(empName);
                sb.append(", Age: ");
                sb.append(empAge);
                sb.append("\n");

                recordCount++;
            }
            sb.append("--------------------------------------------------\n");
            sb.append("Successfully retrieved ").append(recordCount).append(" records.\n");

        }
        return sb.toString();
    }
}
