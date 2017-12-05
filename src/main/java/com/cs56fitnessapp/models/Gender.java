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

    /**
     * @param string representation of enum
     * @return corresponding enum value, null if there is no match
     */
    public static Gender fromString(String string) {
        Gender obj = null;

        if (string.equals("Male")) {
            obj = Gender.MALE;
        } else if (string.equals("Female")) {
            obj = Gender.FEMALE;
        }
        return obj;
    }

    /**
     * @param dbValue representation of enum
     * @return corresponding enum value, null if there is no match
     */
    public static Gender fromDbValue(String dbValue) {
        Gender obj = null;

        if (dbValue.equals("male")) {
            obj = Gender.MALE;
        } else if (dbValue.equals("female")) {
            obj = Gender.FEMALE;
        }
        return obj;
    }
}
