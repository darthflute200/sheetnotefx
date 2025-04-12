package com.example.Pages;

import java.io.InputStream;

import com.example.ClassicTones.F;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
public class NotesInfoPart {
    InputStream otfFontStream = getClass().getResourceAsStream("/fonts/Bravura.otf");
    private static final int LINE_COUNT = 5; 
    private static final int LINE_SPACING = 20; 
    private static final int START_Y = 100; 
    private static final int LEFT_MARGIN = 50; 
    private static final int RIGHT_MARGIN = 50;
    double flatSize = LINE_SPACING * 1.8;
    private Font bravuraFont;
    Canvas canvas = new Canvas(300, 400);
    GraphicsContext gc = canvas.getGraphicsContext2D();
    public NotesInfoPart() {
        gc.setStroke(javafx.scene.paint.Color.BLACK);
        gc.setLineWidth(2); 
        bravuraFont = Font.loadFont(otfFontStream, LINE_SPACING * 3);
        
        // 5 çizgiyi çiz
        for (int i = 0; i < LINE_COUNT; i++) {
            
            double y = START_Y + i * LINE_SPACING;
            
            // Çizgiyi çiz (sol kenardan sağ kenara)
            gc.strokeLine(LEFT_MARGIN, y, 300 - RIGHT_MARGIN, y);
        }
            gc.setFont(bravuraFont);
            gc.setFill(javafx.scene.paint.Color.BLACK);
            gc.fillText("\uE050", LEFT_MARGIN  , START_Y + LINE_SPACING * 2 + 15);
            F.addFlatForFMajor(gc, bravuraFont, LINE_SPACING, LEFT_MARGIN, START_Y);
        }
    public Pane GetView(){
        Pane root = new Pane(canvas);
        return root;
    }
    
}

