package fr.uge.poo.paint.ex3;

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

    private static List<Form> parseLines(List<String> list, Graphics2D graphics) {
        List<Form> lines = new ArrayList<>();

        list.forEach(line -> {
            String[] tokens = line.split(" ");
            var type = tokens[0];
            var val1 = Integer.parseInt(tokens[1]);
            var val2 = Integer.parseInt(tokens[2]);
            var val3 = Integer.parseInt(tokens[3]);
            var val4 = Integer.parseInt(tokens[4]);
            lines.add(switch (type) {
                case "line" -> new Line(val1, val2, val3, val4);
                case "ellipse" -> new Ellipse(val1, val2, val3, val4);
                case "rectangle" -> new Rectangle(val1, val2, val3, val4);
                case default -> throw new IllegalArgumentException();
            });
        });
        return lines;
    }

    private static void drawAll(Graphics2D graphics) throws IOException {
        graphics.setColor(Color.BLACK);
        var draws = parseLines(readForms("data/draw2.txt"), graphics);
        draws.forEach(line -> line.draw(graphics));
    }

    public static void main(String[] args) {
        SimpleGraphics area = new SimpleGraphics("area", 800, 600);
        area.clear(Color.WHITE);
        area.render(graphics -> {
            try {
                drawAll(graphics);
            } catch (IOException e) {
                System.out.println("Problem as occured while reading the file");
            }
        });
    }
}