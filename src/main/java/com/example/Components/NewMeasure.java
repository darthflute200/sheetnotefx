package com.example.Components;

import java.util.ArrayList;
import java.util.List;

import com.example.Components.NoteDurationSelector.NoteDuration;

import javafx.collections.ObservableList;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.Node;

public class NewMeasure {
    private static final int LINE_COUNT = 5; 
    private static final int LINE_SPACING = 20; 
    private int START_Y; 
    private int LEFT_MARGIN; 
    private  int RIGHT_MARGIN;
    private Pane root;
    private double currentX;
    double flatSize = LINE_SPACING * 1.8;
    private List<Note> NoteList = new ArrayList<>();
    Canvas canvas = new Canvas(300, 400);
    GraphicsContext gc = canvas.getGraphicsContext2D();
    private int beatsPerMeasure;
    private float currentBeat = 0f;
    public NewMeasure(int start_y , int left_margin , int right_margin, int BeatsPerMeasure){
       START_Y = start_y;
       LEFT_MARGIN = left_margin;
       RIGHT_MARGIN = right_margin;
       beatsPerMeasure = BeatsPerMeasure;
       currentBeat = left_margin;
    }
    public int GetbeatsPerMeasure(){
        return beatsPerMeasure;
    }
    public float getCurrentBeat(){
        return currentBeat;
    }
    public Pane newMeasure(){
        gc.setStroke(javafx.scene.paint.Color.BLACK);
        gc.setLineWidth(2); 
        for (int i = 0; i < LINE_COUNT; i++) {
            
            double y = START_Y + i * LINE_SPACING;
            
            gc.strokeLine(LEFT_MARGIN, y, 300 - RIGHT_MARGIN, y);
        }
        double endX = 300 - RIGHT_MARGIN;
        double topY = START_Y;
        double bottomY = START_Y + (LINE_COUNT - 1) * LINE_SPACING;
        gc.strokeLine(endX, topY, endX, bottomY);
        root = new Pane(canvas);
        CreateNote(NoteDuration.EIGHTH);
        return root;
    } 
    public void CreateNote(NoteDurationSelector.NoteDuration duration){
        float beatvalue = getBeatValue(duration);
        double x = currentX + beatvalue * 10; 
        double y = START_Y - 160;
        Note note = new Note(x, y, duration , Color.LIGHTGREY);
        NoteList.add(note);
        root.getChildren().add(note.getLabel());
    }
    public void DefineNote(){
        ObservableList<Node> children = root.getChildren();
        if (!children.isEmpty()) {
        Node lastNode = children.get(children.size() - 1);
    
        if (lastNode instanceof Label) {
        Label lastLabel = (Label) lastNode;
        
        lastLabel.setTextFill(Color.BLACK); 
       }
       Note lasNote = NoteList.get(NoteList.size() - 1);
       float beatValue = getBeatValue(lasNote.getDuration());
       currentBeat += beatValue;
       currentX = lasNote.getXPosition() + 20;
       lasNote.SetColor(Color.BLACK);
       CreateNote(NoteDuration.EIGHTH);
      }

    }
    public Note GetLastNote(){
        Note lasNote = NoteList.get(NoteList.size() - 1);
        return lasNote;
    }
    public void updateLastNoteDuration(NoteDurationSelector.NoteDuration newDuration) {
        ObservableList<Node> children = root.getChildren();
        if (!children.isEmpty() && !NoteList.isEmpty()) {
            Node lastNode = children.get(children.size() - 1);
            Note lastNote = NoteList.get(NoteList.size() - 1);
            if (lastNode instanceof Label) {
                Label lastLabel = (Label) lastNode;
    
                lastNote.setDuration(newDuration);
                float newBeatValue = getBeatValue(newDuration);
                lastLabel.setText(newDuration.getUnicode());
                double newX;
                newX = currentX + newBeatValue * 10;
                lastNote.setXPosition(newX);
            }
        }
    }
    public int getBeat(){
        return beatsPerMeasure;
    }
    private Note getLastDefinedNote() {
        for (int i = NoteList.size() - 1; i >= 0; i--) {
            Note note = NoteList.get(i);
            if (note.getColor().equals(Color.BLACK)) {
                return note;
            }
        }
        return null; 
    }
    public void DeleteNote (){
       Note LastDefinedNote = getLastDefinedNote();
       Note UndefinedNote = NoteList.get(NoteList.size() - 1);
       if (LastDefinedNote == null){
        return;
       }
       root.getChildren().remove(LastDefinedNote.getLabel());
       NoteList.remove(LastDefinedNote);
       Note PrevLastDefinedNote = getLastDefinedNote();
       if (PrevLastDefinedNote == null){
        currentX = LEFT_MARGIN + 20;
       }
       else{
        currentX = PrevLastDefinedNote.getXPosition() + 20;
       }
       UndefinedNote.setXPosition(currentX);
    }
    private float getBeatValue(NoteDurationSelector.NoteDuration duration) {
        switch (duration) {
            case WHOLE:
                return 4f;
            case HALF:
                return 2f;
            case QUARTER:
                return 1f;
            case EIGHTH:
                return 0.5f;
            default:
                return 0f;
        }
    }
}
