package gui;

import javax.swing.*;
import java.awt.*;

public class RectangleDrawingApp extends JFrame {
    private final DrawingArea drawingArea;

    public RectangleDrawingApp() {
        setTitle("Rysowanie prostokątów");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel gravityControlLabel = new JLabel("Steruj grawitacją za pomocą strzałek (góra, dół, prawo, lewo)", SwingConstants.CENTER); // Dodanie informacji o sterowaniu grawitacją
        gravityControlLabel.setFont(new Font("Arial", Font.BOLD, 13));
        gravityControlLabel.setPreferredSize(new Dimension(800, 30));
        gravityControlLabel.setBackground(Color.WHITE);
        gravityControlLabel.setOpaque(true);


        add(gravityControlLabel, BorderLayout.NORTH);

        drawingArea = new DrawingArea();
        add(drawingArea);
        pack();
        setLocationRelativeTo(null);
    }
}