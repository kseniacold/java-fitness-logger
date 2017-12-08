package com.cs56fitnessapp.utils;

import com.cs56fitnessapp.models.workout.StrengthTrainingLevel;
import javafx.util.StringConverter;

/**
 * @author kseniacold
 * Created: 12/7/17
 * Last Updated:
 */

/**
 *  Creates converter from String to StrengthTrainingLevel enum and back
 */
public class StrengthLevelConverter extends StringConverter<StrengthTrainingLevel> {
    @Override
    public String toString(StrengthTrainingLevel object) {
        return object.getDescription();
    }

    @Override
    public StrengthTrainingLevel fromString(String string) {
        return StrengthTrainingLevel.fromString(string);
    }
}

