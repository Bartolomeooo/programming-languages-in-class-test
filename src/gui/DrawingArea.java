package gui;

import rectangle.RectangleMover;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class DrawingArea extends JPanel {
    private final java.util.List<Rectangle> rectangles = new ArrayList<>();
    private Point startPoint;
    Boolean isSecondClick = false;

    public DrawingArea() {
        setPreferredSize(new Dimension(800, 600));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (!isSecondClick) {
                    startPoint = e.getPoint();
                    isSecondClick = true;
                } else {
                    //Point endPoint = e.getPoint();
                    Rectangle rectangle = new Rectangle(startPoint.x, startPoint.y, Math.abs(e.getX() - startPoint.x), Math.abs(e.getY() - startPoint.y));
                    rectangles.add(rectangle);
                    new Thread(new RectangleMover(rectangle, DrawingArea.this)).start();
                    isSecondClick = false;
                }
            }
        });

        Timer timer = new Timer(2, e -> {
            repaint();
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Rectangle rectangle : rectangles) {
            g.drawRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
            g.setColor(Color.BLUE);
            g.fillRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
        }
    }
}

