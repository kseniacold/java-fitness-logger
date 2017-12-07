package com.cs56fitnessapp.models.workout;

/**
 * @author Ksenia Koldaeva
 * Created: 10/11/17
 * Last Updated: 10/11/17
 */

public enum CyclingType {
    // Traditional strokes + mixed
    MOUNTAIN("Mountain", "mountain"), RACING("Racing", "racing"), LEISURE("Leisure", "leisure");

    // String representation
    private String stringValue;
    private String dbValue;

    CyclingType(String stringValue, String dbValue) {
        this.stringValue = stringValue;
        this.dbValue = dbValue;
    }

    /**
     * @return String representation of CyclingType
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
    public static CyclingType fromString(String string) {
        CyclingType obj;

        switch (string) {
            case "Mountain":
                obj = CyclingType.MOUNTAIN;
                break;
            case "Racing":
                obj = CyclingType.RACING;
                break;
            case "Leisure":
                obj = CyclingType.LEISURE;
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
    public static CyclingType fromDbValue(String dbValue) {
        CyclingType obj;

        switch (dbValue) {
            case "mountain":
                obj = CyclingType.MOUNTAIN;
                break;
            case "racing":
                obj = CyclingType.RACING;
                break;
            case "leisure":
                obj = CyclingType.LEISURE;
                break;
            default:
                obj = null;
        }

        return obj;
    }
}
