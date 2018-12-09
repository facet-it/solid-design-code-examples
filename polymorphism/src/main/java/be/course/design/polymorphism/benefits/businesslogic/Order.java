package be.course.design.polymorphism.benefits.businesslogic;

import java.util.List;

public class Order {
    private final int id;
    private List<Dish> dishes;

    public Order(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void addDish(Dish dish){
        this.dishes.add(dish);
    }
}
