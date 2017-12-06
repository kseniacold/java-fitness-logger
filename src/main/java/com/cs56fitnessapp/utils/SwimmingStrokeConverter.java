package com.cs56fitnessapp.utils;

import com.cs56fitnessapp.models.workout.SwimmingStroke;
import javafx.util.StringConverter;

/**
 * @author Ksenia Koldaeva
 * Created: 12/6/17
 * Last Updated: 12/6/17
 */

/**
 *  Creates converter from String to SwimmingStroke enum and back
 */
public class SwimmingStrokeConverter extends StringConverter<SwimmingStroke> {
    @Override
    public String toString(SwimmingStroke object) {
        return object.getStringValue();
    }

    @Override
    public SwimmingStroke fromString(String string) {
        return SwimmingStroke.fromString(string);
    }
}
