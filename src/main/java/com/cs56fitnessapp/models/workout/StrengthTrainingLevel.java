package com.cs56fitnessapp.models.workout;

/**
 * @author Daniel Cervantes
 * @author Ksenia Koldaeva
 * Date created: 11/11/17
 * Last updated: 11/11/17
 */

public enum StrengthTrainingLevel {


    // HEAVY, MEDIUM, LIGHT
    HEAVY("Heavy"), MEDIUM("Medium"), LIGHT("Light");

    // String representation
    private String description;

    /**
     * Constructs new StrengthTrainingLevel
     * @param description to determine which level of training
     */
    StrengthTrainingLevel(String description) {
        this.description = description;
    }

    /**
     * @return the level of training chosen by user
     */
    public String getDescription() {
        return description;
    }
}




