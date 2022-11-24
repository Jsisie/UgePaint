package fr.uge.poo.paint.ex6;

import java.awt.*;

public class Rectangle extends AbstractRectangleEllipse {

    private final int x1, y1, width, height;

    public Rectangle(int x1, int y1, int width, int height) {
        this.x1 = x1;
        this.y1 = y1;
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics2D graphics, Color color) {
        graphics.setColor(color);
        graphics.drawRect(x1, y1, width, height);
    }

    @Override
    public String toString() {
        return "{Rectangle, [" + x1 + ":" + y1 + ", " + width + ", " + height + "]}";
    }
}
