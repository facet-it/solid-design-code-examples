package be.course.design.polymorphism.benefits.businesslogic.good;

import java.util.List;

/**
 * This is the most important class in the application. This contains the main business rules
 * for cooking robots. This class contains the main algorithm for
 * the robots, the one that prepares the dishes.
 */
public class Chef {

    private OrderInput orderInput;

    public Chef() {
        orderInput = new OrderInput();
    }

    public void work() {
        for(int i = 20; i > 0; i--) {
            Order order = orderInput.getNextOrder();

            for(Dish dish : order.getDishes()) {
                List<String> ingredients = dish.getIngredients();
                if(haveAllIngredients(ingredients)) {
                    dish.prepare();
                }
            }

            statusUpdate(order);
        }
    }

    private boolean haveAllIngredients(List<String> ingredients) {
        System.out.println("Checking ingredients");
        return true;
    }

    private void statusUpdate(Order order) {
        System.out.println("order with id " + order.getId() + " is done.");
    }
}
