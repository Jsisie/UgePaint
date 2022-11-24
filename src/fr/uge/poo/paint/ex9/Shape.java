package fr.uge.poo.paint.ex9;

sealed interface Shape permits Ellipse, Line, Rectangle {

    void draw(Canvas graphics, Canvas.CanvasColor color);

    int distance(Point p);

    WindowSize windowSize();
}
