package com.example.Components;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Note {
    private double X_Position;
    private double Y_Position;
    private Label label;
    private Color color;
    private NoteDurationSelector.NoteDuration duration;
    public Note(double X_Position , double Y_Position ,NoteDurationSelector.NoteDuration duration, Color color){
        this.X_Position = X_Position;
        this.Y_Position = Y_Position;
        this.duration = duration;
        this.color = color;
        Font bravuraFont = Font.loadFont(getClass().getResourceAsStream("/fonts/Bravura.otf"), 60);
        label = new Label(duration.getUnicode());
        label.setFont(bravuraFont);
        label.setTextFill(color);
        label.setLayoutX(X_Position);
        label.setLayoutY(Y_Position);
    }
    public double getXPosition() {
        return X_Position;
    }
    public Label getLabel() {
        return label;
    }
    public double getYPosition() {
        return Y_Position;
    }
    public void setXPosition(double xPosition) {
        this.X_Position = xPosition;
        label.setLayoutX(xPosition);
    }
    public void setYPosition(double YPosition) {
        this.Y_Position = YPosition;
        label.setLayoutY(YPosition);
    }
    public Color getColor(){
        return color;
    }
    public void SetColor(Color color){
        this.color = color;
        label.setTextFill(color);
    }
    public NoteDurationSelector.NoteDuration getDuration() {
        return duration;
    }
    public void setDuration(NoteDurationSelector.NoteDuration newDuration) {
        this.duration = newDuration;
        label.setText(newDuration.getUnicode());
    }
}
