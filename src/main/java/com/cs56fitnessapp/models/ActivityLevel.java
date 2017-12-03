package com.cs56fitnessapp.models;

/**
 * @author Ksenia Koldaeva
 * Created: 10/6/17
 * Last Updated: 10/7/17
 */

public enum ActivityLevel {
    // SEDENTARY, SOMEWHAT_ACTIVE, ACTIVE, VERY_ACTIVE
    SEDENTARY("Sedentary", "sedentary"), SOMEWHAT_ACTIVE("Somewhat active", "somewhat_active"), ACTIVE("Active", "active"), VERY_ACTIVE("Very active", "very_active");

    // String representation
    private String description;
    private String dbValue;

    /**
     * Constructs new ActivityLevel with provided description
     * @param description
     */
    ActivityLevel(String description, String dbValue) {
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
