package com.cs56fitnessapp.models.workout;

/**
 * @author Ksenia Koldaeva
 * Created: 10/10/17
 * Last Updated: 10/11/17
 */
public class Swimming extends Endurance {

    private SwimmingStroke swimmingStroke;

    @Override
    public int getCaloriesOut() {
        return 0;
    }

    @Override
    public int getActiveTime() {
        return 0;
    }
}
