package fr.uge.poo.paint.ex8;

record WindowSize(int width, int height) {
    public WindowSize union(WindowSize ws) {
        var x = Math.max(width, ws.width);
        var y = Math.max(height, ws.height);
        var z = Math.max(x, y);
        return new WindowSize(z, z);
    }
}
