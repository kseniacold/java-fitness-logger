package com.cs56fitnessapp.views.utils;

import javafx.scene.control.TextFormatter;

import java.util.function.UnaryOperator;
import java.util.regex.Pattern;

/**
 * @author Ksenia Koldaeva
 * Created: 12/2/17
 * Last Updated: 12/2/17
 */

/**
 * Library of TextFormatters
 */
public class FormatterUtils {
    private static Pattern doublePattern = Pattern.compile("\\d*|\\d+\\.\\d*");
    private static Pattern intPattern = Pattern.compile("^\\d*$");
    private static Pattern emailPattern = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");

    public static TextFormatter getDoubleFormatter() {
        return new TextFormatter((UnaryOperator<TextFormatter.Change>) change -> {
            return doublePattern.matcher(change.getControlNewText()).matches() ? change : null;
        });
    }

    public static TextFormatter getIntFormatter() {
        return new TextFormatter((UnaryOperator<TextFormatter.Change>) change -> {
            return intPattern.matcher(change.getControlNewText()).matches() ? change : null;
        });
    }

    public static TextFormatter getEmailFormatter() {
        return new TextFormatter((UnaryOperator<TextFormatter.Change>) change -> {
            return intPattern.matcher(change.getControlNewText()).matches() ? change : null;
        });
    }
}
