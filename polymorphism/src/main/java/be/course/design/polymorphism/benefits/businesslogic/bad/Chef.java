package be.course.design.polymorphism.benefits.businesslogic.bad;

import java.util.Arrays;
import java.util.List;

import be.course.design.polymorphism.benefits.implementations.bad.Fries;
import be.course.design.polymorphism.benefits.implementations.bad.RegularSteak;

public class Chef {

    private OrderInput orderInput;

    public Chef() {
        orderInput = new OrderInput();
    }

    /**
     * The algorithm goes as following:
     *  1. get next order
     *  2. for each meal to prepare, get the ingredients
     *  3. check if you have all the ingredients in house
     *  4. prepare the meal
     *  5. signal when ready with an order.
     */
    public void work() {
        for(int i = 20; i > 0; i--) {
            Order order = orderInput.getNextOrder();

            for(Object dish : order.getDishes()) {
                if(dish instanceof Fries) {
                    Fries fries = (Fries) dish;
                    List<String> ingredients = fries.getIngredients();

                    if(haveAllIngredients(ingredients)) {
                        fries.prepare();
                    }
                }

                else if(dish instanceof RegularSteak) {
                    RegularSteak steak = (RegularSteak) dish;
                    String[] ingredients = steak.getIngredients();

                    if(haveAllIngredients(Arrays.asList(ingredients))) {
                        steak.bakeRare("rare");
                    }
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
