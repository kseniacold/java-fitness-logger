package com.cs56fitnessapp.models.workout;

import com.cs56fitnessapp.models.ActivityFacts;
import com.cs56fitnessapp.models.workout.Endurance;

/**
 * @author Ksenia Koldaeva
 * Created: 10/6/17
 * Last Updated: 10/6/17
 */

public class Running extends Endurance implements ActivityFacts {

    /**
     * Constructs new Running object with provided distance and duration
     * @param distance
     * @param duration
     */
    public Running(double distance, double duration) {
        super(distance, duration);
    }

    @Override
    public int getCaloriesOut() {
        return 0;
    }

    @Override
    public int getActiveTime() {
        return 0;
    }
}
