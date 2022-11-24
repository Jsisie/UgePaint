package fr.uge.poo.paint.ex6;

import fr.uge.poo.simplegraphics.SimpleGraphics;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Drawing {

    private static final List<Form> forms = new ArrayList<>();
    private static Window window = Window.getWindow();
    private static Form selectedForm = null;

    public static Drawing parseLines(Path path) throws IOException {
        List<String> list = new ArrayList<>();
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(list::add);
        }
        var drawing = new Drawing();

        list.forEach(line -> {
            String[] tokens = line.split(" ");
            var type = tokens[0];
            var val1 = Integer.parseInt(tokens[1]);
            var val2 = Integer.parseInt(tokens[2]);
            var val3 = Integer.parseInt(tokens[3]);
            var val4 = Integer.parseInt(tokens[4]);
            checkSizeWindow(val1+val3, val2+val4);
            drawing.addShape(switch (type) {
                case "line" -> new Line(val1, val2, val3, val4);
                case "ellipse" -> new Ellipse(val1, val2, val3, val4);
                case "rectangle" -> new Rectangle(val1, val2, val3, val4);
                case default -> throw new UnsupportedOperationException();
            });
        });
        return drawing;
    }

    static void checkSizeWindow(int width, int height) {
        if(window.width()<width || window.height()<height) {
            int max = Math.max(width, height);
            window = new Window(max, max);
        }
    }

    public static void onClick(SimpleGraphics area, int x, int y) {
        area.render(graphics -> {
            if (selectedForm != null)
                selectedForm.draw(graphics, Color.BLACK);
            selectedForm = forms.stream().min(Comparator.comparingInt(s -> s.distance(new Point(x, y)))).get();
            selectedForm.draw(graphics, Color.ORANGE);
        });
    }

    public static void callback(SimpleGraphics area, int x, int y) {
        Drawing.onClick(area, x, y);
    }

    public void addShape(Form form) {
        forms.add(form);
    }

    public void drawAll(Graphics2D graphics) {
        graphics.setColor(Color.BLACK);
        forms.forEach(line -> line.draw(graphics, Color.BLACK));
    }

    public void display(String name) {
        SimpleGraphics area = new SimpleGraphics(name, window.width(), window.height());
        area.clear(Color.WHITE);
        area.render(this::drawAll);
        area.waitForMouseEvents((x, y) -> callback(area, x, y));
    }
}
