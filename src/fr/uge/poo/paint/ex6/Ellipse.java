package fr.uge.poo.paint.ex6;

import java.awt.*;

public class Ellipse extends AbstractRectangleEllipse {

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
    public String toString() {
        return "{Ellipse, [" + x1 + ":" + y1 + ", " + width + ", " + height + "]}";
    }
}
