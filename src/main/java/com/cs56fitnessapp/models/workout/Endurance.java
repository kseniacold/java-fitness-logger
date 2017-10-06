package com.cs56fitnessapp.models.workout;

import com.cs56fitnessapp.models.workout.Workout;

/**
 * @author Ksenia Koldaeva
 * Created: 10/6/17
 * Last Updated: 10/6/17
 */

public abstract class Endurance extends Workout {

    // distance of an endurance workout
    private double distance;

    // duration of an endurance workout
    private double duration;

    /**
     * Constructs an Endurance object with distance and duration
     * @param distance distance for an endurance workout
     * @param duration duration for an endurance workout
     */
    public Endurance(double distance, double duration) {
        this.distance = distance;
        this.duration = duration;
    }

    // Setters and getters start
    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }
    // Setters and getters end
}
