package com.cs56fitnessapp.models.workout;

/**
 * @author Daniel Cervantes
 * @author Ksenia Koldaeva
 * Date created: 11/11/17
 * Last updated: 12/07/17
 */

public enum StrengthTrainingLevel {


    // HEAVY, MEDIUM, LIGHT
    HEAVY("Heavy", "heavy"), MEDIUM("Medium", "medium"), LIGHT("Light", "light");

    // String representation
    private String description;
    private String dbValue;

    /**
     * Constructs new StrengthTrainingLevel
     * @param description to determine which level of training
     */
    StrengthTrainingLevel(String description, String dbValue) {
        this.description = description;
        this.dbValue = dbValue;
    }

    /**
     * @return the level of training chosen by user
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

    /**
     * @param string representation of enum
     * @return corresponding enum value, null if there is no match
     */
    public static StrengthTrainingLevel fromString(String string) {
        StrengthTrainingLevel obj;

        switch (string) {
            case "Heavy":
                obj = StrengthTrainingLevel.HEAVY;
                break;
            case "Medium":
                obj = StrengthTrainingLevel.MEDIUM;
                break;
            case "Light":
                obj = StrengthTrainingLevel.LIGHT;
                break;
            default:
                obj = null;
        }

        return obj;
    }

    /**
     * @param dbValue representation of enum
     * @return corresponding enum value, null if there is no match
     */
    public static StrengthTrainingLevel fromDbValue(String dbValue) {
        StrengthTrainingLevel obj;

        switch (dbValue) {
            case "heavy":
                obj = StrengthTrainingLevel.HEAVY;
                break;
            case "medium":
                obj = StrengthTrainingLevel.MEDIUM;
                break;
            case "light":
                obj = StrengthTrainingLevel.LIGHT;
                break;
            default:
                obj = null;
        }

        return obj;
    }
}




