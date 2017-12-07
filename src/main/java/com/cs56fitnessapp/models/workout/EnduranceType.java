package com.cs56fitnessapp.models.workout;

/**
 * @author Ksenia Koldaeva
 * Created: 12/6/17
 * Last Updated: 12/7/17
 */

public enum EnduranceType {
    // RUNNING, SWIMMING, CYCLING, 
    RUNNING("Running", "running"), SWIMMING("Swimming", "swimming"), CYCLING("Cycling", "cycling");

    // String representation
    private String description;
    private String dbValue;

    /**
     * Constructs new EnduranceType with provided description
     * @param description
     */
    EnduranceType(String description, String dbValue) {
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
    public static EnduranceType fromString(String string) {
        EnduranceType obj;

        switch (string) {
            case "Running":
                obj = EnduranceType.RUNNING;
                break;
            case "Swimming":
                obj = EnduranceType.SWIMMING;
                break;
            case "Cycling":
                obj = EnduranceType.CYCLING;
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
    public static EnduranceType fromDbValue(String dbValue) {
        EnduranceType obj;

        switch (dbValue) {
            case "running":
                obj = EnduranceType.RUNNING;
                break;
            case "swimming":
                obj = EnduranceType.SWIMMING;
                break;
            case "cycling":
                obj = EnduranceType.CYCLING;
                break;
            default:
                obj = null;
        }

        return obj;
    }
}
