package be.course.design.polymorphism.benefits.implementations.bad;

import java.util.LinkedList;
import java.util.List;

public class RegularSteak {

    private final List<String> ingredients;

    public RegularSteak() {
        ingredients = new LinkedList<>();

        ingredients.add("A good steak");
        ingredients.add("Bearnaise");
    }

    public String[] getIngredients() {
        return (String[]) ingredients.toArray();
    }

    public void bakeRare(String rareness) {
        try{
            System.out.println("Barely put it in the pan");
            Thread.sleep(1000);
        }
        catch(InterruptedException interrupted) {
            System.out.println("Got interrupted while baking a regular steak");
        }
    }

}
