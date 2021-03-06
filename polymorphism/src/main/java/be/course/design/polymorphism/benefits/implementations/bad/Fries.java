package be.course.design.polymorphism.benefits.implementations.bad;

import java.util.LinkedList;
import java.util.List;

import be.course.design.polymorphism.benefits.businesslogic.bad.GeneralDish;

public class Fries extends GeneralDish {

    private final List<String> ingredients;

    public Fries() {
        ingredients = new LinkedList<>();
        ingredients.add("Potatoes");
    }

    @Override
    public List<String> getIngredients() {
        return new LinkedList<>(ingredients);
    }

    @Override
    public void prepare() {
        System.out.println("Cut the potatoes into fries. Put them into the fryer.");
        try{
            Thread.sleep(1500L);
        }
        catch (InterruptedException interrupted) {
            System.out.println("Got interrupted while cooking");
        }
    }

}
