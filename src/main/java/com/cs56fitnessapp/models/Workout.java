package com.cs56fitnessapp.models;

/**
 * @author Daniel Cervantes
 * Date created: 9/24/17
 * Last updated: 9/24/17
 */

public abstract class Workout implements ActivityFacts {
    @Override
    public int getCaloriesOut() {
        return 0;
    }

    @Override
    public int getActiveTime() {
        return 0;
    }
}
