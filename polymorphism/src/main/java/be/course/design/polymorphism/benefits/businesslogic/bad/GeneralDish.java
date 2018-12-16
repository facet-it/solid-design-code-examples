package be.course.design.polymorphism.benefits.businesslogic.bad;

import java.util.LinkedList;
import java.util.List;

public class GeneralDish {

    private final List<String> ingredients;

    public GeneralDish(){
        this.ingredients = new LinkedList<>();
    }

    public List<String> getIngredients() {
        return this.ingredients;
    }

    public void prepare() {}
}
