package fr.uge.poo.paint.solution1;

sealed interface Shape permits Ellipse, Line, Rectangle {

    void draw(Canvas graphics, Canvas.CanvasColor color);

    int distance(Point p);

    WindowSize windowSize();

    static Shape createShapeFromName(String name, int val1, int val2, int val3, int val4) {
        return switch (name) {
            case "line" -> new Line(val1, val2, val3, val4);
            case "ellipse" -> new Ellipse(val1, val2, val3, val4);
            case "rectangle" -> new Rectangle(val1, val2, val3, val4);
            case default -> throw new UnsupportedOperationException();
        };
    }
}
