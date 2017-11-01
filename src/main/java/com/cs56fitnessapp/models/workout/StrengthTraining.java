package com.cs56fitnessapp.models.workout;

import com.cs56fitnessapp.models.User;
import java.time.LocalDate;

/**
 *  @author Daniel Cervantes
 *  @author Ksenia Koldaeva
 *
 * Date created: 10/18/17
 * Last updated: 10/31/17
 */

public abstract class StrengthTraining extends Workout {

    /**
     * Constructs Strength Training object with provided parameters
     * @param user user performing Strength Training
     * @param date date of Strength Training
     * @param warmUpTimeHrs time of warm up
     * @param coolDownTimeHrs time of cool down
     * @param timePerformingHours amount of time of Strength Training in hours
     * @param met_Value workout intensity
     */

    public StrengthTraining(User user, LocalDate date, int warmUpTimeHrs, int coolDownTimeHrs, double timePerformingHours, double met_Value) {
        super(user, date);
        this.setWarmUpTimeHrs(warmUpTimeHrs);
        this.setCoolDownTimeHrs(coolDownTimeHrs);
        this.setTimePerformingHours(timePerformingHours);
        this.setMET_value(met_Value);
    }

    /**
     * Will be using caloriesOutByMET() to calculate calories out
     * based on the MET level the user gives
     * @return calories out from Strength Training
     */

    public int getCaloriesOutByMet() {
        return FitnessFormulas.caloriesOutByMET(this.getMET_value(), this.getUser().getbodyMassKg(), this.getTimePerformingHours());
    }


}
