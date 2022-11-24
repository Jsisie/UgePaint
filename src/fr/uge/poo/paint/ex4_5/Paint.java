package fr.uge.poo.paint.ex4_5;

import fr.uge.poo.simplegraphics.SimpleGraphics;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Paint {

    private static final List<Form> forms = new ArrayList<>();
    private static Form minForm;

    private static void callback(SimpleGraphics area, int x, int y) {
        area.render(graphics -> {
            graphics.setColor(Color.BLACK);
            graphics.drawRect(x - 18, y - 18, 36, 36);
            minForm.draw(graphics, Color.BLACK);
            minForm = forms.stream().min(Comparator.comparingInt(s -> s.distance(new Point(x, y)))).get();
            minForm.draw(graphics, Color.ORANGE);
//            System.out.println(minForm);
        });
    }

    private static List<String> readForms(String pathFile) throws IOException {
        List<String> list = new ArrayList<>();
        Path path = Paths.get(pathFile);
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(list::add);
        }
        return list;
    }

    private static void parseLines(List<String> list, Graphics2D graphics) {
        list.forEach(line -> {
            String[] tokens = line.split(" ");
            var type = tokens[0];
            var val1 = Integer.parseInt(tokens[1]);
            var val2 = Integer.parseInt(tokens[2]);
            var val3 = Integer.parseInt(tokens[3]);
            var val4 = Integer.parseInt(tokens[4]);
            forms.add(switch (type) {
                case "line" -> new Line(val1, val2, val3, val4);
                case "ellipse" -> new Ellipse(val1, val2, val3, val4);
                case "rectangle" -> new Rectangle(val1, val2, val3, val4);
                case default -> throw new IllegalArgumentException();
            });
            // TODO - nul
            minForm = forms.get(0);
        });
    }

    private static void drawAll(Graphics2D graphics) throws IOException {
        graphics.setColor(Color.BLACK);
        parseLines(readForms("data/draw2.txt"), graphics);
        forms.forEach(line -> line.draw(graphics, Color.BLACK));
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
        area.waitForMouseEvents((x, y) -> callback(area, x, y));
    }
}
