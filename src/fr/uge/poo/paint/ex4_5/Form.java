package fr.uge.poo.paint.ex4_5;

import java.awt.*;

public sealed interface Form permits Ellipse, Line, Rectangle {

    void draw(Graphics2D graphics, Color color);

    Point getCenter();

    default int distance(Point p) {
        return ((getCenter().x() - p.y()) * (getCenter().x() - p.x()))
                + ((getCenter().y() - p.y()) * (getCenter().y() - p.y()));
    }
}
