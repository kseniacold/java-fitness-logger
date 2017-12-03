package com.cs56fitnessapp.views;

import com.cs56fitnessapp.models.ActivityLevel;
import com.cs56fitnessapp.models.Gender;
import com.cs56fitnessapp.models.Goal;
import com.cs56fitnessapp.views.utils.ActivityLevelConverter;
import com.cs56fitnessapp.views.utils.FormatterUtils;
import com.cs56fitnessapp.views.utils.GenderConverter;
import com.cs56fitnessapp.views.utils.GoalConverter;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Ksenia Koldaeva
 * Created: 11/29/17
 * Last Updated: 11/29/17
 */

public class RegisterUserController implements Initializable {
    @FXML
    private ChoiceBox<Goal> goal;

    @FXML
    private ChoiceBox<ActivityLevel> activityLevel;

    @FXML
    private ChoiceBox<Gender> gender;

    @FXML
    private DatePicker date;

    @FXML
    private TextField heightFt;

    @FXML
    private TextField heightIns;

    @FXML
    private TextField weight;

    @FXML
    private TextField goalWeight;

    // Weekly goal interactive elements start
    @FXML
    private Text selectGoalFirst;

    @FXML
    private Text maintainWeight;

    @FXML
    private VBox loseWeightContainer;

    @FXML
    private VBox gainWeightContainer;

    @FXML
    private TextField loseWeight;

    @FXML
    private TextField gainWeight;
    // Weekly goal interactive elements end

    @FXML
    private TextField email;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;

    /**
     * No argument constructor
     */
    public RegisterUserController() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        /** Set converter from String to enum and back */
        goal.setConverter(new GoalConverter());
        goal.setValue(Goal.LOSE);

        /** Set converter from String to enum and back */
        activityLevel.setConverter(new ActivityLevelConverter());
        activityLevel.setValue(ActivityLevel.SEDENTARY);

        /** Set converter from String to enum and back */
        gender.setConverter(new GenderConverter());
        gender.setValue(Gender.MALE);

        heightFt.setTextFormatter(FormatterUtils.getIntFormatter());
        heightIns.setTextFormatter(FormatterUtils.getIntFormatter());

        weight.setTextFormatter(FormatterUtils.getDoubleFormatter());
        loseWeight.setTextFormatter(FormatterUtils.getDoubleFormatter());
        gainWeight.setTextFormatter(FormatterUtils.getDoubleFormatter());

        goalWeight.setTextFormatter(FormatterUtils.getDoubleFormatter());
        email.setTextFormatter(FormatterUtils.getEmailFormatter());

        username.setPromptText("Username");
        email.setPromptText("Email");
        password.setPromptText("Password");

        handleWeeklyGoal();

    }

    @FXML
    private void printOutput() {
    }

    /**
     * Helper method
     * Handle Weekly Goal Interactive Pane
     */
    private void handleWeeklyGoal() {
        maintainWeight.setVisible(false);
        loseWeightContainer.setVisible(false);
        gainWeightContainer.setVisible(false);

        goal.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Goal>() {
            @Override
            public void changed(ObservableValue<? extends Goal> observable, Goal oldValue, Goal newValue) {
                selectGoalFirst.setVisible(false);

                switch (newValue) {
                    case LOSE:
                        maintainWeight.setVisible(false);
                        gainWeightContainer.setVisible(false);
                        loseWeightContainer.setVisible(true);
                        break;
                    case MAINTAIN:
                        loseWeightContainer.setVisible(false);
                        gainWeightContainer.setVisible(false);
                        maintainWeight.setVisible(true);
                        break;
                    case GAIN:
                        maintainWeight.setVisible(false);
                        loseWeightContainer.setVisible(false);
                        gainWeightContainer.setVisible(true);
                        break;
                }
            }
        });


    }

}
