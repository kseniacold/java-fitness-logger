package com.cs56fitnessapp.models.workout;

import com.cs56fitnessapp.models.User;
import java.time.LocalDate;

/**
 * @author Ksenia Koldaeva
 * Created: 10/10/17
 * Last Updated: 10/10/17
 */

public abstract class Endurance extends Workout {

    private double distance;
    private double timePerformingHours;

    public Endurance(User user, LocalDate date, double distance, double timePerformingHours) {
        super(user, date);
        this.distance = distance;
        this.timePerformingHours = timePerformingHours;
    }

    // Start getters and setters

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getTimePerformingHours() {
        return timePerformingHours;
    }

    public void setTimePerformingHours(double timePerformingHours) {
        this.timePerformingHours = timePerformingHours;
    }

    // End getters and setters

}
