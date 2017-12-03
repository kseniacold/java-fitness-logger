package com.cs56fitnessapp.models;

/**
 * @author Ksenia Koldaeva
 * Created: 10/6/17
 * Last Updated: 10/7/17
 */

public enum Goal {
    // LOSE, MAINTAIN, GAIN
    LOSE("Lose weight", "lose"), MAINTAIN("Maintain weight", "maintain"), GAIN("Gain weight", "gain");

    // String representation
    private String description;
    private String dbValue;

    /**
     * Constructs new Goal with provided description
     * @param description
     */
    Goal(String description, String dbValue) {
        this.description = description;
        this.dbValue = dbValue;
    }

    /**
     * @return String representation of Gender Enum
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return String representation for DB
     */
    public String getDbValue() {
        return dbValue;
    }
}
