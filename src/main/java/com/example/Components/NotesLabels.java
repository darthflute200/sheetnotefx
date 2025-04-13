package com.example.Components;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.io.InputStream;

public class NotesLabels {

    private VBox Header;

    public NotesLabels(String name, String composer) {
        Header = new VBox();
        Header.setAlignment(Pos.CENTER);
        Header.setSpacing(20);

        // Font yükleme
        Font pieceFont = loadFont("/fonts/Limelight-Regular.ttf", 50);
        Font composerFont = loadFont("/fonts/Limelight-Regular.ttf", 20);

        // Eser adı label'ı
        Label PieceNameLabel = new Label(name);
        PieceNameLabel.setFont(pieceFont);
        PieceNameLabel.setMaxWidth(Double.MAX_VALUE);

        HBox HeaderName = new HBox(PieceNameLabel);
        HeaderName.setAlignment(Pos.CENTER); // Ortala
        HeaderName.setMaxWidth(Double.MAX_VALUE);

        // Besteci adı label'ı
        Label ComposerLabel = new Label(composer);
        ComposerLabel.setFont(composerFont);
        ComposerLabel.setMaxWidth(Double.MAX_VALUE);

        HBox HeaderComposer = new HBox(ComposerLabel);
        HeaderComposer.setAlignment(Pos.BASELINE_RIGHT); // Sağa hizala
        HeaderComposer.setMaxWidth(Double.MAX_VALUE);
        Header.setTranslateY(50); 
        HeaderComposer.setTranslateX(-50);

        Header.getChildren().addAll(HeaderName, HeaderComposer);
    }

    // Font yükleme fonksiyonu
    private Font loadFont(String fontPath, double size) {
        try (InputStream fontStream = getClass().getResourceAsStream(fontPath)) {
            if (fontStream == null) {
                System.err.println("Font bulunamadı: " + fontPath);
                return Font.getDefault();
            }
            return Font.loadFont(fontStream, size);
        } catch (Exception e) {
            System.err.println("Font yükleme hatası: " + e.getMessage());
            return Font.getDefault();
        }
    }

    public VBox GetView() {
        return Header;
    }
}

