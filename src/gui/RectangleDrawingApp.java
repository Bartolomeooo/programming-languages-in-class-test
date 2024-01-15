package gui;

import javax.swing.*;

public class RectangleDrawingApp extends JFrame {
    private final DrawingArea drawingArea;

    public RectangleDrawingApp() {
        setTitle("Rysowanie prostokątów");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        drawingArea = new DrawingArea();
        add(drawingArea);
        pack();
        setLocationRelativeTo(null);
    }
}