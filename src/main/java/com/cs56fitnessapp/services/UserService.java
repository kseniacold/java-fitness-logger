package com.cs56fitnessapp.services;

import com.cs56fitnessapp.models.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

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
    private User user;

    public UserService(User user) {
        this.user = user;
    }

    /**
     * Adds user to db
     */
    public void addUserToDb() {
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
}

