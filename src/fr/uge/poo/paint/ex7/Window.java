package fr.uge.poo.paint.ex7;

import fr.uge.poo.CoolGraphics.CoolGraphics;
import fr.uge.poo.simplegraphics.SimpleGraphics;

record Window(int width, int height) {

    static Window getWindow() {
        return new Window(500, 500);
    }

    GraphicsManager createWindow(String title, String[] opt) {
        for (String option: opt) {
            return switch (option) {
                case "-legacy" -> new SimpleGraphicsManager(new SimpleGraphics(title, width, height));
                default -> throw new UnsupportedOperationException("unknown option was passed");
            };
        }
        return new CoolGraphicsManager(new CoolGraphics(title, width, height));
    }
}
