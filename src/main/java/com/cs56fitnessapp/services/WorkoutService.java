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
     * Adds endurance workout to db
     * @param endurance
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static void addEnduranceToDb(Endurance endurance) throws SQLException, ClassNotFoundException {
        // TODO add warm up time and cool down time functionality
        User user = FitnessApplication.getUser();

        // prepared values to insert to db
        boolean isTraining = endurance instanceof Swimming && ((Swimming)endurance).isTraining();
        int swimmingTraining = (isTraining) ? 1 : 0;
        SwimmingStroke stroke = endurance instanceof Swimming ? ((Swimming)endurance).getSwimmingStroke() : null;
        EnduranceType enduranceType = getEnduranceType(endurance);
        CyclingType cyclingType = endurance instanceof Cycling ? ((Cycling)endurance).getCyclingType() : null;

        /************************************************************************/

        // open sqlite connection
        SqLiteConnection sqLite = new SqLiteConnection();
        Connection connection = sqLite.getConnectionObj();
        Statement statement = connection.createStatement();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = endurance.getDate();
        String formattedDateTime = dateTime.format(formatter);

        String sqlQuery = "INSERT INTO endurance_workout(date, time_performing_hrs, endurance_type, distance_km, swimming_training, swimming_stroke, cycling_type, user_id) VALUES(" +
                "'" + formattedDateTime + "'," +
                "'" + endurance.getTimePerformingHours() + "'," +
                "'" + enduranceType.getDbValue() + "'," +
                "'" + endurance.getDistanceKm() + "'," +
                "'" + swimmingTraining + "'," +
                "'" + (stroke != null ? stroke.getDbValue() : null) + "'," +
                "'" + (cyclingType != null ? cyclingType.getDbValue() : null) + "'," +
                "'" + user.getId() + "')";

        statement.executeUpdate(sqlQuery);
        connection.close();
    }

    public static Endurance getEnduranceById(long id) throws SQLException, ClassNotFoundException {
        ResultSet rs;
        User user = FitnessApplication.getUser();
        Endurance endurance = null;

        EnduranceType enduranceType = null;
        double distanceKm = 0.0;
        boolean swimmingTraining = false;
        SwimmingStroke stroke = null;
        CyclingType cyclingType = null;

        LocalDateTime date = null;
        double timePerformingHrs = 0.0;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        /************************************************************************/

        SqLiteConnection sqLite = new SqLiteConnection();
        Connection connection = sqLite.getConnectionObj();
        Statement statement = connection.createStatement();

        // Fetch data from endurance_workout table
        String sqlQueryEnd = "SELECT * FROM endurance_workout WHERE id = '" + id + "'";
        rs = statement.executeQuery(sqlQueryEnd);

        while(rs.next()) {
            // read the result set
            date = LocalDateTime.parse(rs.getString("date"), formatter);
            timePerformingHrs = rs.getDouble("time_performing_hrs");
            enduranceType = rs.getString("endurance_type") == null ? null : EnduranceType.fromDbValue(rs.getString("endurance_type"));
            distanceKm = rs.getDouble("distance_km");
            swimmingTraining = rs.getBoolean("swimming_training");
            stroke = rs.getString("swimming_stroke") == null ? null : SwimmingStroke.fromDbValue(rs.getString("swimming_type"));
            cyclingType = rs.getString("swimming_stroke") == null ? null : CyclingType.fromDbValue(rs.getString("cycling_type"));

        }

        connection.close();

        /************************************************************************/

        // Create endurance instance from data fetched
        if (enduranceType != null) {
            if (enduranceType == EnduranceType.RUNNING) {
                endurance = new Running(user, date, distanceKm, timePerformingHrs);
            }

            if (enduranceType == EnduranceType.SWIMMING) {
                endurance = new Swimming(user, date, distanceKm, timePerformingHrs, stroke);
                ((Swimming)endurance).setTraining(swimmingTraining);
            }

            if (enduranceType == EnduranceType.CYCLING) {
                endurance = new Cycling(user, date, distanceKm, timePerformingHrs, cyclingType);
            }
        }

        return endurance;
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
        // prepared values to insert to db
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
