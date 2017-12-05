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

    /**
     * @param string representation of enum
     * @return corresponding enum value, null if there is no match
     */
    public static ActivityLevel fromString(String string) {
        ActivityLevel obj;

        switch (string) {
            case "Sedentary":
                obj = ActivityLevel.SEDENTARY;
                break;
            case "Somewhat active":
                obj = ActivityLevel.SOMEWHAT_ACTIVE;
                break;
            case "Active":
                obj = ActivityLevel.ACTIVE;
                break;
            case "Very Active":
                obj = ActivityLevel.VERY_ACTIVE;
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
    public static ActivityLevel fromDbValue(String dbValue) {
        ActivityLevel obj;

        switch (dbValue) {
            case "sedentary":
                obj = ActivityLevel.SEDENTARY;
                break;
            case "somewhat_active":
                obj = ActivityLevel.SOMEWHAT_ACTIVE;
                break;
            case "active":
                obj = ActivityLevel.ACTIVE;
                break;
            case "very_active":
                obj = ActivityLevel.VERY_ACTIVE;
                break;
            default:
                obj = null;
        }

        return obj;
    }
}
