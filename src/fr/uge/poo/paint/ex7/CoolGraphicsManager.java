package fr.uge.poo.paint.ex7;

import fr.uge.poo.CoolGraphics.CoolGraphics;
import fr.uge.poo.simplegraphics.SimpleGraphics;

import java.awt.*;
import java.util.Objects;
import java.util.function.Consumer;

non-sealed class CoolGraphicsManager implements GraphicsManager{
    CoolGraphics graphic;

    CoolGraphicsManager(CoolGraphics graphic) {
        Objects.requireNonNull(graphic);
        this.graphic = graphic;
    }

    @Override
    public void clear(Color color) {
        graphic.repaint(CoolGraphics.ColorPlus.WHITE);
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
