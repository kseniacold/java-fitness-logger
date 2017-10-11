package com.cs56fitnessapp.models.workout;

import com.cs56fitnessapp.models.User;
import java.time.LocalDate;

/**
 * @author Ksenia Koldaeva
 * Created: 10/10/17
 * Last Updated: 10/10/17
 */

public abstract class Endurance extends Workout {

    private double distanceKm;
    private double timePerformingHours;

    public Endurance(User user, LocalDate date, double distanceKm, double timePerformingHours) {
        super(user, date);
        this.distanceKm = distanceKm;
        this.timePerformingHours = timePerformingHours;
    }

    // Start getters and setters

    public double getDistanceKm() {
        return distanceKm;
    }

    public void setDistanceKm(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    public double getTimePerformingHours() {
        return timePerformingHours;
    }

    public void setTimePerformingHours(double timePerformingHours) {
        this.timePerformingHours = timePerformingHours;
    }

    // End getters and setters

}
