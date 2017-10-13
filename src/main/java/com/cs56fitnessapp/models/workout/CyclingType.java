package com.cs56fitnessapp.models.workout;

/**
 * @author Ksenia Koldaeva
 * Created: 10/11/17
 * Last Updated: 10/11/17
 */

public enum CyclingType {
    // Traditional strokes + mixed
    MOUNTAIN("Mountain"), RACING("Racing"), LEISURE("Leisure");

    // String representation
    private String stringValue;

    CyclingType(String stringValue) {
        this.stringValue = stringValue;
    }

    /**
     * @return String representation of CyclingType
     */
    public String getStringValue() {
        return stringValue;
    }
}
