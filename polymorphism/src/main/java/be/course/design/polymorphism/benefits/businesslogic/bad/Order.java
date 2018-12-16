package be.course.design.polymorphism.benefits.businesslogic.bad;

import java.util.LinkedList;
import java.util.List;

public class Order {
    private final long id;
    private List<Object> dishes;

    public Order(long id) {
        this.id = id;
        dishes = new LinkedList<>();
    }

    public long getId() {
        return id;
    }

    public void addDish(Object dish){
        this.dishes.add(dish);
    }

    public List<Object> getDishes() {
        return new LinkedList<>(dishes);
    }
}
