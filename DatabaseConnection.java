package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Singleton database connection manager utilizing JDBC.
 */
public class DatabaseConnection {
    private static final String URL = "jdbc:sqlite:C:/QuizGame/database/quizgame.db";
    private static Connection connection = null;

    private DatabaseConnection() {
        // private constructor
    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                // Explicitly load the SQLite JDBC driver just in case
                Class.forName("org.sqlite.JDBC");
                
                // Ensure directory exists by making sure URL is correct; 
                // SQLite will create the file if it doesn't exist.
                connection = DriverManager.getConnection(URL);
                createTablesIfNotExist(connection);
            } catch (ClassNotFoundException e) {
                System.out.println("SQLite JDBC Driver not found: " + e.getMessage());
            } catch (SQLException e) {
                System.out.println("Error connecting to database: " + e.getMessage());
            }
        }
        return connection;
    }

    private static void createTablesIfNotExist(Connection conn) {
        String createUsersSql = "CREATE TABLE IF NOT EXISTS users ("
                + " id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + " name TEXT NOT NULL UNIQUE"
                + ");";

        String createScoresSql = "CREATE TABLE IF NOT EXISTS scores ("
                + " id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + " user_id INTEGER NOT NULL,"
                + " score INTEGER NOT NULL,"
                + " difficulty TEXT NOT NULL,"
                + " FOREIGN KEY(user_id) REFERENCES users(id) ON DELETE CASCADE"
                + ");";

        try (Statement stmt = conn.createStatement()) {
            stmt.execute(createUsersSql);
            stmt.execute(createScoresSql);
        } catch (SQLException e) {
            System.out.println("Error creating tables: " + e.getMessage());
        }
    }
}
