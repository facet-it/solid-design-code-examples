package be.course.design.polymorphism.benefits.businesslogic.bad;

import java.util.LinkedList;
import java.util.List;

import be.course.design.polymorphism.benefits.businesslogic.good.Dish;
import be.course.design.polymorphism.benefits.implementations.bad.Fries;
import be.course.design.polymorphism.benefits.implementations.bad.RegularSteak;

public class OrderInput {

    private List<Object> menuCard;

    public OrderInput() {
        menuCard = new LinkedList<>();
        menuCard.add(new RegularSteak());
        menuCard.add(new Fries());
    }

    public Order getNextOrder() {
        int random = (int) (Math.random() * 2);

        Order order = new Order(System.currentTimeMillis());
        Object dish = menuCard.get(random);

        order.addDish(dish);

        return order;
    }

}
