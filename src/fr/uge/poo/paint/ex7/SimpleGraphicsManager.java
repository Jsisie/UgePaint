package fr.uge.poo.paint.ex7;

import fr.uge.poo.simplegraphics.SimpleGraphics;

import java.awt.*;
import java.util.Objects;
import java.util.function.Consumer;

non-sealed class SimpleGraphicsManager implements GraphicsManager {
    SimpleGraphics graphic;

    SimpleGraphicsManager (SimpleGraphics graphic) {
        Objects.requireNonNull(graphic);
        this.graphic = graphic;
    }

    @Override
    public void clear(Color color) {
        graphic.clear(Color.WHITE);
    }

    @Override
    public void render(Consumer<Graphics2D> consumer) {
        graphic.render(consumer);
    }

    @Override
    public void mouseEvents() {
        graphic.waitForMouseEvents((x, y) -> Drawing.onClick(this, new Point(x, y)));
    }
}
