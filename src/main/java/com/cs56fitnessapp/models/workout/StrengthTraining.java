package com.cs56fitnessapp.models.workout;

import com.cs56fitnessapp.models.FitnessFormulas;
import com.cs56fitnessapp.models.User;
import java.time.LocalDateTime;

/**
 * @author Daniel Cervantes
 * @author Ksenia Koldaeva
 * Date created: 10/18/17
 * Last updated: 11/11/17
 */

public class StrengthTraining extends Workout {

    private StrengthTrainingLevel strengthTrainingLevel;

    /**
     * Constructs Strength Training object with provided parameters
     * @param user user performing Strength Training
     * @param date date of Strength Training
     * @param timePerformingHours amount of time of Strength Training in hours
     * @param strengthTrainingLevel one of three different kinds of strength training levels
     */

    public StrengthTraining(Long id, User user, LocalDateTime date, double timePerformingHours, StrengthTrainingLevel strengthTrainingLevel) {
        super(id, user, date);
        this.setTimePerformingHours(timePerformingHours);
        this.strengthTrainingLevel = strengthTrainingLevel;

    }

    // Setters and Getters
    public StrengthTrainingLevel getStrengthTrainingLevel() {
        return strengthTrainingLevel;
    }

    public void setStrengthTrainingLevel(StrengthTrainingLevel strengthTrainingLevel) {
        this.strengthTrainingLevel = strengthTrainingLevel;
    }

    /**
     * @return calories out from Strength Training based on
     * the level of weights that were used during the workout
     */

    @Override
    public int getCaloriesOut() {
        int caloriesOut = 0;

        switch (strengthTrainingLevel) {
            case HEAVY:
                {
                    caloriesOut = FitnessFormulas.caloriesOutByMET(FitnessFormulas.MET_STRENGTH_TRAINING_HEAVY, this.getUser().getBodyMassKg(), this.getTimePerformingHours());
                }
                break;
            case MEDIUM:
                {
                    caloriesOut = FitnessFormulas.caloriesOutByMET(FitnessFormulas.MET_STRENGTH_TRAINING_MEDIUM, this.getUser().getBodyMassKg(), this.getTimePerformingHours());
                }
                break;
            case LIGHT:
                {
                    caloriesOut = FitnessFormulas.caloriesOutByMET(FitnessFormulas.MET_STRENGTH_TRAINING_LIGHT, this.getUser().getBodyMassKg(), this.getTimePerformingHours());
                }
                break;
        }
        return caloriesOut;
    }

    /**
     * Will be using getActiveTimeMins() to calculate the amount
     * of minutes the user is active during the workout
     * @return total active minutes from Strength Training
     */
    @Override
    public int getActiveTimeMins(){
        return (int)Math.round(FitnessFormulas.MINS_IN_AN_HOUR * this.getTimePerformingHours());
    }

}
