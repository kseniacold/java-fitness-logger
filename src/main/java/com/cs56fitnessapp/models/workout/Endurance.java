package com.cs56fitnessapp.models.workout;

import com.cs56fitnessapp.models.FitnessFormulas;
import com.cs56fitnessapp.models.User;
import java.time.LocalDate;

/**
 * @author Ksenia Koldaeva
 * Created: 10/10/17
 * Last Updated: 10/18/17
 */

public abstract class Endurance extends Workout {

    private double distanceKm;

    /**
     *
     * Constructs Endurance object with provided parameters
     * @param user user performing endurance workout
     * @param date date of the workout
     * @param distanceKm distance of the endurance workout
     * @param timePerformingHours time of the endurance workout
     */
    public Endurance(User user, LocalDate date, double distanceKm, double timePerformingHours) {
        super(user, date);
        this.distanceKm = distanceKm;
        super.setTimePerformingHours(timePerformingHours);
    }

    // Start getters and setters

    public double getDistanceKm() {
        return distanceKm;
    }

    public void setDistanceKm(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    // End getters and setters

    /**
     * getActiveTimeMins() overrides ActivityFacts Interface method
     * Will be the same for Swimming, Running, Cycling
     * @return active endurance workout time
     */
    @Override
    public int getActiveTimeMins() {
        return (int)Math.round(FitnessFormulas.MINS_IN_AN_HOUR * this.getTimePerformingHours());
    }
}
