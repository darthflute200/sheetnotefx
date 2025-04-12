package com.example.ClassicTones;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class F {
    public static void addFlatForFMajor(GraphicsContext gc, Font bravuraFont, int LINE_SPACING, int LEFT_MARGIN, int START_Y) {
        if (bravuraFont != null) {
            gc.setFont(bravuraFont);
            gc.setFill(Color.BLACK);
            
            double flatX = LEFT_MARGIN + 70; 
            double flatY = START_Y + LINE_SPACING * 2;
            
            gc.fillText("\uE260", flatX, flatY); 
            gc.fillText("\uE08A", flatX + 50, flatY);
        }
    }
}
