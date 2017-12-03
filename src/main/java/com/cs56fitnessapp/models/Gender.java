package com.cs56fitnessapp.models;

/**
 * @author Ksenia Koldaeva
 * Created: 10/6/17
 * Last Updated: 10/7/17
 */

public enum Gender {
    // FEMALE / MALE options
    FEMALE("Female", "female"), MALE("Male", "male");

    // String representation
    private String stringValue;
    private String dbValue;

    /**
     * Constructs new Gender with provided description
     * @param stringValue
     */
    Gender(String stringValue, String dbValue) {
        this.stringValue = stringValue;
        this.dbValue = dbValue;
    }

    /**
     * @return String representation of Gender Enum
     */
    public String getStringValue() {
        return stringValue;
    }

    /**
     * @return String representation for DB
     */
    public String getDbValue() {
        return dbValue;
    }
}
