package be.course.design.polymorphism.benefits.businesslogic;

/**
 * This is the most important class in the application. This contains the main business rules
 * for cooking robots. This class contains the main algorithm for
 * the robots, the one that prepares the dishes.
 */
public class Chef {

    private OrderInput orderInput;
    private Dish currentDish;

    public void prepareOrder() {

    }

    private void statusUpdate(Order order) {
        System.out.println("order with id " + order.getId() + " is done.");
    }
}
