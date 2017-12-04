package com.cs56fitnessapp.services;
import com.sun.glass.ui.Cursor;

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
    public void initialize() throws SQLException, ClassNotFoundException {
        if (!SqLiteConnection.hasData) {
            SqLiteConnection.hasData = true;
            Statement statement = connection.createStatement();

            // create tables
            // gender table to hold enum variants
            if (!tableExists("gender")) { // check is needed because of INSERT query
                statement.executeUpdate("CREATE TABLE IF NOT EXISTS gender (gender VARCHAR(6) PRIMARY KEY NOT NULL UNIQUE)");
                statement.executeUpdate("INSERT INTO gender(gender) VALUES ('male')");
                statement.executeUpdate("INSERT INTO gender(gender) VALUES ('female')");
            }

            // activity_level table to hold enum variants
            if (!tableExists("activity_level")) { // check is needed because of INSERT query
                statement.executeUpdate("CREATE TABLE IF NOT EXISTS activity_level (activity_level VARCHAR(20) PRIMARY KEY NOT NULL UNIQUE)");
                statement.executeUpdate("INSERT INTO activity_level(activity_level) VALUES ('sedentary')");
                statement.executeUpdate("INSERT INTO activity_level(activity_level) VALUES ('somewhat_active')");
                statement.executeUpdate("INSERT INTO activity_level(activity_level) VALUES ('active')");
                statement.executeUpdate("INSERT INTO activity_level(activity_level) VALUES ('very_active')");
            }

            // goal table to hold enum variants
            if (!tableExists("goal")) {
                statement.executeUpdate("CREATE TABLE IF NOT EXISTS goal (goal VARCHAR(8) PRIMARY KEY NOT NULL UNIQUE)");
                statement.executeUpdate("INSERT INTO goal(goal) VALUES ('lose')");
                statement.executeUpdate("INSERT INTO goal(goal) VALUES ('maintain')");
                statement.executeUpdate("INSERT INTO goal(goal) VALUES ('gain')");
            }

            // user table
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS user (" +
                                         "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE," +
                                         "name VARCHAR(255)," +
                                         "username VARCHAR(255) UNIQUE NOT NULL," +
                                         "email VARCHAR(255) UNIQUE NOT NULL," +
                                         "password VARCHAR(255) NOT NULL," +
                                         "gender VARCHAR(6) REFERENCES gender(gender)," +
                                         "date_of_birth DATE," +
                                         "body_mass_kg DECIMAL UNSIGNED," +
                                         "height_cm DECIMAL UNSIGNED," +
                                         "goal VARCHAR(8) REFERENCES goal(goal)," +
                                         "weekly_goal_kg DECIMAL UNSIGNED," +
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
    }

    /**
     * Establish connection with database via JDBC driver
     * Returns connection object to the caller
     * @throws ClassNotFoundException if sqlite-JDBC driver is not found
     * @throws SQLException when sqlite queries do not execute correctly
     */
    public Connection getConnectionObj() throws ClassNotFoundException, SQLException {
        // load the sqlite-JDBC driver using the current class loader
        Class.forName("org.sqlite.JDBC");

        // create a database connection
        connection = DriverManager.getConnection("jdbc:sqlite:fitness-app.db");
        return connection;
    }

    public void resetDb() throws ClassNotFoundException, SQLException {
        if(connection == null) {
            this.getConnection();
        }
        SqLiteConnection.hasData = false;
        Statement statement = connection.createStatement();

        // drop tables if exist
        statement.executeUpdate("DROP TABLE IF EXISTS gender");
        statement.executeUpdate("DROP TABLE IF EXISTS activity_level");
        statement.executeUpdate("DROP TABLE IF EXISTS goal");
        statement.executeUpdate("DROP TABLE IF EXISTS user");

        if(connection != null) {
            connection.close();
        }
    }

    public void testDb() throws SQLException, ClassNotFoundException {
        if(connection == null) {
            this.getConnection();
        }

        Statement statement = connection.createStatement();
        statement.executeUpdate("INSERT INTO user(name, username, email, password) VALUES('Ksenia', 'kseniauser', 'kk@host.com', 'randompass')");
        ResultSet rs = statement.executeQuery("SELECT * FROM user");
        while(rs.next()) {
            // read the result set
            System.out.println("name = " + rs.getString("name"));
            System.out.println("id = " + rs.getInt("id"));
            System.out.println("email = " + rs.getString("email"));
        }

        if(connection != null) {
            connection.close();
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

    public boolean tableExists(String tableName) throws SQLException, ClassNotFoundException {
        boolean exists = false;
        if(connection == null) {
            this.getConnection();
        }

        DatabaseMetaData dbm = connection.getMetaData();
        // check if "employee" table is there
        ResultSet tables = dbm.getTables(null, null, tableName, null);
        if (tables.next()) {
            exists = true;
        }

        return exists;
    }

}
