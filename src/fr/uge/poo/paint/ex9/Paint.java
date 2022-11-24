package fr.uge.poo.paint.ex9;

import java.io.IOException;
import java.nio.file.Path;

public class Paint {

    public static Canvas createWindow(String[] opt, String name, WindowSize window) {
        for (String option: opt) {
            return switch (option) {
                case "-legacy" -> new SimpleGraphicAdapter(name, window.width(), window.height());
                default -> throw new UnsupportedOperationException("unknown option was passed");
            };
        }
        return new CoolGraphicAdapter(name, window.width(), window.height());
    }

    public static void main(String[] args) throws IOException {
        String pathFile = "data/draw2.txt";
        String name = "area";

        var drawing = Drawing.parseLines(Path.of(pathFile));
        var window = drawing.resizeWindowSize().union(new WindowSize(500,500));

        var canvas = createWindow(args, name, window);
        drawing.drawAll(canvas);
        canvas.render();

        canvas.waitForMouseClick((x,y) -> drawing.onClick(canvas, x, y));
    }
}
