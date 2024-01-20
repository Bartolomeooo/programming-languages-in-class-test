package rectangle;

import gui.DrawingArea;

import java.awt.*;
import javax.swing.*;

public class RectangleMover extends Rectangle implements Runnable {
    private final DrawingArea drawingArea;
    private final Color color; // Dodanie zmiennego koloru do prostokąta dla lepszej widoczności
    private static int directionX = 0, directionY = 1;

    public RectangleMover(DrawingArea drawingArea, int x, int y, int width, int height) {
        super(x, y, width, height);
        this.drawingArea = drawingArea;
        color = new Color((float)Math.random(), (float)Math.random(), (float)Math.random());
    }

    @Override
    public void run() {
        while(true) {
            SwingUtilities.invokeLater(() -> {
                if(directionY == 1 && y + height >= drawingArea.getHeight()) {}
                else if (directionY == -1 && y <= 0) {}
                else if (directionX == 1 && x + width >= drawingArea.getWidth()) {}
                else if (directionX == -1 && x <= 0) {}
                else {
                    y += directionY;
                    x += directionX;
                }

                drawingArea.repaint();
            });

            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void setDirectionX(int newDirectionX) {
        directionX = newDirectionX;
    }

    public static void setDirectionY(int newDirectionY) {
        directionY = newDirectionY;
    }

    public Color getColor() {
        return color;
    }
}