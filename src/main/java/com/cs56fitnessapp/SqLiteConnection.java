package com.cs56fitnessapp;
import java.sql.*;


/**
 * @author Ksenia Koldaeva
 * Created: 11/8/17
 * Last Updated: 11/8/17
 */

public class SqLiteConnection {

    // will handle connection to the DB
    private static Connection connection = null;

    // flag to keep track whether the table exists
    private static boolean hasData = false;

    /**
     * Initializes application tables when first time executed
     * @throws SQLException if a problem with table creation occurs
     */
    private void initialize() throws SQLException {
        if (!hasData) {
            hasData = true;
            Statement statement = connection.createStatement();

            // drop tables if exist
            statement.executeUpdate("DROP TABLE IF EXISTS gender");
            statement.executeUpdate("DROP TABLE IF EXISTS activity_level");
            statement.executeUpdate("DROP TABLE IF EXISTS goal");
            statement.executeUpdate("DROP TABLE IF EXISTS user");

            // create tables
            // gender table to hold enum variants
            statement.executeUpdate("CREATE TABLE gender (gender VARCHAR(6) PRIMARY KEY NOT NULL UNIQUE)");
            statement.executeUpdate("INSERT INTO gender(gender) VALUES ('male')");
            statement.executeUpdate("INSERT INTO gender(gender) VALUES ('female')");

            // activity_level table to hold enum variants
            statement.executeUpdate("CREATE TABLE activity_level (activity_level VARCHAR(20) PRIMARY KEY NOT NULL UNIQUE)");
            statement.executeUpdate("INSERT INTO activity_level(activity_level) VALUES ('sedentary')");
            statement.executeUpdate("INSERT INTO activity_level(activity_level) VALUES ('somewhat_active')");
            statement.executeUpdate("INSERT INTO activity_level(activity_level) VALUES ('active')");
            statement.executeUpdate("INSERT INTO activity_level(activity_level) VALUES ('very_active')");

            // goal table to hold enum variants
            statement.executeUpdate("CREATE TABLE goal (goal VARCHAR(8) PRIMARY KEY NOT NULL UNIQUE)");
            statement.executeUpdate("INSERT INTO goal(goal) VALUES ('lose')");
            statement.executeUpdate("INSERT INTO goal(goal) VALUES ('maintain')");
            statement.executeUpdate("INSERT INTO goal(goal) VALUES ('gain')");

            // user table
            statement.executeUpdate("CREATE TABLE user (" +
                                         "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE," +
                                         "name VARCHAR(255)," +
                                         "username VARCHAR(255) UNIQUE NOT NULL," +
                                         "password VARCHAR(255) NOT NULL," +
                                         "gender VARCHAR(6) REFERENCES gender(gender)," +
                                         "date_of_birth DATE," +
                                         "body_mass_kg SMALLINT UNSIGNED," +
                                         "height_cm SMALLINT UNSIGNED," +
                                         "goal VARCHAR(8) REFERENCES goal(goal)," +
                                         "goal_weight_kg SMALLINT UNSIGNED," +
                                         "activity_level VARCHAR(20) REFERENCES activity_level(activity_level))");

        }
    }

    /**
     * Establish connection with database via JDBC driver
     * Creates a database if it does not exist
     * If there is no data in a database - initializes tables for the application
     * @throws ClassNotFoundException if sqlite-JDBC driver is not found
     * @throws SQLException when sqlite queries do not execute correctly
     */
    public void getConnection() throws ClassNotFoundException, SQLException {
        // load the sqlite-JDBC driver using the current class loader
        Class.forName("org.sqlite.JDBC");

        // create a database connection
        connection = DriverManager.getConnection("jdbc:sqlite:fitness-app.db");

        if (!hasData) {
            initialize();
        }

        // TODO remove test statements below
        Statement statement = connection.createStatement();
        statement.executeUpdate("INSERT INTO user(name, username, password) VALUES('Ksenia', 'kseniauser', 'randompass')");
        ResultSet rs = statement.executeQuery("SELECT * FROM user");
        while(rs.next()) {
            // read the result set
            System.out.println("name = " + rs.getString("name"));
            System.out.println("id = " + rs.getInt("id"));
        }
    }

    /**
     * Closes previously opened connection
     * @throws SQLException when connection close fails
     */
    public void closeConnection() throws SQLException {
        if(connection != null) {
            connection.close();
        }
    }

}
