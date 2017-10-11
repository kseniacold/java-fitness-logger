package com.cs56fitnessapp.models.workout;

import com.cs56fitnessapp.models.User;

import java.time.LocalDate;

/**
 * @author Ksenia Koldaeva
 * Created: 10/11/17
 * Last Updated:
 */
public class Running extends Endurance {
    public Running(User user, LocalDate date, double distanceKm, double timePerformingHours) {
        super(user, date, distanceKm, timePerformingHours);
    }

    @Override
    public int getCaloriesOut() {
        return 0;
    }

    @Override
    public int getActiveTimeMins() {
        return 0;
    }
}
