package fr.uge.poo.paint.ex7;

import fr.uge.poo.simplegraphics.SimpleGraphics;

import java.awt.*;
import java.util.function.Consumer;

sealed interface GraphicsManager permits CoolGraphicsManager, SimpleGraphicsManager {

    void clear(Color color);
    void render(Consumer<Graphics2D> consumer);
    void mouseEvents();
}
