package com.cs56fitnessapp.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Ksenia Koldaeva
 * Created: 12/7/17
 * Last Updated: 12/7/17
 */

/**
 * Helper class to convert dates to and from db values
 */
public class DateFormatter {
    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static String dateToString(LocalDate date) {
        return date.format(dateFormatter);
    }

    public static String dateTimeToString(LocalDateTime dateTime) {
        return dateTime.format(dateTimeFormatter);
    }

    public static LocalDate stingToDate(String string) {
        return LocalDate.parse(string, dateFormatter);
    }

    public static LocalDateTime stingToDateTime(String string) {
        return LocalDateTime.parse(string, dateTimeFormatter);
    }
}
