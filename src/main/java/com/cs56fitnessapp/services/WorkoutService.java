package com.cs56fitnessapp.services;


import com.cs56fitnessapp.FitnessApplication;
import com.cs56fitnessapp.models.User;
import com.cs56fitnessapp.models.workout.Workout;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Ksenia Koldaeva
 * Created: 12/6/17
 * Last Updated: 12/6/17
 */

public class WorkoutService {

    /**
     * Adds workout to db
     * @param workout
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static void addWorkoutToDb(Workout workout) throws SQLException, ClassNotFoundException {
        // TODO add warm up time and cool down time functionality
        User user = FitnessApplication.getUser();
        SqLiteConnection sqLite = new SqLiteConnection();
        Connection connection = sqLite.getConnectionObj();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = workout.getDate();
        String formattedDateTime = dateTime.format(formatter);

        // Add general workout to workout table
        Statement workSt = connection.createStatement();
        String sqlQuery = "INSERT INTO workout(date, time_performing_hrs, user_id) VALUES(" +
                "'" + formattedDateTime + "'," +
                "'" + workout.getTimePerformingHours() + "'," +
                "'" + user.getId() + "')";

        workSt.executeUpdate(sqlQuery);

        // Add endurance information to workout table
        Workout workoutFromDb = getWorkoutFromDb();
        // Add Endurance workout to endurance_workout table
        connection.close();
    }

    public static Workout getWorkoutFromDb() throws SQLException, ClassNotFoundException {
        User user = FitnessApplication.getUser();
        Workout workout = null;
        long id;
        LocalDateTime date = null;
        double timePerformingHrs = 0.0;

        SqLiteConnection sqLite = new SqLiteConnection();
        Connection connection = sqLite.getConnectionObj();
        Statement statement = connection.createStatement();

        // TODO selecting only user id #1
        String sqlQuery = "SELECT * FROM workout WHERE id = '1'";
        ResultSet rs = statement.executeQuery(sqlQuery);

        return workout;
    }
}
