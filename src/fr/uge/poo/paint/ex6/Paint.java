package fr.uge.poo.paint.ex6;

import java.io.IOException;
import java.nio.file.Path;

public class Paint {

    public static void main(String[] args) throws IOException {
        var drawing = Drawing.parseLines(Path.of("data/draw-big.txt"));
        drawing.display("area");
    }
}
