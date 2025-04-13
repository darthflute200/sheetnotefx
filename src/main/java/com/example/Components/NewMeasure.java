package com.example.Components;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;

public class NewMeasure {
    private static final int LINE_COUNT = 5; 
    private static final int LINE_SPACING = 20; 
    private int START_Y; 
    private int LEFT_MARGIN; 
    private  int RIGHT_MARGIN;
    double flatSize = LINE_SPACING * 1.8;
    Canvas canvas = new Canvas(300, 400);
    GraphicsContext gc = canvas.getGraphicsContext2D();
    public NewMeasure(int start_y , int left_margin , int right_margin){
       START_Y = start_y;
       LEFT_MARGIN = left_margin;
       RIGHT_MARGIN = right_margin;
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
        Pane root = new Pane(canvas);
        return root;
    }
}
