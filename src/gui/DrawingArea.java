package gui;

import rectangle.RectangleMover;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class DrawingArea extends JPanel {
    private final java.util.List<RectangleMover> rectangles = new ArrayList<>();
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
                    RectangleMover rectangle = new RectangleMover(DrawingArea.this, startPoint.x, startPoint.y, Math.abs(e.getX() - startPoint.x), Math.abs(e.getY() - startPoint.y));
                    rectangles.add(rectangle);
                    new Thread(rectangle).start();
                    isSecondClick = false;
                }
            }
        });
        setFocusable(true);
        addKeyListener(new KeyAdapter() { // Wczytywanie z klawiatury (gwaritacja jest zależna od kierunku określonego przez strzałki)
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();

                if (keyCode == KeyEvent.VK_LEFT) {
                    for (RectangleMover rectangle : rectangles) {
                        rectangle.setDirectionX(-1);
                        rectangle.setDirectionY(0);
                    }
                } else if (keyCode == KeyEvent.VK_RIGHT) {
                    for (RectangleMover rectangle : rectangles) {
                        rectangle.setDirectionX(1);
                        rectangle.setDirectionY(0);
                    }
                } else if (keyCode == KeyEvent.VK_UP) {
                    for (RectangleMover rectangle : rectangles) {
                        rectangle.setDirectionX(0);
                        rectangle.setDirectionY(-1);
                    }
                } else if (keyCode == KeyEvent.VK_DOWN) {
                    for (RectangleMover rectangle : rectangles) {
                        rectangle.setDirectionX(0);
                        rectangle.setDirectionY(1);
                    }
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
        for (RectangleMover rectangle : rectangles) {
            g.drawRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
            g.setColor(Color.BLUE);
            g.fillRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
        }
    }
}

