package com.cs56fitnessapp.models;

/**
 * @Author jimweezy
 * Created: 10/24/17
 * Last changes: 10/24/17 at 5:37 AM
 **/
public enum MealTitle {
    BREAKFAST("Breakfast", "breakfast"),
    LUNCH("Lunch", "lunch"),
    DINNER("Dinner", "dinner"),
    DESSERT("Dessert", "dessert"),
    SNACK("Snack", "snack");

    // String representation
    private String stringValue;
    private String dbValue;

    MealTitle(String stringValue, String dbValue) {
        this.stringValue = stringValue;
        this.dbValue = dbValue;
    }

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
    public static MealTitle fromString(String string) {
        MealTitle obj;

        switch (string) {
            case "Breakfast":
                obj = MealTitle.BREAKFAST;
                break;
            case "Lunch":
                obj = MealTitle.LUNCH;
                break;
            case "Dinner":
                obj = MealTitle.DINNER;
                break;
            case "Dessert":
                obj = MealTitle.DESSERT;
                break;
            case "Snack":
                obj = MealTitle.SNACK;
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
    public static MealTitle fromDbValue(String dbValue) {
        MealTitle obj;

        switch (dbValue) {
            case "breakfast":
                obj = MealTitle.BREAKFAST;
                break;
            case "lunch":
                obj = MealTitle.LUNCH;
                break;
            case "dinner":
                obj = MealTitle.DINNER;
                break;
            case "dessert":
                obj = MealTitle.DESSERT;
                break;
            case "snack":
                obj = MealTitle.SNACK;
                break;
            default:
                obj = null;
        }

        return obj;
    }

}
