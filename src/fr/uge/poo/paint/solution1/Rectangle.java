package fr.uge.poo.paint.solution1;

non-sealed class Rectangle implements Shape {

    private final int x, y, width, height;
    private final BoundingBox bb;

    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.bb = new BoundingBox(x, y, width, height);
    }

    @Override
    public void draw(Canvas graphics, Canvas.CanvasColor color) {
        graphics.drawRectangle(x, y, width, height, color);
    }

    @Override
    public int distance(Point p) {
        return bb.distance(p.x(), p.y());
    }

    @Override
    public WindowSize windowSize() {
        return new WindowSize(x + width, y + height);
    }

    @Override
    public String toString() {
        return "{Rectangle, [" + x + ":" + y + ", " + width + ", " + height + "]}";
    }
}
