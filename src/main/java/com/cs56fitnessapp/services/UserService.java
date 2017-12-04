package com.cs56fitnessapp.services;

import com.cs56fitnessapp.models.ActivityLevel;
import com.cs56fitnessapp.models.Gender;
import com.cs56fitnessapp.models.Goal;
import com.cs56fitnessapp.models.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Locale;

/**
 * @author Ksenia Koldaeva
 * Created: 12/2/17
 * Last Updated: 12/2/17
 */

/**
 * This class provides services for adding information to the database
 * and fetching information back
 * that is related to the User
 */
public class UserService {

    /**
     * Adds user to db
     * @param user
     */
    public static void addUserToDb(User user) {
        // TODO refactor try - catch to be handled by the caller
        try {
            SqLiteConnection sqLite = new SqLiteConnection();
            Connection connection = sqLite.getConnectionObj();

            Statement statement = connection.createStatement();
            String sqlQuery = "INSERT INTO user(name, username, email, password, date_of_birth, gender, body_mass_kg, height_cm, goal, weekly_goal_kg, activity_level) VALUES(" +
                    "'" + user.getName() + "'," +
                    "'" + user.getUsername() + "'," +
                    "'" + user.getEmail() + "'," +
                    "'" + user.getPassword() + "'," +
                    "'" + user.getDateOfBirth() + "'," +
                    "'" + user.getGender().getDbValue() + "'," +
                          user.getBodyMassKg() + "," +
                          user.getHeightCm() + "," +
                    "'" + user.getGoal().getDbValue() + "'," +
                          user.getWeeklyGoalKg() + "," +
                    "'" + user.getActivityLevel().getDbValue() + "')";

            statement.executeUpdate(sqlQuery);

            ResultSet rs = statement.executeQuery("SELECT * FROM user");
            while(rs.next()) {
                // read the result set
                System.out.println("name = " + rs.getString("name"));
                System.out.println("id = " + rs.getInt("id"));
                System.out.println("email = " + rs.getString("email"));
            }

            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static User getUserFromDb() throws SQLException, ClassNotFoundException {
        User user = null;
        String name;
        String username;
        String email;
        String password;
        LocalDate dateOfBirth;
        Gender gender;
        double bodyMassKg;
        double heightCm;
        Goal gaol;
        double weeklyGoal;
        ActivityLevel activityLevel;

        return user;
    }

    /**
     * @return true if database has at least one user registered
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static boolean dbHasUser() throws SQLException, ClassNotFoundException {
        SqLiteConnection sqLite = new SqLiteConnection();
        Connection connection = sqLite.getConnectionObj();

        Statement statement = connection.createStatement();

        // Check if table has data in it
        String sqlQuery = "SELECT count(*) as user_count FROM user";
        ResultSet rs = statement.executeQuery(sqlQuery);


        while(rs.next()) {
            // read the result set
            // If it has user - pick the first user and use it in the application
            if (rs.getInt("user_count") > 0) {
                return true;
            }
        }

        return false;
    }
}

