package fr.uge.poo.paint.ex9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

class Drawing {

    private static final List<Shape> shapes = new ArrayList<>();
    private static Shape selectedShape = null;

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
            drawing.addShape(switch (type) {
                case "line" -> new Line(val1, val2, val3, val4);
                case "ellipse" -> new Ellipse(val1, val2, val3, val4);
                case "rectangle" -> new Rectangle(val1, val2, val3, val4);
                case default -> throw new UnsupportedOperationException();
            });
        });
        return drawing;
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public WindowSize resizeWindowSize() {
        return shapes.stream().map(Shape::windowSize).reduce(WindowSize::union)
                .orElseThrow(() -> new IllegalStateException(""));
    }

    public void onClick(Canvas area, int x, int y) {
        if (selectedShape != null)
            selectedShape.draw(area, Canvas.CanvasColor.BLACK);
        selectedShape = shapes.stream().min(Comparator.comparingInt(s -> s.distance(new Point(x, y)))).get();
        selectedShape.draw(area, Canvas.CanvasColor.ORANGE);
    }

    public void drawAll(Canvas area) {
        shapes.forEach(line -> line.draw(area, Canvas.CanvasColor.BLACK));
    }
}
