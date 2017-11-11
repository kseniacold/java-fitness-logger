package com.cs56fitnessapp.models.workout;

/**
 * @author Daniel Cervantes
 * @author Ksenia Koldaeva
 * Date created: 9/24/17
 * Last updated: 11/31/17
 */

import com.cs56fitnessapp.models.ActivityFacts;
import com.cs56fitnessapp.models.User;

import java.time.LocalDate;

public abstract class Workout implements ActivityFacts {

    private User user;
    private LocalDate date;
    private double warmUpTimeHrs = 0;
    private double coolDownTimeHrs = 0;
    private double timePerformingHours = 0;

    /**
     * Constructs Workout object with provided parameters
     * @param user user performing workout
     * @param date date of the workout
     */

    public Workout(User user, LocalDate date) {
        this.date = date;
    }

    // Default constructor
    public Workout(){}

    // Start getters and setters

    public User getUser() {
        return user;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getWarmUpTimeHrs() {
        return warmUpTimeHrs;
    }

    public void setWarmUpTimeHrs(int warmUpTimeHrs) {
        this.warmUpTimeHrs = warmUpTimeHrs;
    }

    public double getCoolDownTimeHrs() {
        return coolDownTimeHrs;
    }

    public void setCoolDownTimeHrs(int coolDownTimeHrs) {
        this.coolDownTimeHrs = coolDownTimeHrs;
    }

    public double getTimePerformingHours() {
        return timePerformingHours;
    }

    public void setTimePerformingHours(double timePerformingHours) {
        this.timePerformingHours = timePerformingHours;
    }


    // End getters and setters
}
