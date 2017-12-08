package com.cs56fitnessapp.services;

import com.cs56fitnessapp.FitnessApplication;
import com.cs56fitnessapp.models.Day;
import com.cs56fitnessapp.models.User;
import com.cs56fitnessapp.models.workout.Workout;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * @author Ksenia Koldaeva
 * Created: 12/6/17
 * Last Updated: 12/6/17
 */
public class DayService {
    private static Day day = null;

    public static Day getDay(LocalDate date) throws SQLException, ClassNotFoundException {
        User user = FitnessApplication.getUser();

        ArrayList<Workout> workoutList = new ArrayList<>();
        // fetch endurance workouts from the db
        workoutList.addAll(WorkoutService.getEnduranceListByDate(date));

        //fetch strength workout from the db
        workoutList.addAll(WorkoutService.getStrengthListByDate(date));
        day = new Day(date, user);
        day.setWorkoutList(workoutList);
        return day;
    }
}
