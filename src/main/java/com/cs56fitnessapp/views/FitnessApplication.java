package com.cs56fitnessapp.views;
import com.cs56fitnessapp.SqLiteConnection;
import javafx.application.Application;
import javafx.stage.Stage;

public class FitnessApplication extends Application{
     @Override
    public void start(Stage stage) {
         try {
             SqLiteConnection sqLite = new SqLiteConnection();
             sqLite.getConnection();
             sqLite.closeConnection();
         } catch (Exception e) {
             System.out.println(e.getMessage());
         }
    }

    public static void main(String[] args) {
        Application.launch(args);

    }
}
