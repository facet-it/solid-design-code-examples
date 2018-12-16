package be.course.design.polymorphism.benefits.businesslogic.good;

import java.util.LinkedList;
import java.util.List;

import be.course.design.polymorphism.benefits.implementations.good.ChickenSalad;
import be.course.design.polymorphism.benefits.implementations.good.Fries;

public class OrderInput {

    private List<Dish> menuCard;

    public OrderInput() {
        menuCard = new LinkedList<>();
        menuCard.add(new ChickenSalad());
        menuCard.add(new Fries());
    }

    public Order getNextOrder() {
        int random = (int) (Math.random() * 2);

        Order order = new Order(System.currentTimeMillis());
        Dish dish = menuCard.get(random);

        order.addDish(dish);

        return order;
    }

}
