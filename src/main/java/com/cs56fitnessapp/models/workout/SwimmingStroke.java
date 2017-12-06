package com.cs56fitnessapp.models.workout;

/**
 * @author Ksenia Koldaeva
 * Created: 10/11/17
 * Last Updated: 10/11/17
 */

public enum SwimmingStroke {
    // Traditional strokes + mixed
    FREESTYLE("Freestyle", "freestyle"), BREASTSTROKE("Breaststroke", "breast"), BACKSTROKE("Backstroke", "back"), BUTTERFLY("Butterfly", "butterfly"), MIXED("Mixed", "mixed");

    // String representation
    private String stringValue;
    private String dbValue;

    SwimmingStroke(String stringValue, String dbValue) {
        this.stringValue = stringValue;
        this.dbValue = dbValue;
    }

    /**
     * @return String representation of SwimmingStroke
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
    public static SwimmingStroke fromString(String string) {
        SwimmingStroke obj;

        switch (string) {
            case "Freestyle":
                obj = SwimmingStroke.FREESTYLE;
                break;
            case "Breaststroke":
                obj = SwimmingStroke.BREASTSTROKE;
                break;
            case "Backstroke":
                obj = SwimmingStroke.BACKSTROKE;
                break;
            case "Butterfly":
                obj = SwimmingStroke.BUTTERFLY;
                break;
            case "Mixed":
                obj = SwimmingStroke.MIXED;
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
    public static SwimmingStroke fromDbValue(String dbValue) {
        SwimmingStroke obj;

        switch (dbValue) {
            case "freestyle":
                obj = SwimmingStroke.FREESTYLE;
                break;
            case "breast":
                obj = SwimmingStroke.BREASTSTROKE;
                break;
            case "back":
                obj = SwimmingStroke.BACKSTROKE;
                break;
            case "butterfly":
                obj = SwimmingStroke.BUTTERFLY;
                break;
            case "mixed":
                obj = SwimmingStroke.MIXED;
                break;
            default:
                obj = null;
        }

        return obj;
    }
}
