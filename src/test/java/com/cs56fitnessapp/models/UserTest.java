package com.cs56fitnessapp.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ksenia Koldaeva
 * Created 10/20/17
 * Last updated 10/20/17
 */

class UserTest {
    static User user;

    @BeforeEach
    void setUp() {
        // Initializing new user
        user = new User("Patrick", "fitnessguy", "SecretPass", LocalDate.of(1985, 10, 10), Gender.MALE, 85, 185, Goal.GAIN, 0.5, ActivityLevel.SOMEWHAT_ACTIVE);
    }

    @Test
    void isSet() {
        assertTrue(user.isSet());
    }

    @Test
    void getDateOfBirth() {

    }

    @Test
    void setDateOfBirth() {

    }

    @Test
    void getbodyMassKg() {

    }

    @Test
    void setbodyMassKg() {

    }

    @Test
    void getHeight() {

    }

    @Test
    void getAge() {

    }

    @Test
    void getBasalMetabolicRate() {

    }

    @Test
    void getCalorieOffset() {

    }

    @Test
    void getDailyCalorieGoal() {

    }

}