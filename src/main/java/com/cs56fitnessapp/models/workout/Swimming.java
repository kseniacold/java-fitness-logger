package com.cs56fitnessapp.models.workout;

import com.cs56fitnessapp.models.FitnessFormulas;
import com.cs56fitnessapp.models.User;
import java.time.LocalDateTime;

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
     * Training is assumed to be false (can be set later) for all except Butterfly - in this case training is true
     * @param user user performing swimming
     * @param date date of swimming workout
     * @param distanceKm distance of swimming workout
     * @param timePerformingHours duration of swimming workout
     * @param swimmingStroke one of 4 swimming strokes or mixed
     */
    public Swimming(User user, LocalDateTime date, double distanceKm, double timePerformingHours, SwimmingStroke swimmingStroke) {
        super(user, date, distanceKm, timePerformingHours);
        this.swimmingStroke = swimmingStroke;

        this.training = swimmingStroke.equals(SwimmingStroke.BUTTERFLY);
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

    /**
     *
     * @return calories out based on the stroke type and if training or recreational
     */
    @Override
    public int getCaloriesOut() {
        int caloriesOut = 0;

        switch (swimmingStroke) {
            case FREESTYLE:
                if (training) {
                    caloriesOut = FitnessFormulas.caloriesOutByMET(FitnessFormulas.MET_SWIMMING_CRAWL_TRAINING, this.getUser().getBodyMassKg(), this.getTimePerformingHours());
                } else {
                    caloriesOut = FitnessFormulas.caloriesOutByMET(FitnessFormulas.MET_SWIMMING_CRAWL_RECREATIONAL, this.getUser().getBodyMassKg(), this.getTimePerformingHours());
                }
                break;
            case BREASTSTROKE:
                if (training) {
                    caloriesOut = FitnessFormulas.caloriesOutByMET(FitnessFormulas.MET_SWIMMING_BREASTSTROKE_TRAINING, this.getUser().getBodyMassKg(), this.getTimePerformingHours());
                } else {
                    caloriesOut = FitnessFormulas.caloriesOutByMET(FitnessFormulas.MET_SWIMMING_BREASTSTROKE_RECREATIONAL, this.getUser().getBodyMassKg(), this.getTimePerformingHours());
                }
                break;
            case BACKSTROKE:
                if (training) {
                    caloriesOut = FitnessFormulas.caloriesOutByMET(FitnessFormulas.MET_SWIMMING_CRAWL_TRAINING, this.getUser().getBodyMassKg(), this.getTimePerformingHours());
                } else {
                    caloriesOut = FitnessFormulas.caloriesOutByMET(FitnessFormulas.MET_SWIMMING_CRAWL_TRAINING, this.getUser().getBodyMassKg(), this.getTimePerformingHours());
                }
                break;
            case BUTTERFLY:
                caloriesOut = FitnessFormulas.caloriesOutByMET(FitnessFormulas.MET_SWIMMING_BUTTERFLY_GENERAL, this.getUser().getBodyMassKg(), this.getTimePerformingHours());
                break;
            case MIXED:
                if (training) {
                    caloriesOut = FitnessFormulas.caloriesOutByMET(FitnessFormulas.MET_SWIMMING_MIXED_TRAINING, this.getUser().getBodyMassKg(), this.getTimePerformingHours());
                } else {
                    caloriesOut = FitnessFormulas.caloriesOutByMET(FitnessFormulas.MET_SWIMMING_MIXED_RECREATIONAL, this.getUser().getBodyMassKg(), this.getTimePerformingHours());
                }
                break;
        }
        return caloriesOut;
    }
}
