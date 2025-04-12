package com.example;

import com.example.Pages.Signin;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

public class RegistirationPage {
    private VBox root;
    public RegistirationPage(){
        root = new VBox(10);
        root.setPadding(new Insets(20));
        Label title = new Label("Üye Ol");
        title.setFont(new Font("Arial", 20));

        TextField nameField = new TextField();
        nameField.setPromptText("Ad Soyad");

        TextField emailField = new TextField();
        emailField.setPromptText("E-posta");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Şifre");

        Button registerButton = new Button("Kayıt Ol");
        Button SigninButton = new Button("Giriş Yap");
        SigninButton.setOnAction(e -> {
            Scene Signin = new Scene(new Signin().getView(), 400, 300);
            App.getPrimaryStage().setScene(Signin);
        });

        root.getChildren().addAll(title, nameField, emailField, passwordField, registerButton, SigninButton);
    }
    public VBox getView() {
        return root;
    }
}
