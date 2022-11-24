package fr.uge.poo.paint.ex7;

import java.io.IOException;
import java.nio.file.Path;

public class Paint {

    public static void main(String[] args) throws IOException {
        var drawing = Drawing.parseLines(Path.of("data/draw2.txt"));
        drawing.display("area", args);
    }
}
