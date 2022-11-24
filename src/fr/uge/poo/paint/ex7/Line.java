package fr.uge.poo.paint.ex7;

import java.awt.*;

public non-sealed class Line implements Form {

    private final int x1, y1, x2, y2;

    public Line(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public void draw(Graphics2D graphics, Color color) {
        graphics.setColor(color);
        graphics.drawLine(x1,y1,x2,y2);
    }

    private fr.uge.poo.paint.ex7.Point center() {
        int x = (x1 + x2)/2;
        int y = (y1 + y2)/2;
        return new fr.uge.poo.paint.ex7.Point(x, y);
    }

    public int distance(Point p) {
        return ((center().x() - p.y()) * (center().x() - p.x()))
                + ((center().y() - p.y()) * (center().y() - p.y()));
    }

    @Override
    public String toString() {
        return "{Line, ["+x1+":"+y1+", "+y1+":"+y2+"]}";
    }
}
