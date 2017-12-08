package com.cs56fitnessapp.controllers;

import com.cs56fitnessapp.FitnessApplication;
import com.cs56fitnessapp.models.User;
import com.cs56fitnessapp.models.workout.StrengthTraining;
import com.cs56fitnessapp.models.workout.StrengthTrainingLevel;
import com.cs56fitnessapp.services.WorkoutService;
import com.cs56fitnessapp.utils.StrengthLevelConverter;
import com.cs56fitnessapp.utils.UnitsConverter;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ResourceBundle;


/**
 * @author Ksenia Koldaeva
 * Created: 12/7/17
 * Last Updated: 12/7/17
 */
public class StrengthController implements Initializable {
    // window that this scene belongs to
    private Stage window;
    private Parent root;

    @FXML
    private Label title;

    @FXML
    private TextField trainingDuration;

    @FXML
    ChoiceBox<StrengthTrainingLevel> weightAmt;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /** Set converters from String to enum and back */
        weightAmt.setConverter(new StrengthLevelConverter());
    }

    @FXML
    private void addStrength() throws SQLException, ClassNotFoundException {
        User user = FitnessApplication.getUser();
        StrengthTraining strength = null;
        long centinelId = 0;

        LocalDateTime date = LocalDateTime.now();
        double timePerformingHrs = UnitsConverter.minsToHrs(Double.parseDouble(trainingDuration.getText()));
        StrengthTrainingLevel strengthLevel = weightAmt.getValue();

        /************************************************************************/

        strength = new StrengthTraining(centinelId, user, date, timePerformingHrs, strengthLevel);
        WorkoutService.addStrengthToDb(strength);
    }

}
