package be.course.design.polymorphism.benefits.implementations.good;

import java.util.LinkedList;
import java.util.List;

import be.course.design.polymorphism.benefits.businesslogic.good.Dish;

public class ChickenSalad implements Dish {

    private final List<String> ingredients;

    public ChickenSalad() {
        ingredients = new LinkedList<>();

        ingredients.add("salad");
        ingredients.add("Chicken breast");
        ingredients.add("Cucumber");
        ingredients.add("Paprika");
        ingredients.add("Peper");
        ingredients.add("Olive oil");
        ingredients.add("Salt");
    }

    @Override
    public List<String> getIngredients() {
        return new LinkedList<>(ingredients);
    }

    @Override
    public void prepare() {
        System.out.println("Slice the vegetables, bake the chicken, mingle in a bowl, add salt and pepper and olive oil");

        try{
            Thread.sleep(1500L);
        }
        catch(InterruptedException interrupted) {
            System.out.println("Interrupted while preparing food");
        }
    }
}
