package fr.uge.poo.Duck;

import fr.uge.poo.ducks.Duck;
import fr.uge.poo.ducks.DuckFactory;

import java.util.ArrayList;
import java.util.ServiceLoader;

public class DuckFarmBetter {
    public static void main(String[] args) {
        var ducks = new ArrayList<Duck>();
        ServiceLoader<DuckFactory> loader = ServiceLoader.load(DuckFactory.class);
        loader.stream().forEach((x)->{
            ducks.add(x.get().withName("Riri"));
            ducks.add(x.get().withName("Fifi"));
            ducks.add(x.get().withName("Loulou"));
        });
        ducks.forEach(duck->System.out.println(duck.quack()));
    }
}
