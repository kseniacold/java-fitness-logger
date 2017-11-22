package com.cs56fitnessapp.views;
import com.cs56fitnessapp.SqLiteConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FitnessApplication extends Application{
    @Override
    public void start(Stage stage) throws Exception {

        try {
            SqLiteConnection sqLite = new SqLiteConnection();
            sqLite.getConnection();
            sqLite.closeConnection();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Parent root = FXMLLoader.load(getClass().getResource("welcomeLayout.fxml"));
        Scene welcomeScene = new Scene(root);

        welcomeScene.getStylesheets().add("https://fonts.googleapis.com/css?family=Heebo:300,400,500,700,800,900|Righteous");
        welcomeScene.getStylesheets().add(getClass().getResource("../../../resources/application_styles.css").toExternalForm());

        // show welcome scene
        stage.setScene(welcomeScene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);

    }
}
