package com.cs56fitnessapp.models;

/**
 * @author Ksenia Koldaeva
 * Created: 10/6/17
 * Last Updated: 10/7/17
 */

public enum ActivityLevel {
    // SEDENTARY, SOMEWHAT_ACTIVE, ACTIVE, VERY_ACTIVE
    SEDENTARY("Sedentary"), SOMEWHAT_ACTIVE("Somewhat active"), ACTIVE("Active"), VERY_ACTIVE("Very active");

    // String representation
    private String description;

    /**
     * Constructs new ActivityLevel with provided description
     * @param description
     */
    ActivityLevel(String description) {
        this.description = description;
    }

    /**
     * @return String representation of Gender Enum
     */
    public String getDescription() {
        return description;
    }
}
