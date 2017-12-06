package com.cs56fitnessapp.utils;

import com.cs56fitnessapp.models.ActivityLevel;
import javafx.util.StringConverter;

/**
 * @author Ksenia Koldaeva
 * Created: 12/2/17
 * Last Updated: 12/2/17
 */

/**
 *  Creates converter from String to ActivityLevel enum and back
 */

public class ActivityLevelConverter extends StringConverter<ActivityLevel> {
    @Override
    public String toString(ActivityLevel object) {
        return object.getDescription();
    }

    @Override
    public ActivityLevel fromString(String string) {
        return ActivityLevel.fromString(string);
    }
}
