package com.cs56fitnessapp.models.workout;

import com.cs56fitnessapp.models.User;

import java.time.LocalDate;

/**
 * @author Ksenia Koldaeva
 * Created: 10/11/17
 * Last Updated: 10/11/17
 */
public class Running extends Endurance {

    /**
     * Constructs Running object with provided parameters
     * @param user user performing running
     * @param date date of running
     * @param distanceKm distance of the running workout
     * @param timePerformingHours time of the running workout in hours
     */
    public Running(User user, LocalDate date, double distanceKm, double timePerformingHours) {
        super(user, date, distanceKm, timePerformingHours);
    }

    /**
     * Will be using caloriesOutRunnigLegerFormula() to calculate calories out
     * @return calories out from the running workout
     */
    @Override
    public int getCaloriesOut() {
        return FitnessFormulas.caloriesOutRunnigLegerFormula(this.getUser().getbodyMassKg(), this.getDistanceKm(), this.getTimePerformingHours());
    }

}
