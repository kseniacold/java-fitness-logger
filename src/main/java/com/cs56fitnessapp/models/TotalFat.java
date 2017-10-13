package com.cs56fitnessapp.models;

/**
 * @author Ksenia Koldaeva
 * Created: 10/1/17
 * Last Updated: 10/11/17
 */

public class TotalFat {
    private double totalFat;
    private double saturatedFat;
    private double transFat;

    /**
     * Constructs totalFat object with provided total fat value
     * @param totalFat total fat value
     */
    public TotalFat(double totalFat) {
        this.totalFat = totalFat;
    }

    // Start getters and setters

    public double getTotalFat() {
        return totalFat;
    }

    public void setTotalFat(double totalFat) {
        this.totalFat = totalFat;
    }

    public double getSaturatedFat() {
        return saturatedFat;
    }

    public void setSaturatedFat(double saturatedFat) {
        this.saturatedFat = saturatedFat;
    }

    public double getTransFat() {
        return transFat;
    }

    public void setTransFat(double transFat) {
        this.transFat = transFat;
    }

    // End getters and setters
}
