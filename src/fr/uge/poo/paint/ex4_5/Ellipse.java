package fr.uge.poo.paint.ex4_5;

import java.awt.*;

public non-sealed class Ellipse implements Form {

    private final int x1, y1, width, height;

    public Ellipse(int x1, int y1, int width, int height) {
        this.x1 = x1;
        this.y1 = y1;
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics2D graphics, Color color) {
        graphics.setColor(color);
        graphics.drawOval(x1, y1, width, height);
    }

    @Override
    public Point getCenter() {
        int x = x1 + (width / 2);
        int y = y1 + (height / 2);
        return new Point(x, y);
    }

    @Override
    public String toString() {
        return "{Ellipse, [" + x1 + ":" + y1 + ", " + width + ", " + height + "]}";
    }
}
