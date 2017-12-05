package com.cs56fitnessapp.utils;

import com.cs56fitnessapp.models.Goal;
import javafx.util.StringConverter;

/**
 * @author Ksenia Koldaeva
 * Created: 12/2/17
 * Last Updated: 12/2/17
 */

/**
 *  Creates converter from String to Goal enum and back
 */

public class GoalConverter extends StringConverter<Goal> {
    @Override
    public String toString(Goal object) {
        return object.getDescription();
    }

    @Override
    public Goal fromString(String string) {
        return Goal.fromString(string);
    }
}
