package fr.uge.poo.paint.ex3;

import java.awt.*;

public class Rectangle implements Form {

    private final int x1, y1, width, height;

    public Rectangle(int x1, int y1, int width, int height) {
        this.x1 = x1;
        this.y1 = y1;
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics2D graphics) {
        graphics.drawRect(x1,y1,width,height);
    }
}
