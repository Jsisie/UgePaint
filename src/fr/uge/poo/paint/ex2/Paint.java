package fr.uge.poo.paint.ex2;

import fr.uge.poo.simplegraphics.SimpleGraphics;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Paint {

    private static List<String> readForms(String pathFile) throws IOException {
        List<String> list = new ArrayList<>();
        Path path = Paths.get(pathFile);
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(list::add);
        }
        return list;
    }

    private static List<Line> parseLines(List<String> list, Graphics2D graphics) {
        var lines = new ArrayList<Line>();
        list.forEach(line -> {
            String[] tokens = line.split(" ");
            int x1 = Integer.parseInt(tokens[1]);
            int y1 = Integer.parseInt(tokens[2]);
            int x2 = Integer.parseInt(tokens[3]);
            int y2 = Integer.parseInt(tokens[4]);
            lines.add(new Line(x1,y1,x2,y2));
        });
        return lines;
    }

    private static void drawAll(Graphics2D graphics) throws IOException {
        graphics.setColor(Color.BLACK);
        var draws = parseLines(readForms("data/draw1.txt"), graphics);
        draws.forEach(line -> line.draw(graphics));
    }

    public static void main(String[] args) {
        SimpleGraphics area = new SimpleGraphics("area", 800, 600);
        area.clear(Color.WHITE);
        area.render(graphics -> {
            try {
                drawAll(graphics);
            } catch (IOException e) {

            }
        });
    }
}
