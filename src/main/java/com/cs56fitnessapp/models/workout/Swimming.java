package com.cs56fitnessapp.models.workout;

import com.cs56fitnessapp.models.FitnessFormulas;
import com.cs56fitnessapp.models.User;

import java.time.LocalDate;

/**
 * @author Ksenia Koldaeva
 * Created: 10/10/17
 * Last Updated: 10/11/17
 */
public class Swimming extends Endurance {

    private SwimmingStroke swimmingStroke;
    private boolean training;

    /**
     * Constructs Swimming object with provided parameters
     * @param user user performing swimming
     * @param date date of swimming workout
     * @param distanceKm distance of swimming workout
     * @param timePerformingHours duration of swimming workout
     * @param swimmingStroke one of 4 swimming strokes or mixed
     * @param training each of the strokes including MIXED can be recreational or training
     */
    public Swimming(User user, LocalDate date, double distanceKm, double timePerformingHours, SwimmingStroke swimmingStroke, boolean training) {
        super(user, date, distanceKm, timePerformingHours);
        this.swimmingStroke = swimmingStroke;
        this.training = training;
    }

    // Start getters and setters

    public SwimmingStroke getSwimmingStroke() {
        return swimmingStroke;
    }

    public void setSwimmingStroke(SwimmingStroke swimmingStroke) {
        this.swimmingStroke = swimmingStroke;
    }

    public boolean isTraining() {
        return training;
    }

    public void setTraining(boolean training) {
        this.training = training;
    }

    // End getters and setters

    @Override
    public int getCaloriesOut() {
        int caloriesOut;

        switch (swimmingStroke) {
            case FREESTYLE:
                if (training) {
                    caloriesOut = FitnessFormulas.caloriesOutByMET(FitnessFormulas.MET_SWIMMING_CRAWL_TRAINING, this.getUser().getbodyMassKg(), this.getTimePerformingHours());
                } else {
                    caloriesOut = FitnessFormulas.caloriesOutByMET(FitnessFormulas.MET_SWIMMING_CRAWL_TRAINING, this.getUser().getbodyMassKg(), this.getTimePerformingHours());
                }
                break;
        }
        return 0;
    }

    @Override
    public int getActiveTimeMins() {
        return (int)Math.round(FitnessFormulas.MINS_IN_AN_HOUR * this.getTimePerformingHours());
    }
}
