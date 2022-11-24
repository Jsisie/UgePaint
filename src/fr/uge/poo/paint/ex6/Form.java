package fr.uge.poo.paint.ex6;

import java.awt.*;

public sealed interface Form permits AbstractRectangleEllipse, Line {

    void draw(Graphics2D graphics, Color color);

    int distance(Point p);
}
