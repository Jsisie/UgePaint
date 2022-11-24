package fr.uge.poo.paint.ex8;

abstract non-sealed class AbstractRectangleEllipse implements Form {
    int x, y, width, height;
    int centerX, centerY;

    private Point center() {
        centerX = (x + (x + width) / 2) / 2;
        centerY = (y + (y + height) / 2) / 2;
        return new Point(x, y);
    }

    public int distance(Point p) {
        return ((center().x() - p.y()) * (center().x() - p.x()))
                + ((center().y() - p.y()) * (center().y() - p.y()));
    }
}
