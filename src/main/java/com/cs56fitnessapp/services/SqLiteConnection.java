package com.cs56fitnessapp.services;
import com.sun.glass.ui.Cursor;

import java.sql.*;


/**
 * @author Ksenia Koldaeva
 * @author Omurbek Nazarov
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

            // food table
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS food (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE, " +
                    "name VARCHAR(255) NOT NULL, " +
                    "serving_size VARCHAR(255) NOT NULL, " +
                    "calories INTEGER UNSIGNED NOT NULL," +
                    "cholesterol DECIMAL UNSIGNED, " +
                    "sodium DECIMAL UNSIGNED, " +
                    "total_fat DECIMAL UNSIGNED, " +
                    "saturated_fat DECIMAL UNSIGNED, " +
                    "trans_fat DECIMAL UNSIGNED, " +
                    "total_carb DECIMAL UNSIGNED, " +
                    "sugars DECIMAL UNSIGNED, " +
                    "dietery_fiber DECIMAL UNSIGNED, " +
                    "protein DECIMAL UNSIGNED, " +
                    "vitamin_a DECIMAL UNSIGNED, " +
                    "vitamin_c DECIMAL UNSIGNED, " +
                    "calcium DECIMAL UNSIGNED, " +
                    "iron DECIMAL UNSIGNED )" );

            // table food_entry
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS food_entry (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE, " +
                    "date DATE, " +
                    "amount_of_servings SMALLINT," +
                    "food_id INTEGER REFERENCES food(id))");

            // meal_title table to hold enum variants
            if (!tableExists("meal_title")) {
                statement.executeUpdate("CREATE TABLE IF NOT EXISTS meal_title (title VARCHAR(10) PRIMARY KEY NOT NULL UNIQUE)");
                statement.executeUpdate("INSERT INTO meal_title(title) VALUES ('breakfast')");
                statement.executeUpdate("INSERT INTO meal_title(title) VALUES ('lunch')");
                statement.executeUpdate("INSERT INTO meal_title(title) VALUES ('dinner')");
                statement.executeUpdate("INSERT INTO meal_title(title) VALUES ('dessert')");
                statement.executeUpdate("INSERT INTO meal_title(title) VALUES ('snack')");
            }

            // meal table
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS meal (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE, " +
                    "date DATE, " +
                    "title VARCHAR(10) REFERENCES meal_title(title), " +
                    "user_id INTEGER REFERENCES user(id), " +
                    "food_entry_id INTEGER REFERENCES food_entry(id))");

            // strength_training_level table to hold enum variants
            if (!tableExists("strength_training_level")) {
                statement.executeUpdate("CREATE TABLE IF NOT EXISTS strength_training_level (level VARCHAR(6) PRIMARY KEY NOT NULL UNIQUE)");
                statement.executeUpdate("INSERT INTO strength_training_level(level) VALUES ('heavy')");
                statement.executeUpdate("INSERT INTO strength_training_level(level) VALUES ('medium')");
                statement.executeUpdate("INSERT INTO strength_training_level(level) VALUES ('light')");
            }

            // strength_training table
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS strength_training (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE, " +
                    "date DATE NOT NULL, " +
                    "warm_up_hrs DECIMAL, " +
                    "cool_down_hrs DECIMAL, " +
                    "time_performing_hrs DECIMAL, " +
                    "strength_training_level VARCHAR(6) REFERENCES strength_training_level(level), " +
                    "user_id INTEGER REFERENCES user(id))" );

            // endurance_type table to hold enum variants
            if (!tableExists("endurance_type")) {
                statement.executeUpdate("CREATE TABLE IF NOT EXISTS endurance_type (type VARCHAR(8) PRIMARY KEY NOT NULL UNIQUE)");
                statement.executeUpdate("INSERT INTO endurance_type(type) VALUES ('running')");
                statement.executeUpdate("INSERT INTO endurance_type(type) VALUES ('swimming')");
                statement.executeUpdate("INSERT INTO endurance_type(type) VALUES ('cycling')");
            }

            // swimming_stroke table to hold enum variants
            if (!tableExists("swimming_stroke")) {
                statement.executeUpdate("CREATE TABLE IF NOT EXISTS swimming_stroke (stroke VARCHAR(10) PRIMARY KEY NOT NULL UNIQUE)");
                statement.executeUpdate("INSERT INTO swimming_stroke(stroke) VALUES ('breast')");
                statement.executeUpdate("INSERT INTO swimming_stroke(stroke) VALUES ('butterfly')");
                statement.executeUpdate("INSERT INTO swimming_stroke(stroke) VALUES ('back')");
                statement.executeUpdate("INSERT INTO swimming_stroke(stroke) VALUES ('freestyle')");
                statement.executeUpdate("INSERT INTO swimming_stroke(stroke) VALUES ('mixed')");
            }

            // cycling_type_type table to hold enum variants
            if (!tableExists("cycling_type")) {
                statement.executeUpdate("CREATE TABLE IF NOT EXISTS cycling_type (type VARCHAR(8) PRIMARY KEY NOT NULL UNIQUE)");
                statement.executeUpdate("INSERT INTO cycling_type(type) VALUES ('mountain')");
                statement.executeUpdate("INSERT INTO cycling_type(type) VALUES ('racing')");
                statement.executeUpdate("INSERT INTO cycling_type(type) VALUES ('leisure')");
            }

            // endurance_workout
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS endurance_workout (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE, " +
                    "date DATE NOT NULL, " +
                    "warm_up_hrs DECIMAL, " +
                    "cool_down_hrs DECIMAL, " +
                    "time_performing_hrs DECIMAL NOT NULL, " +
                    "endurance_type VARCHAR(8) REFERENCES endurance_type(type) NOT NULL, " +
                    "distance_km INTEGER NOT NULL," +
                    "swimming_training TINYINT(1), " +
                    "swimming_stroke VARCHAR(10) REFERENCES swimming_stroke(stroke), " +
                    "cycling_type VARCHAR(8) REFERENCES cycling_type(type)," +
                    "user_id INTEGER REFERENCES user(id))");
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
        statement.executeUpdate("DROP TABLE IF EXISTS user");
        statement.executeUpdate("DROP TABLE IF EXISTS gender");
        statement.executeUpdate("DROP TABLE IF EXISTS activity_level");
        statement.executeUpdate("DROP TABLE IF EXISTS goal");

        statement.executeUpdate("DROP TABLE IF EXISTS meal");
        statement.executeUpdate("DROP TABLE IF EXISTS meal_title");

        statement.executeUpdate("DROP TABLE IF EXISTS food_entry");
        statement.executeUpdate("DROP TABLE IF EXISTS food");

        statement.executeUpdate("DROP TABLE IF EXISTS endurance_workout");
        statement.executeUpdate("DROP TABLE IF EXISTS cycling_type");
        statement.executeUpdate("DROP TABLE IF EXISTS endurance_type");
        statement.executeUpdate("DROP TABLE IF EXISTS swimming_stroke");

        statement.executeUpdate("DROP TABLE IF EXISTS strength_training");
        statement.executeUpdate("DROP TABLE IF EXISTS strength_training_level");

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
