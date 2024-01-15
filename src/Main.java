import gui.RectangleDrawingApp;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RectangleDrawingApp frame = new RectangleDrawingApp();
            frame.setVisible(true);
        });
    }
}