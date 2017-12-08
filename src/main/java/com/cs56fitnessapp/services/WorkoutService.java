package com.cs56fitnessapp.services;


import com.cs56fitnessapp.FitnessApplication;
import com.cs56fitnessapp.models.User;
import com.cs56fitnessapp.models.workout.*;
import com.cs56fitnessapp.utils.DateFormatter;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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
        LocalDateTime dateTime = endurance.getDate();
        String formattedDateTime = DateFormatter.dateTimeToString(dateTime);

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

    public static void addStrengthToDb(StrengthTraining strengthTraining) throws SQLException, ClassNotFoundException {
        User user = FitnessApplication.getUser();

        // open sqlite connection
        SqLiteConnection sqLite = new SqLiteConnection();
        Connection connection = sqLite.getConnectionObj();
        Statement statement = connection.createStatement();

        LocalDateTime dateTime = strengthTraining.getDate();
        String formattedDateTime = DateFormatter.dateTimeToString(dateTime);

        String sqlQuery = "INSERT INTO strength_training(date, time_performing_hrs, strength_training_level, user_id) VALUES(" +
                "'" + formattedDateTime + "'," +
                "'" + strengthTraining.getTimePerformingHours() + "'," +
                "'" + strengthTraining.getStrengthTrainingLevel().getDbValue() + "'," +
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
                endurance = new Running(id, user, date, distanceKm, timePerformingHrs);
            }

            if (enduranceType == EnduranceType.SWIMMING) {
                endurance = new Swimming(id, user, date, distanceKm, timePerformingHrs, stroke);
                ((Swimming)endurance).setTraining(swimmingTraining);
            }

            if (enduranceType == EnduranceType.CYCLING) {
                endurance = new Cycling(id, user, date, distanceKm, timePerformingHrs, cyclingType);
            }
        }

        return endurance;
    }

    public static List<Endurance> getEnduranceListByDate(LocalDate date) throws SQLException, ClassNotFoundException {
        List<Endurance> enduranceList = new ArrayList<>();
        User user = FitnessApplication.getUser();

        /************************************************************************/
        // open sqlite connection
        SqLiteConnection sqLite = new SqLiteConnection();
        Connection connection = sqLite.getConnectionObj();
        Statement statement = connection.createStatement();

        String formattedDate = DateFormatter.dateToString(date);
        // TODO remove below
        System.out.println(formattedDate);

        String sqlQuery = "SELECT * FROM endurance_workout WHERE date LIKE '%" + formattedDate + "%'";
        ResultSet rs = statement.executeQuery(sqlQuery);

        while(rs.next()) {
            Endurance endurance = null;
            // read the result set
            EnduranceType enduranceType = EnduranceType.fromDbValue(rs.getString("endurance_type"));
            LocalDateTime dateTime = DateFormatter.stingToDateTime(rs.getString("date"));
            Long id = rs.getLong("id");
            double distanceKm = rs.getDouble("distance_km");
            double timePerformingHrs = rs.getDouble("time_performing_hrs");

            switch (enduranceType) {
                case RUNNING:
                    endurance = new Running(id, user, dateTime, distanceKm,  timePerformingHrs);
                    break;
                case CYCLING:
                    CyclingType cyclingType = rs.getString("cycling_type") != null ? CyclingType.fromDbValue(rs.getString("cycling_type")) : null;
                    endurance = new Cycling(id, user, dateTime, distanceKm, timePerformingHrs, cyclingType);
                    break;
                case SWIMMING:
                    boolean swimmingTraining = rs.getBoolean("swimming_training");
                    SwimmingStroke swimmingStroke = rs.getString("swimming_stroke") != null ? SwimmingStroke.fromDbValue(rs.getString("swimming_stroke")) : null;
                    endurance = new Swimming(id, user, dateTime, distanceKm, timePerformingHrs, swimmingStroke);
                    ((Swimming)endurance).setTraining(swimmingTraining);
                    break;
            }

            enduranceList.add(endurance);
        }

        connection.close();
        return enduranceList;
    }

    public static List<StrengthTraining> getStrengthListByDate(LocalDate date) throws SQLException, ClassNotFoundException {
        List<StrengthTraining> strengthTrainings = new ArrayList<>();
        User user = FitnessApplication.getUser();

        /************************************************************************/
        // open sqlite connection
        SqLiteConnection sqLite = new SqLiteConnection();
        Connection connection = sqLite.getConnectionObj();
        Statement statement = connection.createStatement();

        String formattedDate = DateFormatter.dateToString(date);

        String sqlQuery = "SELECT * FROM strength_training WHERE date LIKE '%" + formattedDate + "%'";
        ResultSet rs = statement.executeQuery(sqlQuery);

        while(rs.next()) {
            StrengthTraining strengthTraining = null;
            // read the result set
            Long id = rs.getLong("id");
            LocalDateTime dateTime = DateFormatter.stingToDateTime(rs.getString("date"));
            StrengthTrainingLevel strengthLevel = StrengthTrainingLevel.fromDbValue(rs.getString("strength_training_level"));
            double timePerformingHrs = rs.getDouble("time_performing_hrs");

            strengthTraining = new StrengthTraining(id, user, dateTime, timePerformingHrs, strengthLevel);
            strengthTrainings.add(strengthTraining);
        }

        connection.close();
        return strengthTrainings;
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
}
