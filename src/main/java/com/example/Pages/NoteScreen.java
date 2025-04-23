package com.example.Pages;


import com.example.App;
import com.example.Components.NewMeasure;
import com.example.Components.NoteDurationSelector;
import com.example.Components.NotesLabels;

import javafx.application.Platform;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;



public class NoteScreen {
    private static final int LINE_SPACING = 20; 
    private int START_Y = 100; 
    private int LEFT_MARGIN =0; 
    private int RIGHT_MARGIN =50;
    double flatSize = LINE_SPACING * 1.8;
    Canvas canvas = new Canvas(300, 400);
    GraphicsContext gc = canvas.getGraphicsContext2D();
    private List<NewMeasure> MeasureList = new ArrayList<>();
    private HBox measureLine;
    private VBox root;
    public void addMeasure(Pane measurePane , NewMeasure measure) {
        measureLine.getChildren().add(measurePane);
        if(measure != null ){
        MeasureList.add(measure);
        }
    }
    public  NoteScreen(){
        NoteDurationSelector selector = new NoteDurationSelector();
        root = new VBox();
        root.setFocusTraversable(true); 
        root.requestFocus();
        measureLine = new HBox();
        measureLine.setSpacing(0);
        VBox header = new NotesLabels("Eser İsmi", "Eser Bestecisi").GetView();
        Pane NotesInfo = new NotesInfoPart().GetView();
        NewMeasure FirstMeasure = new NewMeasure(START_Y, LEFT_MARGIN, RIGHT_MARGIN , 4 );
        Pane FirstMeasureDraw = FirstMeasure.newMeasure();
        addMeasure(NotesInfo , null);
        addMeasure(FirstMeasureDraw , FirstMeasure);
        NewMeasure lastMeasure = MeasureList.get(MeasureList.size() - 1);
        Platform.runLater(() -> {
    if (App.getPrimaryStage().getScene() != null) {
        App.getPrimaryStage().getScene().setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case RIGHT:
                    selector.next(lastMeasure.GetbeatsPerMeasure() - lastMeasure.getCurrentBeat());
                    System.out.println(lastMeasure.GetbeatsPerMeasure() - lastMeasure.getCurrentBeat());
                    lastMeasure.updateLastNoteDuration(selector.getCurrent());
                    break;
                case LEFT:
                    selector.previous(lastMeasure.GetbeatsPerMeasure() - lastMeasure.getCurrentBeat());
                    lastMeasure.updateLastNoteDuration(selector.getCurrent());
                    break;
                case UP:
                    lastMeasure.GetLastNote().setYPosition(lastMeasure.GetLastNote().getYPosition() - 10);
                    break;
                case DOWN:
                    lastMeasure.GetLastNote().setYPosition(lastMeasure.GetLastNote().getYPosition() + 10);
                    break;
                case ENTER:
                    lastMeasure.DefineNote();
                    newMeasureCreate(lastMeasure);
                    break;
                case DELETE:
                case BACK_SPACE:
                    lastMeasure.DeleteNote();
                    break;
            }
        });
    }
});

        root.getChildren().addAll(header , measureLine);

    }
    private void newMeasureCreate(NewMeasure LastMeasure){
       float currentBeat = LastMeasure.getCurrentBeat();
       int beatsPerMeasure = LastMeasure.GetbeatsPerMeasure();
       if(currentBeat >= beatsPerMeasure){
        int newLeftMargin = LEFT_MARGIN + 50;
        int newRightMargin = RIGHT_MARGIN + 100;
        NewMeasure newMeasure = new NewMeasure( START_Y, newLeftMargin, beatsPerMeasure,newRightMargin);
        Pane newMeasurePane = newMeasure.newMeasure();
        addMeasure(newMeasurePane, newMeasure);
        LEFT_MARGIN = newLeftMargin;
        RIGHT_MARGIN = newRightMargin;
       }
    }
    public VBox getView() {
        return root;
    }
}
