package com.example.Pages;


import com.example.Components.NewMeasure;
import com.example.Components.NotesLabels;


import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;



public class NoteScreen {
    private static final int LINE_SPACING = 20; 
    private static final int START_Y = 300; 
    private static final int LEFT_MARGIN =0; 
    private static final int RIGHT_MARGIN =50;
    double flatSize = LINE_SPACING * 1.8;
    Canvas canvas = new Canvas(300, 400);
    GraphicsContext gc = canvas.getGraphicsContext2D();
    private HBox measureLine;
    private BorderPane root;
    private VBox NameLines;
    public void addMeasure(Pane measurePane) {
        measureLine.getChildren().add(measurePane);
    }
    public  NoteScreen(){
        root = new BorderPane();
        measureLine = new HBox();
        NameLines = new NotesLabels("Eser İsmi", "Eser Bestecisi").GetView();
        Pane NotesInfo = new NotesInfoPart().GetView();
        Pane FirstMeasure = new NewMeasure(START_Y, LEFT_MARGIN, RIGHT_MARGIN).newMeasure();
        addMeasure(NotesInfo);
        addMeasure(FirstMeasure);

    }
    public BorderPane getView() {
        root.setCenter(measureLine);
        root.setTop(NameLines);
        return root;
    }
}
