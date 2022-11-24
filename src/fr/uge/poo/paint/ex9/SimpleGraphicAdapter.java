package fr.uge.poo.paint.ex9;

import fr.uge.poo.simplegraphics.SimpleGraphics;

import java.awt.*;
import java.util.function.Consumer;


class SimpleGraphicAdapter implements Canvas {

    private final SimpleGraphics graphic;
    private Consumer<Graphics2D> consumer = Graphics2D -> {};

    SimpleGraphicAdapter(String name, int width, int height) {
        graphic = new SimpleGraphics(name, width, height);
    }

    private Color transformColor(CanvasColor color) {
        return switch (color) {
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
        this.consumer = consumer.andThen(graphics2D -> {
            graphics2D.setColor(transformColor(color));
            graphics2D.drawRect(x, y, width, height);
        });
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2, CanvasColor color) {
        this.consumer = consumer.andThen(graphics2D -> {
            graphics2D.setColor(transformColor(color));
            graphics2D.drawLine(x1, y1, x2, y2);
        });
    }

    @Override
    public void drawEllipse(int x, int y, int width, int height, CanvasColor color) {
        this.consumer = consumer.andThen(graphics2D -> {
            graphics2D.setColor(transformColor(color));
            graphics2D.drawOval(x, y, width, height);
        });
    }

    @Override
    public void waitForMouseClick(MouseClickCallback callback) {
        graphic.waitForMouseEvents(callback::onClick);
    }

    @Override
    public void render() {
        graphic.render(consumer);
    }
}
