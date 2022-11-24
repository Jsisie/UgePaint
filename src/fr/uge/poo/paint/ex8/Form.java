package fr.uge.poo.paint.ex8;

sealed interface Form permits AbstractRectangleEllipse, Line {

    void draw(Canvas graphics, Canvas.CanvasColor color);

    int distance(Point p);

    WindowSize windowSize();
}
