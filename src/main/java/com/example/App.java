package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class App extends Application
{
    private static Stage primaryStage;
    public static Stage getPrimaryStage() {
        return primaryStage;
    }
    @Override
    public void start(Stage stage) {;
        primaryStage = stage;
        RegistirationPage registrationPage = new RegistirationPage();

        Scene scene = new Scene(registrationPage.getView(), 400, 300);
        stage.setScene(scene);
        stage.setTitle("notesheetfx");
        stage.show();
    }
    public static void main( String[] args )
    {
        launch();
    }
}
