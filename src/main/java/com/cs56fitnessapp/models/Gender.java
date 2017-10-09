package com.cs56fitnessapp.models;

/**
 * @author Ksenia Koldaeva
 * Created: 10/6/17
 * Last Updated: 10/7/17
 */

public enum Gender {
    // FEMALE / MALE options
    FEMALE("Female"), MALE("Male");

    // String representation
    private String stringValue;

    /**
     * Constructs new Gender with provided description
     * @param stringValue
     */
    Gender(String stringValue) {
        this.stringValue = stringValue;
    }

    /**
     * @return String representation of Gender Enum
     */
    public String getStringValue() {
        return stringValue;
    }
}
