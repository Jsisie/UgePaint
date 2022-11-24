package fr.uge.poo.Duck;

import fr.uge.poo.ducks.Duck;

import java.util.ServiceLoader;

public class DuckFarm {

    public static void main(String[] args) {
        ServiceLoader<fr.uge.poo.ducks.Duck> loader = ServiceLoader.load(fr.uge.poo.ducks.Duck.class);
        for(Duck duck : loader) System.out.println(duck.quack());
    }
}
