package com.cs56fitnessapp.models.workout;

import com.cs56fitnessapp.models.User;

import java.time.LocalDate;

/**
 * @author Ksenia Koldaeva
 * Created: 10/11/17
 * Last Updated:
 */
public class Cycling extends Endurance {

    private CyclingType cyclingType;

    /**
     * Constructs new Cycling object with provided parameters
     * @param user user performing cycling
     * @param date date of the cycling workout
     * @param distanceKm distance of the cycling workout
     * @param timePerformingHours duration of the cycling workout
     * @param cyclingType cycling workout type
     */
    public Cycling(User user, LocalDate date, double distanceKm, double timePerformingHours, CyclingType cyclingType) {
        super(user, date, distanceKm, timePerformingHours);
        this.cyclingType = cyclingType;
    }

    /**
     *
     * @return calories out based on the cycling workout
     */
    @Override
    public int getCaloriesOut() {
        int caloriesOut = 0;

        switch (cyclingType) {
            case MOUNTAIN:
                caloriesOut = FitnessFormulas.caloriesOutByMET(FitnessFormulas.MET_CYCLING_MOUNTAIN, this.getUser().getbodyMassKg(), this.getTimePerformingHours());
                break;
            case RACING:
                caloriesOut = FitnessFormulas.caloriesOutByMET(FitnessFormulas.MET_CYCLING_RACING, this.getUser().getbodyMassKg(), this.getTimePerformingHours());
                break;
            case LEISURE:
                caloriesOut = FitnessFormulas.caloriesOutByMET(FitnessFormulas.MET_CYCLING_LEISURE, this.getUser().getbodyMassKg(), this.getTimePerformingHours());
        }

        return caloriesOut;
    }
}
