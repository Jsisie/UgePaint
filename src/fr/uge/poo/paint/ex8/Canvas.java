package fr.uge.poo.paint.ex8;

interface Canvas {
    enum CanvasColor {
        BLACK, WHITE, ORANGE
    }

    @FunctionalInterface
    interface MouseClickCallback {
        void onClick(int x, int y);
    }

    void clear(CanvasColor color);

    void drawLine(int x1, int y1, int x2, int y2, CanvasColor color);

    void drawEllipse(int x, int y, int width, int height, CanvasColor color);

    void waitForMouseClick(MouseClickCallback callback);

    default void drawRectangle(int x, int y, int width, int height, CanvasColor color) {
        drawLine(x, y, x+width, y, color);
        drawLine(x, y+height, x+width, y+height, color);
        drawLine(x+width, y, x+width, y+height, color);
        drawLine(x, y, x, y+height, color);
    }
}
