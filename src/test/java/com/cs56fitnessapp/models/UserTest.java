package com.cs56fitnessapp.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ksenia Koldaeva
 * Created 10/20/17
 * Last updated 10/24/17
 */

class UserTest {
    static User user;
    static  User userFemale;

    @BeforeEach
    void setUp() {
        // Initializing new user
        user = new User("Patrick", "fitnessguy", "SecretPass", LocalDate.of(1985, 10, 10), Gender.MALE, 85.24, 185.55, Goal.GAIN, 0.5, ActivityLevel.SOMEWHAT_ACTIVE);
        userFemale = new User("Laura", "laurafit", "secretLaura", LocalDate.of(1988, 8, 8), Gender.FEMALE, 59, 177, Goal.LOSE, 0.5, ActivityLevel.SEDENTARY);
    }

    @Test
    void getDateOfBirth() {
        LocalDate DOB = user.getDateOfBirth();
        assertTrue(DOB.isEqual(LocalDate.of(1985, 10, 10)));
        assertTrue(LocalDate.of(1985, 10, 10).isEqual(DOB));
    }

    @Test
    void setDateOfBirth() {
        user.setDateOfBirth(LocalDate.of(1988, 10, 10));
        // test that after setting new DOB it is not equal to the initial value
        assertFalse(user.getDateOfBirth().isEqual(LocalDate.of(1985, 10, 10)));
        assertTrue(user.getDateOfBirth().isEqual(LocalDate.of(1988, 10, 10)));
    }

    @Test
    void getBodyMassKg() {
        double bodyMass = user.getBodyMassKg();
        assertTrue(Double.compare(bodyMass, 85.24) == 0);
        assertFalse(Double.compare(bodyMass, 85.24356) == 0);
        assertFalse(Double.compare(bodyMass, -85.24) == 0);
        assertFalse(Double.compare(bodyMass, 85.23) == 0);
    }

    @Test
    void setBodyMassKg() {
        user.setBodyMassKg(86.41);
        assertTrue(Double.compare(user.getBodyMassKg(), 86.41) == 0);
    }

    @Test
    void getHeight() {
        assertTrue(Double.compare(user.getHeightCm(), 185.55) == 0);
        assertFalse(Double.compare(user.getHeightCm(), 185.5557686) == 0);
        assertFalse(Double.compare(user.getHeightCm(), -185.55) == 0);
        assertFalse(Double.compare(user.getHeightCm(), 185.43) == 0);
    }

    @Test
    void getAge() {
        // users age for Oct. 24 2017 sould be 32
        assertTrue(user.getAge() == 32);
    }

    @Test
    void getBasalMetabolicRate() {
        // Women: BMR = 655.09 + (9.56 x weight in kg) + (1.84 x height in cm) - (4.67 x age in years)
        // Man: BMR = 66.47 + (13.75 x weight in kg) + (5 x height in cm) - (6.45 x age in years)
        // For our guy that would be:
        // 66.47 + (13.75 x 85.24) + (5 x 185.55) - (6.45 x 32) = 1959.87
        // adjust calculations based on the activity level * 1.375 >>> 2694.82125
        double BMRMale = user.getBasalMetabolicRate();
        assertTrue(Double.compare(BMRMale, 2694.82125) == 0);


        // For the lady that would be:
        // 655.09 + (9.56 x 59) + (1.84 x 177) - (4.67 x 28) = 1409.38
        // adjust calculations based on the activity level * 1.2 >>> 1691.256
        double BMRFemale = userFemale.getBasalMetabolicRate();
        assertTrue(Double.compare(BMRFemale, 1691.256) == 0);

    }

    @Test
    void getCalorieOffset() {
        // User wants to gain 0.5 kg per week - calorie offset would be 550
        // (7700 kCal/kg * 0.5kg/week) 7 day/week == 550
        assertTrue(user.getCalorieOffset() == 550);
    }

    @Test
    void getDailyCalorieGoal() {
        // the guy wants to gain 0.5 kg, calorie offset should be 550
        // BMR + calorie offset should be = 3244.82125
        assertTrue(Double.compare(user.getDailyCalorieGoal(), 3244.82125) == 0);
    }

}