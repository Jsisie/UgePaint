package fr.uge.poo.paint.ex8;

import fr.uge.poo.CoolGraphics.CoolGraphics;
import fr.uge.poo.CoolGraphics.CoolGraphics.ColorPlus;

class CoolGraphicAdapter implements Canvas {

    CoolGraphics graphic;

    CoolGraphicAdapter(String name, int width, int height) {
        graphic = new CoolGraphics(name, width, height);
    }

    private ColorPlus transformColor(CanvasColor color) {
        return switch(color) {
            case BLACK -> ColorPlus.BLACK;
            case WHITE -> ColorPlus.WHITE;
            case ORANGE -> ColorPlus.ORANGE;
        };
    }

    @Override
    public void clear(CanvasColor color) {
        graphic.repaint(transformColor(color));
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2, CanvasColor color) {
        graphic.drawLine(x1, y1, x2, y2, transformColor(color));
    }

    @Override
    public void drawEllipse(int x, int y, int width, int height, CanvasColor color) {
        graphic.drawEllipse(x, y, width, height, transformColor(color));
    }

    @Override
    public void waitForMouseClick(MouseClickCallback callback) {
        graphic.waitForMouseEvents(callback::onClick);
    }
}