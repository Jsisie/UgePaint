package fr.uge.poo.paint.ex7;

import fr.uge.poo.CoolGraphics.CoolGraphics;

public class CoolGraphicsExample {

    public static void main(String[] args) {
            CoolGraphics area = new CoolGraphics("Example",800,600);
            area.repaint(CoolGraphics.ColorPlus.WHITE);
            // il n'y a pas de méthode pour tracer un rectangle, il faut le faire à la main
            area.drawLine(100,20,140, 20, CoolGraphics.ColorPlus.BLACK);
            area.drawLine(100,160,140, 160, CoolGraphics.ColorPlus.BLACK);
            area.drawLine(100,20,100, 160, CoolGraphics.ColorPlus.BLACK);
            area.drawLine(140,20,140, 160, CoolGraphics.ColorPlus.BLACK);

            area.drawLine(100, 20, 140, 160, CoolGraphics.ColorPlus.BLACK);
            area.drawLine(100, 160, 140, 20, CoolGraphics.ColorPlus.BLACK);

            area.drawEllipse(100, 20, 40, 140, CoolGraphics.ColorPlus.BLACK);

            area.waitForMouseEvents((x,y) -> System.out.println("Click on ("+x+","+y+")"));
    }

}
