package fr.uge.poo.paint.ex8;

import fr.uge.poo.simplegraphics.SimpleGraphics;

import java.awt.*;

class SimpleGraphicAdapter implements Canvas {

    SimpleGraphics graphic;

    SimpleGraphicAdapter(String name, int width, int height) {
        graphic = new SimpleGraphics(name, width, height);
    }

    private Color transformColor(CanvasColor color) {
        return switch(color) {
            case BLACK -> Color.BLACK;
            case WHITE -> Color.WHITE;
            case ORANGE -> Color.ORANGE;
        };
    }

    @Override
    public void clear(CanvasColor color) {
        graphic.clear(transformColor(color));
    }

    @Override
    public void drawRectangle(int x, int y, int width, int height, CanvasColor color) {
        graphic.render(graphics2D -> {
            graphics2D.setColor(transformColor(color));
            graphics2D.drawRect(x, y, width, height);
        });
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2, CanvasColor color) {
        graphic.render(graphics2D -> {
            graphics2D.setColor(transformColor(color));
            graphics2D.drawLine(x1, y1, x2, y2);
        });
    }

    @Override
    public void drawEllipse(int x, int y, int width, int height, CanvasColor color) {
        graphic.render(graphics2D -> {
            graphics2D.setColor(transformColor(color));
            graphics2D.drawOval(x, y, width, height);
        });
    }

    @Override
    public void waitForMouseClick(MouseClickCallback callback) {
        graphic.waitForMouseEvents(callback::onClick);
    }

}
