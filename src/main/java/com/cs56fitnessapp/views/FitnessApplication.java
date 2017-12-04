package com.cs56fitnessapp.views;
import com.cs56fitnessapp.models.User;
import com.cs56fitnessapp.services.SqLiteConnection;
import com.cs56fitnessapp.services.UserService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FitnessApplication extends Application {
    User user;

    @Override
    public void start(Stage stage) throws Exception {
        try {
            SqLiteConnection sqLite = new SqLiteConnection();
            sqLite.getConnection();
            // Initialize tables
            sqLite.initialize();
            if (UserService.dbHasUser()) {
                // Initialize application user
               this.user = UserService.getUserFromDb();
            }
            sqLite.closeConnection();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            // This is a final message to the client
            // TODO create this as a pop up
            System.out.println("Something went wrong");
        }

        /*
        // Uncomment to quickly reset db
        try {
            SqLiteConnection sqLite = new SqLiteConnection();
            sqLite.resetDb();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        */

        Parent root = FXMLLoader.load(getClass().getResource("registerUser.fxml"));
        Scene registerScene = new Scene(root);

        registerScene.getStylesheets().add("https://fonts.googleapis.com/css?family=Heebo:300,400,500,700,800,900|Righteous");
        registerScene.getStylesheets().add(getClass().getResource("../../../resources/application_styles.css").toExternalForm());

        // show welcome scene
        stage.setScene(registerScene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);

    }
}
