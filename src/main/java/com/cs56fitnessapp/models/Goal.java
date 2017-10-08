package com.cs56fitnessapp.models;

/**
 * @author Ksenia Koldaeva
 * Created: 10/6/17
 * Last Updated: 10/6/17
 */

public enum Goal {
    // LOSE, MAINTAIN, GAIN
    LOSE("Lose weight"), MAINTAIN("Maintain weight"), GAIN("Gain weight");

    // String representation
    private String description;

    /**
     * Constructs new Goal with provided description
     * @param description
     */
    Goal(String description) {
        this.description = description;
    }

    /**
     * @return String representation of Gender Enum
     */
    public String getDescription() {
        return description;
    }
}
