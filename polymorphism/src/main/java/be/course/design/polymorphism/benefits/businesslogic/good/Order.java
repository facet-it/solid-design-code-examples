package be.course.design.polymorphism.benefits.businesslogic.good;

import java.util.LinkedList;
import java.util.List;

import be.course.design.polymorphism.benefits.businesslogic.good.Dish;

public class Order {
    private final long id;
    private List<Dish> dishes;

    public Order(long id) {
        this.id = id;
        dishes = new LinkedList<>();
    }

    public long getId() {
        return id;
    }

    public void addDish(Dish dish){
        this.dishes.add(dish);
    }

    public List<Dish> getDishes() {
        return new LinkedList<>(dishes);
    }
}
