package week3.task2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {
    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/lab3"; // Replace "mydb" with your database name
    private static final String USERNAME = "root"; // Replace with your actual MySQL username
    private static final String PASSWORD = "1234"; // Replace with your MySQL password or leave it blank if no password

    private Connection connection = null;

    public DbConnect() {
        try {
            // Attempt to connect to the database
            connection = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);
            System.out.println("Connected to the database successfully!");
        } catch (SQLException e) {
            // Print out error information if connection fails
            e.printStackTrace();
            throw new RuntimeException("Failed to connect to the database", e);
        }
    }

    public Connection getConnection() {
        return connection;
    }

    // A method to close the connection when done
    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Database connection closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}


