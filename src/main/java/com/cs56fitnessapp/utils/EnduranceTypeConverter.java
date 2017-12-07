package com.cs56fitnessapp.utils;

import com.cs56fitnessapp.models.workout.EnduranceType;
import javafx.util.StringConverter;

/**
 * @author Ksenia Koldaeva
 * Created: 12/6/17
 * Last Updated: 12/6/17
 */

/**
 *  Creates converter from String to EnduranceType enum and back
 */
public class EnduranceTypeConverter extends StringConverter<EnduranceType> {
    @Override
    public String toString(EnduranceType object) {
        return object.getDescription();
    }

    @Override
    public EnduranceType fromString(String string) {
        return EnduranceType.fromString(string);
    }
    
}
