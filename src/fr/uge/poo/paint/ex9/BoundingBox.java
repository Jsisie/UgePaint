package fr.uge.poo.paint.ex9;

class BoundingBox {
    int x;
    int y;
    int width;
    int height;

    BoundingBox(int x1, int y1, int width, int height) {
        this.x = x1;
        this.y = y1;
        this.width = width;
        this.height = height;
    }

    private Point getCenter() {
        int x1 = (x + (x + width)) / 2;
        int y1 = (y + (y + height)) / 2;
        return new Point(x1, y1);
    }

    public int distance(int x1, int y1) {
        var point = this.getCenter();
        var cx = point.x();
        var cy = point.y();
        return (cx - x1) * (cx - x1) + (cy - y1) * (cy - y1);
    }
}
