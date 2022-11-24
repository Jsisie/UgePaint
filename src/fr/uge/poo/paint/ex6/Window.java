package fr.uge.poo.paint.ex6;

record Window(int width, int height) {

    static Window getWindow(int width, int height) {
        if(width<500) width = 500;
        if(height<500) height = 500;
        return new Window(width, height);
    }
    static Window getWindow() {
        return new Window(500, 500);
    }
}
