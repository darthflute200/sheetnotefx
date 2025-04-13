package com.example.Pages;

import com.example.App;
import com.example.RegistirationPage;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class Signin {
    private VBox root;
    public Signin(){
        root = new VBox(10);
        root.setPadding(new Insets(20));
        Label title = new Label("Giriş Yap");
        title.setFont(new Font("Arial", 20));

        TextField emailField = new TextField();
        emailField.setPromptText("E-posta");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Şifre");

        Button registerButton = new Button("Giriş Yap");
        Button SignupButton = new Button("Üye Ol");
        SignupButton.setOnAction(e ->{
            Scene SignupScence = new Scene(new RegistirationPage().getView() , 400 , 300);
            App.getPrimaryStage().setScene(SignupScence);
        });
        registerButton.setOnAction(e ->{
            Scene NoteScene = new Scene(new NoteScreen().getView() , 300 , 400);
            App.getPrimaryStage().setScene(NoteScene);
        });
        root.getChildren().addAll(title , emailField , passwordField , registerButton , SignupButton);
    }
    public VBox getView(){
        return root;
    }
}
