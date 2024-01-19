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
                } else { // Uwzględniono przypadki, gdy użytkownik utworzy trójkąt z innych konfiguracji wierzchołków
                    int startX = Math.min(startPoint.x, e.getX());
                    int startY = Math.min(startPoint.y, e.getY());
                    int endX = Math.max(startPoint.x, e.getX());
                    int endY = Math.max(startPoint.y, e.getY());

                    RectangleMover rectangle = new RectangleMover(DrawingArea.this, startX, startY, endX - startX, endY - startY);
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
                // Na zajęciach nie starczyło mi czasu, ale chciałem, żeby cała klasa prostokątów przechowywała informację o kierunku grawitacji
                if (keyCode == KeyEvent.VK_LEFT) { // Dlatego zmienne directionX i directionY są teraz statycznymi polami w klasie RectangleMover
                    RectangleMover.setDirectionX(-1);
                    RectangleMover.setDirectionY(0);
                } else if (keyCode == KeyEvent.VK_RIGHT) {
                    RectangleMover.setDirectionX(1);
                    RectangleMover.setDirectionY(0);
                } else if (keyCode == KeyEvent.VK_UP) {
                    RectangleMover.setDirectionX(0);
                    RectangleMover.setDirectionY(-1);
                } else if (keyCode == KeyEvent.VK_DOWN) {
                    RectangleMover.setDirectionX(0);
                    RectangleMover.setDirectionY(1);
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

