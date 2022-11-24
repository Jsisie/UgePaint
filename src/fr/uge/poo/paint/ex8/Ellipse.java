package fr.uge.poo.paint.ex8;

class Ellipse extends AbstractRectangleEllipse {

    private final int x1, y1, width, height;

    public Ellipse(int x1, int y1, int width, int height) {
        this.x1 = x1;
        this.y1 = y1;
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Canvas graphics, Canvas.CanvasColor color) {
        graphics.drawEllipse(x1, y1, width, height,color);
    }

    @Override
    public WindowSize windowSize() {
        return new WindowSize(x1+width, y1+height);
    }

    @Override
    public String toString() {
        return "{Ellipse, [" + x1 + ":" + y1 + ", " + width + ", " + height + "]}";
    }
}
