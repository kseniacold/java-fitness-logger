package com.cs56fitnessapp.views.utils;

import com.cs56fitnessapp.models.Gender;
import javafx.util.StringConverter;

/**
 * @author Ksenia Koldaeva
 * Created: 12/2/17
 * Last Updated: 12/2/17
 */

/**
 *  Creates converter from String to Gender enum and back
 */

public class GenderConverter extends StringConverter<Gender> {
    @Override
    public String toString(Gender object) {
        return object.getStringValue();
    }

    @Override
    public Gender fromString(String string) {
        Gender obj;

        if (string.equals("Male")) {
            obj = Gender.MALE;
        } else {
            obj = Gender.FEMALE;
        }
        return obj;
    }
}
