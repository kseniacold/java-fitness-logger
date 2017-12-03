package com.cs56fitnessapp.utils;

/**
 * @author Ksenia Koldaeva
 * Created: 12/2/17
 * Last Updated: 12/2/17
 */
public class UnitsConverter {
    public static final double POUNDS_IN_KG = 2.2046226218;
    public  static final double CM_IN_INCH = 2.54;
    public static final double CM_IN_FOOT = 30.48;

    public static double poundsToKg(double pounds) {
        return pounds / POUNDS_IN_KG;
    }

    public static double feetInchesToCm(int ft, int in) {
        return ft * CM_IN_FOOT + in * CM_IN_INCH;
    }
}
