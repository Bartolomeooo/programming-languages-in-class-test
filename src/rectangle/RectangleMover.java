package rectangle;

import gui.DrawingArea;

import java.awt.*;
import javax.swing.*;

public class RectangleMover implements Runnable {
    private final Rectangle rectangle;
    private final DrawingArea drawingArea;
    private int directionX = 0, directionY = 1; // trzeba zmodyfikować program pod zmianę kierunku

    public RectangleMover(Rectangle rect, DrawingArea drawingArea) {
        this.rectangle = rect;
        this.drawingArea = drawingArea;
    }

    @Override
    public void run() {
        while(true) {
            SwingUtilities.invokeLater(() -> {
                rectangle.y += directionY;
                rectangle.x += directionX;
                drawingArea.repaint();
            });

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void setDirectionX(int directionX) {
        this.directionX = directionX;
    }

    public void setDirectionY(int directionY) {
        this.directionY = directionY;
    }
}