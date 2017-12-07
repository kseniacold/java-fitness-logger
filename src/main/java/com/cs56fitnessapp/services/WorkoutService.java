package com.cs56fitnessapp.services;


import com.cs56fitnessapp.FitnessApplication;
import com.cs56fitnessapp.models.User;
import com.cs56fitnessapp.models.workout.*;
import java.sql.*;
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
     * @param endurance
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static void addEnduranceToDb(Endurance endurance) throws SQLException, ClassNotFoundException {
        // TODO add warm up time and cool down time functionality
        User user = FitnessApplication.getUser();
        long workoutId;

        // open sqlite connection
        SqLiteConnection sqLite = new SqLiteConnection();
        Connection connection = sqLite.getConnectionObj();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = endurance.getDate();
        String formattedDateTime = dateTime.format(formatter);

        String sqlQueryWrk = "INSERT INTO workout(date, time_performing_hrs, user_id) VALUES(" +
                "'" + formattedDateTime + "'," +
                "'" + endurance.getTimePerformingHours() + "'," +
                "'" + user.getId() + "')";

        // Add general workout to workout table
        PreparedStatement workoutSt = connection.prepareStatement(sqlQueryWrk,
                Statement.RETURN_GENERATED_KEYS);

        try (ResultSet generatedKeysWrk = workoutSt.getGeneratedKeys()) {
            if (generatedKeysWrk.next()) {
                workoutId = generatedKeysWrk.getLong(1);
            }
            else {
                throw new SQLException("Creating user failed, no ID obtained.");
            }
        }

        // Add Endurance workout to endurance_workout table
        addEndurance(endurance, connection, workoutId);
        connection.close();
    }

    public static Workout getEnduranceById(long id) throws SQLException, ClassNotFoundException {
        ResultSet rs;

        User user = FitnessApplication.getUser();
        long workId;
        Workout workout = null;
        EnduranceType enduranceType;
        double distanceKm = 0.0;
        boolean swimmingTraining = false;
        SwimmingStroke stroke;
        CyclingType type;

        LocalDateTime date = null;
        double timePerformingHrs = 0.0;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        SqLiteConnection sqLite = new SqLiteConnection();
        Connection connection = sqLite.getConnectionObj();
        Statement statement = connection.createStatement();

        // Fetch data from Endurance endurance_workout table first
        String sqlQueryEnd = "SELECT * FROM endurance_workout WHERE id = '" + id + "'";
        rs = statement.executeQuery(sqlQueryEnd);

        while(rs.next()) {
            // read the result set
            timePerformingHrs = rs.getDouble("time_performing_hrs");
            date = LocalDateTime.parse(rs.getString("date"), formatter);
        }

        String sqlQueryWorkout = "SELECT * FROM workout WHERE id = '" + id + "'";
        rs = statement.executeQuery(sqlQueryWorkout);

        while(rs.next()) {
            // read the result set
            timePerformingHrs = rs.getDouble("time_performing_hrs");
            date = LocalDateTime.parse(rs.getString("date"), formatter);
        }

        connection.close();
        return workout;
    }

    /**
     * Helper method to get endurance type of endurance instance
     * @param endurance
     * @return
     */
    private static EnduranceType getEnduranceType(Endurance endurance) {
        if (endurance instanceof Running) {
            return EnduranceType.RUNNING;
        }

        if (endurance instanceof Cycling) {
            return EnduranceType.CYCLING;
        }

        if (endurance instanceof Swimming) {
            return EnduranceType.SWIMMING;
        }

        // will return running as default type
        return EnduranceType.RUNNING;
    }

    private static void addEndurance (Endurance endurance, Connection connection, long workoutId) {
        // prepared value to insert to db
        boolean isTraining = endurance instanceof Swimming && ((Swimming)endurance).isTraining();
        int swimmingTraining = (isTraining) ? 1 : 0;
        SwimmingStroke stroke = endurance instanceof Swimming ? ((Swimming)endurance).getSwimmingStroke() : null;
        EnduranceType enduranceType = getEnduranceType(endurance);
        CyclingType cyclingType = endurance instanceof Cycling ? ((Cycling)endurance).getCyclingType() : null;

        // Add Endurance workout to endurance_workout table
        String sqlQueryEnd = "INSERT INTO endurance_workout(endurance_type, distance_km, swimming_training, swimming_stroke, cycling_type, workout_id) VALUES(" +
                "'" + enduranceType.getDbValue() + "'," +
                "'" + endurance.getDistanceKm() + "'," +
                "'" + (stroke != null ? stroke.getDbValue() : null) + "'," +
                "'" + (cyclingType != null ? cyclingType.getDbValue() : null) + "'," +
                "'" + workoutId + "')";
    }
}
