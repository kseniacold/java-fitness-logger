package com.cs56fitnessapp.utils;

import com.cs56fitnessapp.models.workout.CyclingType;
import javafx.util.StringConverter;

/**
 * @author Ksenia Koldaeva
 * Created: 12/6/17
 * Last Updated: 12/6/17
 */

public class CyclingTypeConverter extends StringConverter<CyclingType> {
    @Override
    public String toString(CyclingType object) {
        return null;
    }

    @Override
    public CyclingType fromString(String string) {
        return CyclingType.fromString(string);
    }
}
